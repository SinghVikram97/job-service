package com.example.jobservice.controller;

import com.example.jobservice.dto.JobDTO;
import com.example.jobservice.service.JobService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;
    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs(){
        logger.info("Get all jobs request");
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id){
        logger.info("Get job with id: {} request", id);
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobDTO> createJob(@RequestBody @Valid JobDTO jobDto){
        logger.info("Create job request with request body: {}",jobDto);
        return new ResponseEntity<>(jobService.createJob(jobDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobDTO> deleteJob(@PathVariable Long id){
        logger.info("Delete job with id: {} request", id);
        return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody @Valid JobDTO jobDto){
        logger.info("Update job with id: {} and request: {}", id, jobDto);
        return new ResponseEntity<>(jobService.updateJob(id, jobDto), HttpStatus.OK);
    }

    @GetMapping("/company")
    public ResponseEntity<List<JobDTO>> getAllJobsByCompany(@RequestParam("company_id") Long companyId){
        logger.info("Get all jobs by company with id: {} request",companyId);
        List<JobDTO> allJobsByCompany = jobService.getAllJobsByCompany(companyId);
        return new ResponseEntity<>(allJobsByCompany, HttpStatus.OK);
    }
}

