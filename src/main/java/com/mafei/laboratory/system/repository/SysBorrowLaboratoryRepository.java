package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysBorrowLaboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author wts
 */
@Repository
public interface SysBorrowLaboratoryRepository extends JpaRepository<SysBorrowLaboratory, Long>, JpaSpecificationExecutor<SysBorrowLaboratory> {
    /**
     * 单个查询
     *
     * @param id
     * @return
     */
    @Override
    Optional<SysBorrowLaboratory> findById(Long id);

    /**
     * 根据status查询
     *
     * @param status
     * @return
     */
    SysBorrowLaboratory findByStatus(String status);

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    @Query(value = "select * from sys_borrow_laboratory order by borrow_status,create_time desc", nativeQuery = true)
    List<SysBorrowLaboratory> findAll();

    /**
     * 查询全部
     *
     * @return
     */
    @Query(value = "select * from sys_borrow_laboratory order by status,create_time desc", nativeQuery = true)
    List<SysBorrowLaboratory> findAllByStatus();


    /**
     * 查询多个
     *
     * @param ids
     * @return
     */
    @Query(value = "SELECT * FROM sys_borrow_laboratory WHERE id not in ?1", nativeQuery = true)
    List<SysBorrowLaboratory> queryByIds(List<Long> ids);


    /**
     * 修改状态
     *
     * @param id
     * @param status
     */
    @Modifying
    @Query(value = "update sys_borrow_laboratory set status = ?2 where id = ?1", nativeQuery = true)
    void updateStatus(Long id, String status);

    /**
     * 修改状态
     *
     * @param id
     * @param status
     */
    @Modifying
    @Query(value = "update sys_borrow_laboratory set borrow_status = ?2 where id = ?1", nativeQuery = true)
    void updateBorrowStatus(Long id, String status);

    /**
     * 查找id
     *
     * @return
     */
    @Query(value = "select instrument_id from sys_borrow_laboratory", nativeQuery = true)
    List<Long> findInstrumentId();
}