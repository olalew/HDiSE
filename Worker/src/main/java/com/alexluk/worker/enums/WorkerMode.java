package com.alexluk.worker.enums;

public enum WorkerMode {
    TEST(0),
    REGISTER_DEVICE(1),
    REGISTER_CPUS(2),
    SAVE_PROCESS_INFO(3),
    SAVE_MESSAGE_LOGS(4),
    SAVE_DOCKER_IMAGE_INFO(5),
    INVALIDATE_DOCKER_IMAGE_INFO(6),
    SAVE_DOCKER_CONTAINER_INFO(7),
    INVALIDATE_DOCKER_CONTAINER_INFO(8),
    SAVE_DOCKER_CONTAINER_LOGS(9);

    private final int value;

    WorkerMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
