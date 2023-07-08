package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.dbmodels.MessageLogEntity;
import com.alexluki.loggerapi.exceptions.DeviceNotFoundException;
import com.alexluki.loggerapi.repositories.IDeviceRepository;
import com.alexluki.loggerapi.repositories.IMessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageLogService {

    private final IMessageLogRepository logEntryRepository;
    private final IDeviceRepository deviceRepository;

    @Autowired
    public MessageLogService(IMessageLogRepository logEntryRepository, IDeviceRepository deviceRepository) {
        this.logEntryRepository = logEntryRepository;
        this.deviceRepository = deviceRepository;
    }

    public MessageLogEntity saveLogEntry(MessageLogEntity logEntry, UUID deviceId) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
            throw new DeviceNotFoundException("Device not found with ID: " + deviceId);
        }
        logEntry.setDevice(device);
        return logEntryRepository.save(logEntry);
    }

    public List<MessageLogEntity> saveLogs(List<MessageLogEntity> logs, UUID deviceId) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
            throw new DeviceNotFoundException("Device not found with ID: " + deviceId);
        }

        logs.forEach(log -> {
            log.setDevice(device);
        });
        return logEntryRepository.saveAll(logs);
    }

    public Page<MessageLogEntity> getLogsByDeviceId(UUID deviceId, Pageable pageable) {
        return logEntryRepository.findByDevice_DeviceId(deviceId, pageable);
    }

    public List<MessageLogEntity> getLogsByDeviceId(UUID deviceId) {
        return logEntryRepository.findByDevice_DeviceId(deviceId);
    }
}
