package com.ata.jobdata.service;

import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Log4j2
public class StartupRunner {
    private final JobDataInitializerService jobDataInitializerService;
    private final ResourceLoader resourceLoader;

    private static final String CSV_LOCATION = "classpath:salary_survey-3.csv";

    @PostConstruct
    public void init() {
        Resource resource = resourceLoader.getResource(CSV_LOCATION);

        try {
            jobDataInitializerService.importCsv(resource.getInputStream());
        } catch(IOException | CsvValidationException e) {
            log.error("Error loading the Job Data file to our system", e);
        }
    }
}
