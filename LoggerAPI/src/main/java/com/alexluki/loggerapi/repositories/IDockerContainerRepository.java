package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.DockerContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDockerContainerRepository extends JpaRepository<DockerContainerEntity, UUID> {

    List<DockerContainerEntity> findByDeviceEntity_DeviceId(UUID deviceId);

    DockerContainerEntity findByDeviceEntity_DeviceIdAndId(UUID deviceId, UUID containerId);
    DockerContainerEntity findByDeviceEntity_DeviceIdAndContainerId(UUID deviceId, String containerId);
}
