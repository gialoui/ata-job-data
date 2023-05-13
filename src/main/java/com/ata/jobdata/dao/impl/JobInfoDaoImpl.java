package com.ata.jobdata.dao.impl;

import com.ata.jobdata.dao.JobInfoDao;
import com.ata.jobdata.dto.JobInfoDto;
import com.ata.jobdata.enums.JobInfoFilterableField;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class JobInfoDaoImpl implements JobInfoDao {

    @Override
    public List<JobInfoDto> searchJobInfo(Specification<JobInfoDto> specification, List<JobInfoFilterableField> fields, Sort sort) {
        return null;
    }
}
