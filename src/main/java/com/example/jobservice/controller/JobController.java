package com.example.jobservice.controller;

import com.example.jobservice.dto.JobDTO;
import com.example.jobservice.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs(){
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id){
        return new ResponseEntity<>(jobService.getJob(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobDTO> createJob(@RequestBody @Valid JobDTO jobDto){
        return new ResponseEntity<>(jobService.createJob(jobDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobDTO> deleteJob(@PathVariable Long id){
        return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody @Valid JobDTO jobDto){
        return new ResponseEntity<>(jobService.updateJob(id, jobDto), HttpStatus.OK);
    }
}

