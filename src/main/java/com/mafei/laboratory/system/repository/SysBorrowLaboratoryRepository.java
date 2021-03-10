package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysBorrowLaboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysBorrowLaboratoryRepository extends JpaRepository<SysBorrowLaboratory, Long>, JpaSpecificationExecutor<SysBorrowLaboratory> {

}