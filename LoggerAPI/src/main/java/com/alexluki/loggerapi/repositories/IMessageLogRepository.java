package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.MessageLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IMessageLogRepository extends JpaRepository<MessageLogEntity, Long> {

    Page<MessageLogEntity> findByDevice_DeviceId(UUID deviceId, Pageable pageable);

    List<MessageLogEntity> findByDevice_DeviceId(UUID deviceId);

}
