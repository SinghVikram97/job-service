package com.example.jobservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Company {
    private Long id;
    private String name;
    private String description;
}
