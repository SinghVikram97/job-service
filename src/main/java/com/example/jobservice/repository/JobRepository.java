package com.example.jobservice.repository;

import com.example.jobservice.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
}
