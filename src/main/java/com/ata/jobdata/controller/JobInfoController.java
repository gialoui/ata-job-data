package com.ata.jobdata.controller;

import com.ata.jobdata.dto.JobInfoDto;
import com.ata.jobdata.entity.JobInfo;
import com.ata.jobdata.enums.JobInfoField;
import com.ata.jobdata.service.JobInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/job-data")
@RequiredArgsConstructor
public class JobInfoController {
    private final JobInfoService service;

    @Operation(summary = "Querying Job Data",
            parameters = {
                    @Parameter(name = "gender", example = "Male"),
                    @Parameter(name = "jobTitle", example = "Developer"),
                    @Parameter(name = "salary", example = "11000"),
                    @Parameter(name = "salaryGte", example = "14000"),
                    @Parameter(name = "salaryLte", example = "52000"),
                    @Parameter(name = "sort",
                            description = "The string to specify the sorting order for the returned list followed the format: [propertyName],([direction:desc or asc]). The list of property names can be found from schema JobInfoDto, except for the `formattedSalary` field which is not supported",
                            examples = {
                                    @ExampleObject(name = "Sort ascending by gender", value = "gender"),
                                    @ExampleObject(name = "Sort descending by gender", value = "gender,desc")
                            })
            })
    @GetMapping
    public ResponseEntity<List<JobInfoDto>> getProduct(
            @Parameter(hidden = true)
            @And({
                    @Spec(path = "gender", params = "gender", spec = Like.class),
                    @Spec(path = "jobTitle", params = "jobTitle", spec = Like.class),
                    @Spec(path = "salary", params = "salary", spec = Equal.class),
                    @Spec(path = "salary", params = {"salaryGte", "salaryLte"}, spec = Between.class)
            }) Specification<JobInfo> spec,
            @RequestParam(required = false) Set<JobInfoField> fields,
            @Parameter(hidden = true) Sort sort) {
        return new ResponseEntity<>(service.searchJobInfo(spec, fields, sort), HttpStatus.OK);
    }
}
