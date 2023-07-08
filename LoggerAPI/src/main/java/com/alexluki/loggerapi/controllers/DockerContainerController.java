package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.DockerContainerEntity;
import com.alexluki.loggerapi.dtos.DockerContainerStatusUpdateDTO;
import com.alexluki.loggerapi.services.DockerContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dockerContainers")
public class DockerContainerController {

    private final DockerContainerService dockerContainerService;

    @Autowired
    public DockerContainerController(DockerContainerService dockerContainerService) {
        this.dockerContainerService = dockerContainerService;
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<List<DockerContainerEntity>> getContainersByDeviceId(@PathVariable UUID deviceId) {
        List<DockerContainerEntity> containers = dockerContainerService.getContainersByDeviceId(deviceId);
        return new ResponseEntity<>(containers, HttpStatus.OK);
    }

    @GetMapping("/{deviceId}/{containerId}")
    public ResponseEntity<DockerContainerEntity> getContainerByDeviceIdAndContainerId(@PathVariable UUID deviceId,
                                                                                      @PathVariable UUID containerId) {
        DockerContainerEntity container = dockerContainerService.getContainerByDeviceIdAndContainerId(deviceId, containerId);
        if (container == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(container, HttpStatus.OK);
    }

    @PostMapping("/{deviceId}")
    public ResponseEntity<DockerContainerEntity> saveContainer(@PathVariable UUID deviceId,
                                                               @RequestBody DockerContainerEntity container) {
        DockerContainerEntity savedContainer = dockerContainerService.saveContainer(deviceId, container);
        return new ResponseEntity<>(savedContainer, HttpStatus.CREATED);
    }

    @PostMapping("/batch/{deviceId}")
    public ResponseEntity<List<DockerContainerEntity>> saveContainers(@PathVariable UUID deviceId,
                                                                      @RequestBody List<DockerContainerEntity> containers) {
        List<DockerContainerEntity> savedContainers = dockerContainerService.saveContainers(deviceId, containers);
        return new ResponseEntity<>(savedContainers, HttpStatus.CREATED);
    }

    @PutMapping("/status/{deviceId}")
    public ResponseEntity<DockerContainerEntity> updateContainerStatus(@PathVariable UUID deviceId,
                                                                       @RequestBody DockerContainerStatusUpdateDTO statusUpdate) {
        DockerContainerEntity updatedContainer = dockerContainerService.updateContainerStatus(deviceId, statusUpdate);
        if (updatedContainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedContainer, HttpStatus.OK);
    }

}