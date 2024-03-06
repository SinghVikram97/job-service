package com.example.jobservice.repository;

import com.example.jobservice.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
    List<JobEntity> findByCompanyId(Long companyId);
    void deleteByCompanyId(Long companyId);
}
