package com.alexluk.worker.test.test_json_classes;

public class MessageLogJSONClass {
    public static String JSON = """
            [
                {
                    "systemdCgroup": "/system.slice/realmd.service",
                    "realtimeTimestamp": "1688756616188203",
                    "capEffective": "1ffffffffff",
                    "cursor": "s=2f60a10b0b1045ba9e0bebfb209d8019;i=102e64;b=1467c7b6660b4514961bcc04cd5422ab;m=75c9788d4;t=5ffea4a38512b;x=f8776b6ccc4834d1",
                    "runtimeScope": "system",
                    "machineId": "9b618c1348a149bc8f1201bf92c693b8",
                    "priority": "7",
                    "systemdUnit": "realmd.service",
                    "systemdInvocationId": "eaaefbbdb34c4a3e925e48d9c9adf114",
                    "uid": "0",
                    "codeFunc": "realm_daemon_syslog",
                    "monotonicTimestamp": "31618205908",
                    "systemdSlice": "system.slice",
                    "sourceRealtimeTimestamp": "1688756616188185",
                    "message": "client using service: :1.6695",
                    "codeFile": "service/realm-daemon.c",
                    "syslogFacility": "4",
                    "bootId": "1467c7b6660b4514961bcc04cd5422ab",
                    "comm": "realmd",
                    "pid": "1461",
                    "syslogIdentifier": "realmd",
                    "selinuxContext": "system_u:system_r:realmd_t:s0",
                    "exe": "/usr/libexec/realmd",
                    "codeLine": "415",
                    "cmdline": "/usr/libexec/realmd",
                    "realmdOperation": "(null)",
                    "hostname": "fedora",
                    "transport": "journal",
                    "gid": "0"
                },
                {
                    "codeFunc": "realm_daemon_syslog",
                    "systemdInvocationId": "eaaefbbdb34c4a3e925e48d9c9adf114",
                    "systemdUnit": "realmd.service",
                    "capEffective": "1ffffffffff",
                    "syslogFacility": "4",
                    "realtimeTimestamp": "1688756616188756",
                    "uid": "0",
                    "sourceRealtimeTimestamp": "1688756616188208",
                    "systemdSlice": "system.slice",
                    "pid": "1461",
                    "exe": "/usr/libexec/realmd",
                    "syslogIdentifier": "realmd",
                    "selinuxContext": "system_u:system_r:realmd_t:s0",
                    "message": "holding daemon: :1.6695",
                    "gid": "0",
                    "codeFile": "service/realm-daemon.c",
                    "monotonicTimestamp": "31618206461",
                    "runtimeScope": "system",
                    "codeLine": "415",
                    "bootId": "1467c7b6660b4514961bcc04cd5422ab",
                    "cmdline": "/usr/libexec/realmd",
                    "realmdOperation": "(null)",
                    "hostname": "fedora",
                    "transport": "journal",
                    "machineId": "9b618c1348a149bc8f1201bf92c693b8"
                }
            ]
            """;
}
