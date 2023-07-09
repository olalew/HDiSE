package com.alexluk.worker.test.test_json_classes;

public class DockerContainerBatchJSONClass {
    public static String JSON = """
            [
                {
                    "containerId": "9f7c43452e45",
                    "image": "postgres",
                    "name": "some-postgres",
                    "status": "Up 37 hours",
                    "ports": "0.0.0.0:5432->5432/tcp, :::5432->5432/tcp"
                }
            ]
            """;
}
