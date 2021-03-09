package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysLaboratoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wts
 */
@Repository
public interface SysLaboratoryLogRepository extends JpaRepository<SysLaboratoryLog, Long>, JpaSpecificationExecutor<SysLaboratoryLog> {

}