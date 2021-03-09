package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysLaboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wts
 */
@Repository
public interface SysLaboratoryRepository extends JpaRepository<SysLaboratory, Long>, JpaSpecificationExecutor<SysLaboratory> {

}