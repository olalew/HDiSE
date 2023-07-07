package com.alexluki.loggerapi.repositories;

import com.alexluki.loggerapi.dbmodels.ProcessRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessRecordRepository extends JpaRepository<ProcessRecordEntity, Long> {
}
