package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.InvalidateDockerImageInfoPropagationService;
import com.alexluk.worker.services.SaveDockerImageInfoPropagationService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.DockerImageInvalidateJSONClass;
import com.alexluk.worker.test.test_json_classes.DockerImageJSONClass;

import java.util.UUID;

public class DockerImageTestClass implements ITestClass {
    @Override
    public boolean runTests() {
        return saveDockerImagesTest() && invalidateDockerImagesTest();
    }

    private boolean saveDockerImagesTest() {
        IPropagationService propagationService = new SaveDockerImageInfoPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(DockerImageJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean invalidateDockerImagesTest() {
        IPropagationService propagationService = new InvalidateDockerImageInfoPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(DockerImageInvalidateJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
