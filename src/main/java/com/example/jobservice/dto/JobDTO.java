package com.example.jobservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobDTO {
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotEmpty
    private String minSalary;
    @NotEmpty
    private String maxSalary;
    @NotEmpty
    private String location;
    @NotNull
    private Long companyId;
}
