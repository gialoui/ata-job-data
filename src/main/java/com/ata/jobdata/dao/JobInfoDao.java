package com.ata.jobdata.dao;

import com.ata.jobdata.dto.JobInfoDto;
import com.ata.jobdata.entity.JobInfo;
import com.ata.jobdata.enums.JobInfoFilterableField;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.net.http.HttpHeaders;
import java.util.List;

public interface JobInfoDao {
    List<JobInfoDto> searchJobInfo(Specification<JobInfoDto> specification, List<JobInfoFilterableField> fields, Sort sort);
}
