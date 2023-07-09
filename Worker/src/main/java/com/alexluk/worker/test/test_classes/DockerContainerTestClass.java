package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.InvalidateDockerContainerInfoPropagationService;
import com.alexluk.worker.services.SaveDockerContainerInfoPropagationService;
import com.alexluk.worker.services.SaveDockerContainerLogsPropagationService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.ContainerLogJSONClass;
import com.alexluk.worker.test.test_json_classes.DockerContainerBatchJSONClass;
import com.alexluk.worker.test.test_json_classes.DockerContainerInvalidateJSONClass;

import java.util.UUID;

public class DockerContainerTestClass implements ITestClass {
    @Override
    public boolean runTests() {
        return saveDockerContainersTest() && invalidateDockerContainer() && saveDockerContainerLogs();
    }

    private boolean saveDockerContainersTest() {
        IPropagationService propagationService = new SaveDockerContainerInfoPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(DockerContainerBatchJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean invalidateDockerContainer() {
        IPropagationService propagationService = new InvalidateDockerContainerInfoPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(DockerContainerInvalidateJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean saveDockerContainerLogs() {
        IPropagationService propagationService = new SaveDockerContainerLogsPropagationService();
        try {
            UUID deviceId = DeviceIdStorage.readDeviceId();
            propagationService.propagate(ContainerLogJSONClass.JSON, deviceId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
