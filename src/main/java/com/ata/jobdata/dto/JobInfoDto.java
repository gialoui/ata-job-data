package com.ata.jobdata.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobInfoDto {
    private LocalDateTime timestamp;
    private String employer;
    private String location;
    private String jobTitle;
    private Integer yearsAtEmployer;
    private Integer yearsOfExperience;
    private Double salary;
    private String formattedSalary;
    private String signingBonus;
    private String annualBonus;
    private String annualStockValueOrBonus;
    private String gender;
    private String additionalComments;
}
