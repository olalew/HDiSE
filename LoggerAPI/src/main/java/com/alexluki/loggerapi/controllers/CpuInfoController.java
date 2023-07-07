package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.CpuInfoEntity;
import com.alexluki.loggerapi.services.CpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cpuinfo")
public class CpuInfoController {

    private final CpuInfoService cpuInfoService;

    @Autowired
    public CpuInfoController(CpuInfoService cpuInfoService) {
        this.cpuInfoService = cpuInfoService;
    }

    @PostMapping("/{deviceId}")
    public CpuInfoEntity saveCpuInfo(@RequestBody CpuInfoEntity cpuInfo, @PathVariable UUID deviceId) {
        return cpuInfoService.saveCpuInfo(cpuInfo, deviceId);
    }

    @GetMapping("/device/{deviceId}")
    public List<CpuInfoEntity> getCpuInfo(@PathVariable UUID deviceId) {
        return cpuInfoService.getCpuInfoByDeviceId(deviceId);
    }

    @GetMapping("/{id}")
    public CpuInfoEntity getCpuInfoById(@PathVariable UUID id) {
        return cpuInfoService.getCpuInfoById(id);
    }

}
