package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.DockerImageEntity;
import com.alexluki.loggerapi.dtos.DockerImageStatusUpdateDTO;
import com.alexluki.loggerapi.services.DockerImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dockerImages")
public class DockerImageController {

    private final DockerImageService dockerImageEntityService;

    @Autowired
    public DockerImageController(DockerImageService dockerImageEntityService) {
        this.dockerImageEntityService = dockerImageEntityService;
    }

    @PostMapping("/{deviceId}")
    public ResponseEntity<DockerImageEntity> saveDockerImage(@PathVariable UUID deviceId,
                                                             @RequestBody DockerImageEntity image) {
        DockerImageEntity savedImage = dockerImageEntityService.saveDockerImage(deviceId, image);
        return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
    }

    @PostMapping("/batch/{deviceId}")
    public ResponseEntity<List<DockerImageEntity>> saveDockerImages(@PathVariable UUID deviceId,
                                                                    @RequestBody List<DockerImageEntity> images) {
        List<DockerImageEntity> savedImages = dockerImageEntityService.saveDockerImages(deviceId, images);
        return new ResponseEntity<>(savedImages, HttpStatus.CREATED);
    }

    @PutMapping("/status/{deviceId}")
    public ResponseEntity<DockerImageEntity> updateDockerImageStatus(@PathVariable UUID deviceId,
                                                                     @RequestBody DockerImageStatusUpdateDTO statusUpdate) {
        DockerImageEntity updatedImage = dockerImageEntityService.updateDockerImageStatus(deviceId, statusUpdate);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    @PutMapping("/status/batch/{deviceId}")
    public ResponseEntity<List<DockerImageEntity>> updateDockerImageStatus(@PathVariable UUID deviceId,
                                                                           @RequestBody List<DockerImageStatusUpdateDTO> statusUpdates) {
        List<DockerImageEntity> updatedImages = dockerImageEntityService.updateDockerImageStatus(deviceId, statusUpdates);
        return new ResponseEntity<>(updatedImages, HttpStatus.OK);
    }


    @GetMapping("/{deviceId}")
    public ResponseEntity<List<DockerImageEntity>> getDockerImagesByDeviceId(@PathVariable UUID deviceId) {
        List<DockerImageEntity> dockerImages = dockerImageEntityService.getDockerImagesByDeviceId(deviceId);
        return new ResponseEntity<>(dockerImages, HttpStatus.OK);
    }

}
