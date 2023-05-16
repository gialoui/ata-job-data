package com.ata.jobdata.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
