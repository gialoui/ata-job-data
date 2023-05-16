package com.ata.jobdata.service;

import com.ata.jobdata.dao.JobInfoRepository;
import com.ata.jobdata.dto.JobInfoDto;
import com.ata.jobdata.entity.JobInfo;
import com.ata.jobdata.enums.JobInfoField;
import com.ata.jobdata.mapper.JobInfoMapper;
import com.ata.utils.ObjectUtils;
import com.ata.utils.SetUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobInfoService {
    private final JobInfoRepository repository;
    private final JobInfoMapper mapper;

    /**
     * Query job data by criteria with the options to sort and filter
     *
     * @param specification Search criteria
     * @param fields        Fields to be selected
     * @param sort          Sorting criteria
     * @return
     */
    public List<JobInfoDto> searchJobInfo(Specification<JobInfo> specification, Set<JobInfoField> fields, Sort sort) {
        List<JobInfo> result = sort != null ? repository.findAll(specification, sort) : repository.findAll(specification);

        if (CollectionUtils.isNotEmpty(fields) && CollectionUtils.isNotEmpty(result)) {
            String[] fieldNames = SetUtils.toArray(fields.stream().map(JobInfoField::getFieldName).collect(Collectors.toSet()));
            return mapper.toDtoList(result.parallelStream().map(item -> ObjectUtils.keepOnlySelectedFields(item, fieldNames)).collect(Collectors.toList()));
        }

        return mapper.toDtoList(result);
    }
}
