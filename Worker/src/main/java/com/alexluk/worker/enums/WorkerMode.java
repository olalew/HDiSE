package com.alexluk.worker.enums;

public enum WorkerMode {
    PROCESS_LIST(0),
    CPU_INFO(2),
    BASE_INFO(3),
    LOGS(4),
    TEST(5);

    private final int value;

    WorkerMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
