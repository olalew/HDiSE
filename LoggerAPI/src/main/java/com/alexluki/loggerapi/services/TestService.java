package com.alexluki.loggerapi.services;

import com.alexluki.loggerapi.dbmodels.TestEntity;
import com.alexluki.loggerapi.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestEntity createUser(TestEntity user) {
        user.setName("Cool");
        return testRepository.save(user);
    }
}