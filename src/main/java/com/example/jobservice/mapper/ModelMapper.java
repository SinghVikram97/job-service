package com.example.jobservice.mapper;

import com.example.jobservice.dto.JobDTO;
import com.example.jobservice.entity.JobEntity;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class ModelMapper {
    public JobDTO mapJobToJobDto(JobEntity job){
        return JobDTO.builder()
                .title(job.getTitle())
                .description(job.getDescription())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .location(job.getLocation())
                .companyId(job.getCompanyId())
                .id(job.getId())
                .build();
    }

    public JobEntity mapJobDtoToJob(JobDTO jobDto){
        return JobEntity.builder()
                .title(jobDto.getTitle())
                .description(jobDto.getDescription())
                .minSalary(jobDto.getMinSalary())
                .maxSalary(jobDto.getMaxSalary())
                .location(jobDto.getLocation())
                .companyId(jobDto.getCompanyId())
                .build();
    }
}
