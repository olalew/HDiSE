package com.alexluki.loggerapi.controllers;

import com.alexluki.loggerapi.dbmodels.test.TestEntity;
import com.alexluki.loggerapi.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/test")
    public TestEntity createTest(@RequestBody TestEntity entity) {
        return testService.createUser(entity);
    }
}