package com.ata.jobdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobInfo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String employer;

    @Column
    private String location;

    @Column(nullable = false)
    private String jobTitle;

    @Column
    private Integer yearsAtEmployer;

    @Column
    private Integer yearsOfExperience;

    @Column(nullable = false)
    private Double salary;

    @Column
    private String signingBonus;

    @Column
    private String annualBonus;

    @Column(length = 1000)
    private String annualStockValueOrBonus;

    @Column
    private String gender;

    @Column(length = 5000)
    private String additionalComments;
}
