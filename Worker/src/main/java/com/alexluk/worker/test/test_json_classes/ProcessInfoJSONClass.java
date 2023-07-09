package com.alexluk.worker.test.test_json_classes;

public class ProcessInfoJSONClass {
    public static String JSON = """
            [
                {
                    "user": "root",
                    "pid": "1",
                    "cpu": "-",
                    "mem": "57406",
                    "time": "00:00:02",
                    "command": "/usr/lib/systemd/systemd"
                },
                {
                    "user": "root",
                    "pid": "2",
                    "cpu": "-",
                    "mem": "0",
                    "time": "00:00:00",
                    "command": "[kthreadd]"
                },
                {
                    "user": "root",
                    "pid": "3",
                    "cpu": "-",
                    "mem": "0",
                    "time": "00:00:00",
                    "command": "[rcu_gp]"
                },
                {
                    "user": "root",
                    "pid": "4",
                    "cpu": "-",
                    "mem": "0",
                    "time": "00:00:00",
                    "command": "[rcu_par_gp]"
                },
                {
                    "user": "root",
                    "pid": "5",
                    "cpu": "-",
                    "mem": "0",
                    "time": "00:00:00",
                    "command": "[slub_flushwq]"
                },
                {
                    "user": "root",
                    "pid": "6",
                    "cpu": "-",
                    "mem": "0",
                    "time": "00:00:00",
                    "command": "[netns]"
                }
            ]
            """;
}
