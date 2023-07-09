package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.RegisterDevicePropagationService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.DeviceJSONClass;
public class DeviceTestClass implements ITestClass {

    @Override
    public boolean runTests() {
        return runRegisterDeviceTest();
    }

    private boolean runRegisterDeviceTest() {
        IPropagationService propagationService = new RegisterDevicePropagationService();
        try {
            propagationService.propagate(DeviceJSONClass.JSON, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
