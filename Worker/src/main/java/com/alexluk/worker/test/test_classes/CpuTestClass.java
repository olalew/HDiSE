package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.RegisterCPUsPropagationService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.CpuInfoJSONClass;

import java.util.UUID;

public class CpuTestClass implements ITestClass {
    @Override
    public boolean runTests() {
        return runRegisterCpusTest();
    }

    private boolean runRegisterCpusTest() {
        IPropagationService propagationService = new RegisterCPUsPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(CpuInfoJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
