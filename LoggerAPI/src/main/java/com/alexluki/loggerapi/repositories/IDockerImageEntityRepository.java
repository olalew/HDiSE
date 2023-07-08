package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.DockerImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDockerImageEntityRepository extends JpaRepository<DockerImageEntity, UUID> {
    List<DockerImageEntity> findByDeviceEntity_DeviceId(UUID deviceId);
    Optional<DockerImageEntity> findByImageIdAndDeviceEntity_DeviceId(String imageId, UUID deviceId);
}