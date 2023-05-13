package com.ata.jobdata.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class JobInfo {
    private LocalDateTime timestamp;
    private String employer;
    private String location;
    private String jobTitle;
    private Integer yearsAtEmployer;
    private Integer yearsOfExperience;
    private Double salary;
    private String signingBonus;
    private String annualBonus;
    private String annualStockValueOrBonus;
    private String gender;
    private String additionalComments;
}
