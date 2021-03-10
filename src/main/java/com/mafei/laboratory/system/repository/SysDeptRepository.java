package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysDeptRepository extends JpaRepository<SysDept, Long>, JpaSpecificationExecutor<SysDept> {

}