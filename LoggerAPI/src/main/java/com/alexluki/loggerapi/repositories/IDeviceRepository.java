package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDeviceRepository extends JpaRepository<DeviceEntity, Long> {
    DeviceEntity findByDeviceId(UUID deviceId);
}
