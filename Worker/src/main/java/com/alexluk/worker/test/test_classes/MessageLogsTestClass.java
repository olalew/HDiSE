package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.MessageLogsPropagationService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.MessageLogJSONClass;

import java.util.UUID;

public class MessageLogsTestClass implements ITestClass {
    @Override
    public boolean runTests() {
        return saveMessageLogsTest();
    }

    private boolean saveMessageLogsTest() {
        IPropagationService propagationService = new MessageLogsPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(MessageLogJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
