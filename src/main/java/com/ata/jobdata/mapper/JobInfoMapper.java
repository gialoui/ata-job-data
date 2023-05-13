package com.ata.jobdata.mapper;

import com.ata.jobdata.dto.JobInfoDto;
import com.ata.jobdata.entity.JobInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface JobInfoMapper {
    @Mapping(source = "salary", target = "formattedSalary")
    @Mapping(source = "salary", target = "salary")
    JobInfoDto toDto(JobInfo entity);

    default String formatSalary(Double salary) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(salary);
    }

    List<JobInfoDto> toDtoList(List<JobInfo> entities);

    JobInfo toEntity(JobInfoDto dto);
}
