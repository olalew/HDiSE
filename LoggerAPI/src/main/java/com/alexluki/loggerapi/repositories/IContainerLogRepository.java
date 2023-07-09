package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.ContainerLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IContainerLogRepository extends JpaRepository<ContainerLogEntity, UUID> {
    // Additional methods can be added here if needed
}