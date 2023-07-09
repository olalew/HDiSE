package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.PropagateProcessInfoService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.ProcessInfoJSONClass;

import java.util.UUID;

public class ProcessInfoTestClass implements ITestClass {
    @Override
    public boolean runTests() {
        return runProcessInfoTest();
    }

    private boolean runProcessInfoTest() {
        IPropagationService propagationService = new PropagateProcessInfoService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(ProcessInfoJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
