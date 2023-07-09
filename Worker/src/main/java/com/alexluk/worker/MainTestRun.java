package com.alexluk.worker;

import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTestRun {

    private static List<ITestClass> testClasses = Arrays.asList(
//            new TestClass(),
            new DeviceTestClass(),
//            new CpuTestClass(),
//            new ProcessInfoTestClass(),
//            new MessageLogsTestClass(),
//            new DockerImageTestClass()
            new DockerContainerTestClass()
    );

    public static void main(String[] args) {
        boolean allSuccess = true;
        for (ITestClass testClass: testClasses) {
            allSuccess = allSuccess && testClass.runTests();
        }

        System.out.println(String.format("All success: %b", allSuccess));
    }
}
