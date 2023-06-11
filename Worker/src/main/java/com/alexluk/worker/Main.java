package com.alexluk.worker;

import com.alexluk.worker.enums.WorkerMode;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.TestPropagationService;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 3) {
            int infoTypeValue = Integer.parseInt(args[1]);
            String jsonParameter = args[2];

            IPropagationService propagationService = null;
            WorkerMode workerType = getInfoTypeFromValue(infoTypeValue);
            if (workerType != null) {
                switch (workerType) {
                    case PROCESS_LIST:
                        // Handle process list option with JSON
                        System.out.println("Processing process list with JSON: " + jsonParameter);
                        break;
                    case HARDWARE_INFO:
                        // Handle hardware info option with JSON
                        System.out.println("Processing hardware info with JSON: " + jsonParameter);
                        break;
                    case CPU_INFO:
                        // Handle CPU info option with JSON
                        System.out.println("Processing CPU info with JSON: " + jsonParameter);
                        break;
                    case BASE_INFO:
                        // Handle base info option with JSON
                        System.out.println("Processing base info with JSON: " + jsonParameter);
                        break;
                    case LOGS:
                        // Handle logs option with JSON
                        System.out.println("Processing logs with JSON: " + jsonParameter);
                        break;
                    case TEST:
                        propagationService = new TestPropagationService();
                        break;
                }

                if (propagationService != null) {
                    propagationService.propagate(workerType, jsonParameter);
                }
            } else {
                System.err.println("Invalid info type value: " + infoTypeValue);
            }
        } else {
            System.err.println("Insufficient parameters provided.");
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
