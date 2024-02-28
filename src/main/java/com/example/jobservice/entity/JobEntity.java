package com.example.jobservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Long companyId;
}

