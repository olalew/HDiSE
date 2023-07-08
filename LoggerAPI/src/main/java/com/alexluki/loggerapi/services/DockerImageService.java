package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.dbmodels.DockerImageEntity;
import com.alexluki.loggerapi.dtos.DockerImageStatusUpdateDTO;
import com.alexluki.loggerapi.repositories.IDeviceRepository;
import com.alexluki.loggerapi.repositories.IDockerImageEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DockerImageService {

    private final IDockerImageEntityRepository repository;
    private final IDeviceRepository deviceRepository;

    @Autowired
    public DockerImageService(IDockerImageEntityRepository repository,
                                    IDeviceRepository deviceRepository) {
        this.repository = repository;
        this.deviceRepository = deviceRepository;
    }

    public DockerImageEntity saveDockerImage(UUID deviceId, DockerImageEntity image) {
        DeviceEntity deviceEntity = deviceRepository.findByDeviceId(deviceId);
        if (deviceEntity == null) {
            throw new IllegalArgumentException("No such device found with id: " + deviceId);
        }

        image.setDeviceEntity(deviceEntity);
        image.setRecordCreationDate(LocalDateTime.now());

        Optional<DockerImageEntity> existingImage = repository.findByImageIdAndDeviceEntity_DeviceId(image.getImageId(), deviceId);

        if (existingImage.isPresent() && existingImage.get().getRemovalDate() != null) {
            DockerImageEntity existingEntity = existingImage.get();
            existingEntity.setIsPresent(true);
            existingEntity.setRemovalDate(null);
            existingEntity.setRecordCreationDate(LocalDateTime.now());
            return repository.save(existingEntity);
        }
        return repository.save(image);
    }

    @Transactional
    public DockerImageEntity updateDockerImageStatus(UUID deviceId, DockerImageStatusUpdateDTO statusUpdate) {
        DockerImageEntity existingImage = repository.findByImageIdAndDeviceEntity_DeviceId(statusUpdate.getId(), deviceId)
                .orElseThrow(() -> new IllegalArgumentException("No image found with id: " + statusUpdate.getId() + " for device id: " + deviceId));

        if ("gone".equalsIgnoreCase(statusUpdate.getStatus())) {
            existingImage.setIsPresent(false);
            existingImage.setRemovalDate(LocalDateTime.now());
        }
        return repository.save(existingImage);
    }

    @Transactional
    public List<DockerImageEntity> updateDockerImageStatus(UUID deviceId, List<DockerImageStatusUpdateDTO> statusUpdates) {
        List<DockerImageEntity> updatedImages = new ArrayList<>();
        for (DockerImageStatusUpdateDTO statusUpdate : statusUpdates) {
            DockerImageEntity updatedImage = updateDockerImageStatus(deviceId, statusUpdate);
            updatedImages.add(updatedImage);
        }
        return updatedImages;
    }

    @Transactional
    public List<DockerImageEntity> saveDockerImages(UUID deviceId, List<DockerImageEntity> images) {
        for (DockerImageEntity image : images) {
            saveDockerImage(deviceId, image);
        }
        return images;
    }

    @Transactional
    public List<DockerImageEntity> getDockerImagesByDeviceId(UUID deviceId) {
        return repository.findByDeviceEntity_DeviceId(deviceId);
    }
}
