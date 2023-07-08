package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.ProcessInfoEntity;
import com.alexluki.loggerapi.services.ProcessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/processinfo")
public class ProcessInfoController {

    private final ProcessInfoService processInfoService;

    @Autowired
    public ProcessInfoController(ProcessInfoService processInfoService) {
        this.processInfoService = processInfoService;
    }

    @PostMapping("/{deviceId}")
    public ProcessInfoEntity saveProcessInfo(@RequestBody ProcessInfoEntity processInfo, @PathVariable UUID deviceId) {
        return processInfoService.saveProcessInfo(processInfo, deviceId);
    }

    @GetMapping("/device/{deviceId}")
    public Page<ProcessInfoEntity> getProcessesByDeviceId(@PathVariable UUID deviceId, Pageable pageable) {
        return processInfoService.getProcessesByDeviceId(deviceId, pageable);
    }

    @GetMapping("/{id}/device/{deviceId}")
    public ProcessInfoEntity getProcessByIdAndDeviceId(@PathVariable UUID id, @PathVariable UUID deviceId) {
        return processInfoService.getProcessByIdAndDeviceId(id, deviceId);
    }

    @PostMapping("/batch/{deviceId}")
    public List<ProcessInfoEntity> saveAllProcessInfo(@RequestBody List<ProcessInfoEntity> processInfoList, @PathVariable UUID deviceId) {
        return processInfoService.saveAllProcessInfo(processInfoList, deviceId);
    }
}
