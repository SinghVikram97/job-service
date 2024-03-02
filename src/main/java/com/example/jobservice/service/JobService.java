package com.example.jobservice.service;

import com.example.jobservice.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> getAllJobs();
    JobDTO getJob(Long id);

    JobDTO createJob(JobDTO jobDto);

    JobDTO deleteJob(Long id);

    JobDTO updateJob(Long id, JobDTO jobDto);

    // Get all jobs for a company
    List<JobDTO> getAllJobsByCompany(Long companyId);
}
