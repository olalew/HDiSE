package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.CpuInfoEntity;
import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.repositories.ICpuInfoRepository;
import com.alexluki.loggerapi.repositories.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CpuInfoService {

    private final ICpuInfoRepository cpuInfoRepository;
    private final IDeviceRepository deviceRepository;

    @Autowired
    public CpuInfoService(ICpuInfoRepository cpuInfoRepository, IDeviceRepository deviceRepository) {
        this.cpuInfoRepository = cpuInfoRepository;
        this.deviceRepository = deviceRepository;
    }

    public CpuInfoEntity saveCpuInfo(CpuInfoEntity cpuInfo, UUID deviceId) {
        DeviceEntity device = deviceRepository.findByDeviceId(deviceId);
        if (device == null) {
            throw new IllegalArgumentException("Device with id " + deviceId + " not found");
        }
        cpuInfo.setDevice(device);
        return cpuInfoRepository.save(cpuInfo);
    }

    public List<CpuInfoEntity> getCpuInfoByDeviceId(UUID deviceId) {
        return cpuInfoRepository.findByDevice_DeviceId(deviceId);
    }

    public CpuInfoEntity getCpuInfoById(UUID id) {
        return cpuInfoRepository.findById(id).orElse(null);
    }
}
