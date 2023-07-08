package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.dbmodels.ProcessInfoEntity;
import com.alexluki.loggerapi.repositories.IDeviceRepository;
import com.alexluki.loggerapi.repositories.IProcessInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Service
public class ProcessInfoService {

    private final IProcessInfoRepository processInfoRepository;
    private final IDeviceRepository deviceRepository;

    @Autowired
    public ProcessInfoService(IProcessInfoRepository processInfoRepository, IDeviceRepository deviceRepository) {
        this.processInfoRepository = processInfoRepository;
        this.deviceRepository = deviceRepository;
    }

    public ProcessInfoEntity saveProcessInfo(ProcessInfoEntity processInfo, UUID deviceId) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found");
        }
        processInfo.setDevice(device);
        return processInfoRepository.save(processInfo);
    }

    public Page<ProcessInfoEntity> getProcessesByDeviceId(UUID deviceId, Pageable pageable) {
        return processInfoRepository.findByDevice_DeviceId(deviceId, pageable);
    }

    public ProcessInfoEntity getProcessByIdAndDeviceId(UUID id, UUID deviceId) {
        return processInfoRepository.findByIdAndDevice_DeviceId(id, deviceId);
    }

    public List<ProcessInfoEntity> saveAllProcessInfo(List<ProcessInfoEntity> processInfoList, UUID deviceId) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found");
        }
        processInfoList.forEach(processInfo -> processInfo.setDevice(device));
        return processInfoRepository.saveAll(processInfoList);
    }
}
