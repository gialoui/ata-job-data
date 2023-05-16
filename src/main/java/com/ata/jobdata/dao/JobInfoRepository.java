package com.ata.jobdata.dao;

import com.ata.jobdata.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, Integer>, JpaSpecificationExecutor<JobInfo> {
}
