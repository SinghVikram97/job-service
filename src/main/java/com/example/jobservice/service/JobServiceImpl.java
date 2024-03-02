package com.example.jobservice.service;

import com.example.jobservice.delegate.CompanyServiceDelegate;
import com.example.jobservice.dto.JobDTO;
import com.example.jobservice.entity.JobEntity;
import com.example.jobservice.exception.ResourceNotFoundException;
import com.example.jobservice.mapper.ModelMapper;
import com.example.jobservice.model.Company;
import com.example.jobservice.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final ModelMapper mapper;
    private final CompanyServiceDelegate companyServiceDelegate;

    @Override
    public List<JobDTO> getAllJobs() {
        List<JobEntity> jobList = jobRepository.findAll();
        return jobList.stream().map(mapper::mapJobToJobDto).collect(Collectors.toList());
    }

    @Override
    public JobDTO getJob(Long id) {
        JobEntity job = getJobOrThrowException(id);
        return mapper.mapJobToJobDto(job);
    }

    @Override
    public JobDTO createJob(JobDTO jobDto) {
        // Check validity of companyId
        Long companyId = jobDto.getCompanyId();
        companyServiceDelegate.getCompanyById(companyId);

        // If valid company
        JobEntity job = mapper.mapJobDtoToJob(jobDto);
        JobEntity savedJob = jobRepository.save(job);
        return mapper.mapJobToJobDto(savedJob);
    }

    @Override
    public JobDTO deleteJob(Long id) {
        JobEntity job = getJobOrThrowException(id);
        jobRepository.deleteById(job.getId());
        return mapper.mapJobToJobDto(job);
    }

    @Override
    public JobDTO updateJob(Long id, JobDTO jobDto) {
        JobEntity job = getJobOrThrowException(id);

        // Check validity of companyId
        Long companyId = jobDto.getCompanyId();
        companyServiceDelegate.getCompanyById(companyId);

        // If valid company
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setMaxSalary(jobDto.getMaxSalary());
        job.setMinSalary(jobDto.getMinSalary());
        job.setLocation(jobDto.getLocation());
        job.setCompanyId(job.getCompanyId());
        JobEntity savedJob = jobRepository.save(job);
        return mapper.mapJobToJobDto(savedJob);
    }

    @Override
    public List<JobDTO> getAllJobsByCompany(Long companyId) {
        // We can skip validating companyId since if invalid companyId there would be zero jobs
        List<JobEntity> jobEntityList = jobRepository.findByCompanyId(companyId);
        return jobEntityList.stream().map(mapper::mapJobToJobDto).collect(Collectors.toList());
    }

    private JobEntity getJobOrThrowException(Long id){
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job", "Id", id));
    }
}

