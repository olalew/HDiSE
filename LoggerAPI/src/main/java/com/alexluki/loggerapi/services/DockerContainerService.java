package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.dbmodels.DockerContainerEntity;
import com.alexluki.loggerapi.dtos.DockerContainerStatusUpdateDTO;
import com.alexluki.loggerapi.repositories.IDeviceRepository;
import com.alexluki.loggerapi.repositories.IDockerContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DockerContainerService {

    private final IDockerContainerRepository dockerContainerRepository;
    private final IDeviceRepository deviceRepository;

    @Autowired
    public DockerContainerService(IDockerContainerRepository dockerContainerRepository, IDeviceRepository deviceRepository) {
        this.dockerContainerRepository = dockerContainerRepository;
        this.deviceRepository = deviceRepository;
    }

    public List<DockerContainerEntity> getContainersByDeviceId(UUID deviceId) {
        return dockerContainerRepository.findByDeviceEntity_DeviceId(deviceId);
    }

    public DockerContainerEntity getContainerByDeviceIdAndContainerId(UUID deviceId, UUID containerId) {
        return dockerContainerRepository.findByDeviceEntity_DeviceIdAndId(deviceId, containerId);
    }

    @Transactional
    public DockerContainerEntity saveContainer(UUID deviceId, DockerContainerEntity container) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
           throw new IllegalArgumentException("Device with ID " + deviceId + " does not exist");
        }

        container.setDeviceEntity(device);
        return dockerContainerRepository.save(container);
    }

    @Transactional
    public List<DockerContainerEntity> saveContainers(UUID deviceId, List<DockerContainerEntity> containers) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
            throw new IllegalArgumentException("Device with ID " + deviceId + " does not exist");
        }

        containers.forEach(container -> {
            container.setDeviceEntity(device);
        });

        return dockerContainerRepository.saveAll(containers);
    }

    @Transactional
    public DockerContainerEntity updateContainerStatus(UUID deviceId, DockerContainerStatusUpdateDTO statusUpdate) {
        DockerContainerEntity container = dockerContainerRepository.findByDeviceEntity_DeviceIdAndContainerId(deviceId, statusUpdate.getContainerId());
        if (container == null) {
            throw new IllegalArgumentException("Container with ID " + statusUpdate.getContainerId() + " does not exist for the specified device");
        }

        if ("gone".equalsIgnoreCase(statusUpdate.getStatus())) {
            container.setStatus(statusUpdate.getStatus());
            container.setRemovalDate(LocalDateTime.now());
            container.setPresent(false);
        }

        return dockerContainerRepository.save(container);
    }
}
