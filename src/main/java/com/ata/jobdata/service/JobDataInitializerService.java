package com.ata.jobdata.service;

import com.ata.jobdata.dao.JobInfoRepository;
import com.ata.jobdata.entity.JobInfo;
import com.ata.utils.StringUtils;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Log4j2
public class JobDataInitializerService {
    private final JobInfoRepository repository;

    private static final String COLUMN_TIMESTAMP_PATTERN = "M/d/yy H:mm";

    /**
     * @param inputStream
     * @throws IOException
     * @throws CsvValidationException
     */
    public void importCsv(InputStream inputStream) throws IOException, CsvValidationException {
        var numberOfRecords = repository.count();

        if (numberOfRecords == 0) {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            reader.readNext(); // read the header row
            String[] line;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(COLUMN_TIMESTAMP_PATTERN);
            while ((line = reader.readNext()) != null) {
                if (org.apache.commons.lang3.StringUtils.isNotBlank(line[0])) {
                    var jobInfo = JobInfo.builder()
                            .timestamp(LocalDateTime.parse(line[0], formatter))
                            .employer(line[1])
                            .location(line[2])
                            .jobTitle(line[3])
                            .yearsAtEmployer(StringUtils.parseToInt(line[4]))
                            .yearsOfExperience(StringUtils.parseToInt(line[5]))
                            .salary(StringUtils.parseToDouble(line[6]))
                            .signingBonus(line[7])
                            .annualBonus(line[8])
                            .annualStockValueOrBonus(line[9])
                            .gender(line[10])
                            .additionalComments(line[11]).build();

                    repository.save(jobInfo);
                }
            }

            log.info("All job data is imported to DB successfully");
        } else {
            log.info("Job data is ready to be queried");
        }
    }
}
