package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysInstrumentUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysInstrumentUseRepository extends JpaRepository<SysInstrumentUse, Long>, JpaSpecificationExecutor<SysInstrumentUse> {

}