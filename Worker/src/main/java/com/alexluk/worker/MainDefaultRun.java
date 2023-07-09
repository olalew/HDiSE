package com.alexluk.worker;

import com.alexluk.worker.enums.WorkerMode;
import com.alexluk.worker.infrastructure.DeviceIdStorage;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.*;

import java.util.UUID;

public class MainDefaultRun {
    public static void main(String[] args) {
        if (args.length >= 2) {
            int infoTypeValue = Integer.parseInt(args[0]);
            String jsonParameter = args[1];

            IPropagationService propagationService = null;
            WorkerMode workerType = getInfoTypeFromValue(infoTypeValue);
            if (workerType != null) {
                switch (workerType) {
                    case TEST -> {
                        propagationService = new TestPropagationService();
                    }
                    case REGISTER_DEVICE -> {
                        propagationService = new RegisterDevicePropagationService();
                    }
                    case REGISTER_CPUS -> {
                        propagationService = new RegisterCPUsPropagationService();
                    }
                    case SAVE_PROCESS_INFO -> {
                        propagationService = new PropagateProcessInfoService();
                    }
                    case SAVE_MESSAGE_LOGS -> {
                        propagationService = new MessageLogsPropagationService();
                    }
                    case SAVE_DOCKER_IMAGE_INFO -> {
                        propagationService = new SaveDockerImageInfoPropagationService();
                    }
                    case INVALIDATE_DOCKER_IMAGE_INFO -> {
                        propagationService = new InvalidateDockerImageInfoPropagationService();
                    }
                    case SAVE_DOCKER_CONTAINER_INFO -> {
                        propagationService = new SaveDockerContainerInfoPropagationService();
                    }
                    case INVALIDATE_DOCKER_CONTAINER_INFO -> {
                        propagationService = new InvalidateDockerContainerInfoPropagationService();
                    }
                    case SAVE_DOCKER_CONTAINER_LOGS -> {
                        propagationService = new SaveDockerContainerLogsPropagationService();
                    }
                }

                if (propagationService != null) {
                    try {
                        UUID deviceId = null;
                        if (workerType != WorkerMode.TEST && workerType != WorkerMode.REGISTER_DEVICE) {
                            deviceId = DeviceIdStorage.readDeviceId();
                        }
                        jsonParameter = propagationService.prepareObject(jsonParameter);
                        propagationService.propagate(jsonParameter, deviceId);
                    } catch (Exception e) {}
                }
            } else {
                System.err.println("Invalid info type value: " + infoTypeValue);
            }
        } else {
            System.err.println("Insufficient parameters provided!");
        }
    }

    private static WorkerMode getInfoTypeFromValue(int value) {
        for (WorkerMode workerType : WorkerMode.values()) {
            if (workerType.getValue() == value) {
                return workerType;
            }
        }
        return null;
    }
}
