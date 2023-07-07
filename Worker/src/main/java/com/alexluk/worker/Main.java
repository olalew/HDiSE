package com.alexluk.worker;

import com.alexluk.worker.enums.WorkerMode;
import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.*;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 2) {
            int infoTypeValue = Integer.parseInt(args[0]);
            String jsonParameter = args[1];

            IPropagationService propagationService = null;
            WorkerMode workerType = getInfoTypeFromValue(infoTypeValue);
            if (workerType != null) {
                switch (workerType) {
                    case PROCESS_LIST:
                        System.out.println("Processing process list with JSON: " + jsonParameter);
                        propagationService = new ProcessListPropagationService();
                        break;
                    case CPU_INFO:
                        System.out.println("Processing CPU info with JSON: " + jsonParameter);
                        propagationService = new CPUPropagationService();
                        break;
                    case BASE_INFO:
                        System.out.println("Processing base info with JSON: " + jsonParameter);
                        propagationService = new BaseInfoPropagationService();
                        break;
                    case LOGS:
                        System.out.println("Processing logs with JSON: " + jsonParameter);
                        propagationService = new LogPropagationService();
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
