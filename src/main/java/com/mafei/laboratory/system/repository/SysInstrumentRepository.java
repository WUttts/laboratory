package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysInstrumentRepository extends JpaRepository<SysInstrument, Long>, JpaSpecificationExecutor<SysInstrument> {

}