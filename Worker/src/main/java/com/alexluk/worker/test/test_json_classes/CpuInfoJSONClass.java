package com.alexluk.worker.test.test_json_classes;

public class CpuInfoJSONClass {
    public static String JSON = """
            {
                "vulnerabilitySrbds": "Not affected",
                "stepping": "3",
                "vulnerabilityMeltdown": "Not affected",
                "l3Cache": "24 MiB (1 instance)",
                "cpuMinMhz": "400.0000",
                "vendorId": "GenuineIntel",
                "vulnerabilityRetbleed": "Not affected",
                "vulnerabilitySpecStoreBypass": "Mitigation; Speculative Store Bypass disabled via prctl",
                "byteOrder": "Little Endian",
                "vulnerabilitySpectreV1": "Mitigation; usercopy/swapgs barriers and __user pointer sanitization",
                "vulnerabilitySpectreV2": "Mitigation; Enhanced / Automatic IBRS, IBPB conditional, RSB filling, PBRSB-eIBRS SW sequence",
                "virtualization": "VT-x",
                "addressSizes": "46 bits physical, 48 bits virtual",
                "numaNodes": "1",
                "sockets": "1",
                "numaNode0Cpus": "0-19",
                "l2Cache": "11.5 MiB (8 instances)",
                "vulnerabilityItlbMultihit": "Not affected",
                "model": "154",
                "cpuOpModes": "32-bit, 64-bit",
                "architecture": "x86_64",
                "cpusScalingMhz": "47%",
                "vulnerabilityL1tf": "Not affected",
                "cpuMaxMhz": "5000.0000",
                "l1dCache": "544 KiB (14 instances)",
                "l1iCache": "704 KiB (14 instances)",
                "cpuFamily": "6",
                "coresPerSocket": "14",
                "threadsPerCore": "2",
                "vulnerabilityMmioStaleData": "Not affected",
                "modelName": "12th Gen Intel(R) Core(TM) i9-12900H",
                "vulnerabilityMds": "Not affected",
                "onlineCpusList": "0-19",
                "cpus": "20",
                "vulnerabilityTsxAsyncAbort": "Not affected",
                "bogoMIPS": "5836.80"
            }
            """;
}
