package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysInstrumentRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysInstrumentRepairRepository extends JpaRepository<SysInstrumentRepair, Long>, JpaSpecificationExecutor<SysInstrumentRepair> {

}