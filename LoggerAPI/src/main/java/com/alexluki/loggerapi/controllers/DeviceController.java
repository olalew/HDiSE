package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.DeviceEntity;
import com.alexluki.loggerapi.services.DeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<DeviceEntity> createDevice(@Valid @RequestBody DeviceEntity device) {
        return new ResponseEntity<>(deviceService.saveDevice(device), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceEntity> getDevice(@PathVariable Long id) {
        return deviceService.getDeviceById(id)
                .map(device -> new ResponseEntity<>(device, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<DeviceEntity>> getAllDevices() {
        return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
    }
}
