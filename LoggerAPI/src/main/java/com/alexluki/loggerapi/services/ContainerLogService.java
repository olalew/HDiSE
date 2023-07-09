package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.ContainerLogEntity;
import com.alexluki.loggerapi.dbmodels.DockerContainerEntity;
import com.alexluki.loggerapi.dtos.ContainerLogDTO;
import com.alexluki.loggerapi.repositories.IContainerLogRepository;
import com.alexluki.loggerapi.repositories.IDockerContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContainerLogService {

    private final IContainerLogRepository containerLogRepository;
    private final IDockerContainerRepository dockerContainerRepository;

    @Autowired
    public ContainerLogService(IContainerLogRepository containerLogRepository,
                               IDockerContainerRepository dockerContainerRepository) {
        this.containerLogRepository = containerLogRepository;
        this.dockerContainerRepository = dockerContainerRepository;
    }

    @Transactional
    public void saveContainerLogs(ContainerLogDTO containerLogDTO, UUID deviceId) {
        DockerContainerEntity container = dockerContainerRepository.findByDeviceEntity_DeviceIdAndContainerId(
            deviceId, containerLogDTO.getContainerId()
        );
        if (container == null) {
            throw new IllegalArgumentException("Container with ID " + containerLogDTO.getContainerId() +
                    " does not exist for the specified device");
        }

        List<ContainerLogEntity> containerLogs = new ArrayList<>();
        for (String logContent : containerLogDTO.getLogs()) {

            String[] parts = logContent.split(" ", 2); // Split the log message into two parts based on the first space
            if (parts.length == 2) {
                String timestampPart = parts[0];
                String content = parts[1];
                LocalDateTime timestamp = null;
                // Parse the timestamp from the timestamp part
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSX");
                    timestamp = LocalDateTime.parse(timestampPart, formatter);
                } catch (DateTimeParseException e) {
                    // Handle parsing error if necessary
                }

                ContainerLogEntity log = new ContainerLogEntity();
                log.setContent(content);
                log.setTimestamp(timestamp);
                log.setContainer(container);

                containerLogs.add(log);
            }
        }

        containerLogRepository.saveAll(containerLogs);
    }

    @Transactional
    public void saveContainerLogs(List<ContainerLogDTO> containerLogDTOs, UUID deviceId) {
        containerLogDTOs.forEach(containerLogDTO -> {
            saveContainerLogs(containerLogDTO, deviceId);
        });
    }
}
