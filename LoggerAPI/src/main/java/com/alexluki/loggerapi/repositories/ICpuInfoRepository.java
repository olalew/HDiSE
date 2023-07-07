package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.CpuInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICpuInfoRepository extends JpaRepository<CpuInfoEntity, UUID> {
    List<CpuInfoEntity> findByDevice_DeviceId(UUID deviceId);
}
