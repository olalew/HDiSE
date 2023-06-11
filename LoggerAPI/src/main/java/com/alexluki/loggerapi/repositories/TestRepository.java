package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.test.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
}