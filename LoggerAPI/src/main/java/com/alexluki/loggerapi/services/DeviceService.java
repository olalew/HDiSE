package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.repositories.IDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final IDeviceRepository deviceRepository;

    @Autowired
    public DeviceService(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceEntity saveDevice(DeviceEntity device) {
        return deviceRepository.save(device);
    }

    public Optional<DeviceEntity> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    public List<DeviceEntity> getAllDevices() {
        return deviceRepository.findAll();
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
