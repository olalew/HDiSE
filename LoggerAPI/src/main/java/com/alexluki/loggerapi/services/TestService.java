package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.test.TestEntity;
import com.alexluki.loggerapi.repositories.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final ITestRepository testRepository;

    @Autowired
    public TestService(ITestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestEntity createUser(TestEntity user) {
        return testRepository.save(user);
    }
}