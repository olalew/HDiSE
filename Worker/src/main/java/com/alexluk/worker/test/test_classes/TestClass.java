package com.alexluk.worker.test.test_classes;

import com.alexluk.worker.interfaces.IPropagationService;
import com.alexluk.worker.services.TestPropagationService;
import com.alexluk.worker.test.ITestClass;
import com.alexluk.worker.test.test_json_classes.TestJSONClass;

public class TestClass implements ITestClass {
    @Override
    public boolean runTests() {
        return runBaseTest();
    }

    private boolean runBaseTest() {
        IPropagationService propagationService = new TestPropagationService();
        try {
            propagationService.propagate(TestJSONClass.JSON, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
