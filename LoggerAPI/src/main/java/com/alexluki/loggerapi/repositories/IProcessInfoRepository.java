package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.ProcessInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProcessInfoRepository extends JpaRepository<ProcessInfoEntity, UUID> {

    Page<ProcessInfoEntity> findByDevice_DeviceId(UUID deviceId, Pageable pageable);

    ProcessInfoEntity findByIdAndDevice_DeviceId(UUID id, UUID deviceId);
}
