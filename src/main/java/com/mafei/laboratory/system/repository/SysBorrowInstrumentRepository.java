package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysBorrowInstrument;
import com.mafei.laboratory.system.entity.SysBorrowInstrument;
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
public interface SysBorrowInstrumentRepository extends JpaRepository<SysBorrowInstrument, Long>, JpaSpecificationExecutor<SysBorrowInstrument> {

    /**
     * 单个查询
     *
     * @param id
     * @return
     */
    @Override
    Optional<SysBorrowInstrument> findById(Long id);

    /**
     * 根据status查询
     *
     * @param status
     * @return
     */
    SysBorrowInstrument findByStatus(String status);

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    @Query(value = "select * from sys_borrow_instrument order by borrow_status,create_time desc", nativeQuery = true)
    List<SysBorrowInstrument> findAll();

    /**
     * 查询全部
     *
     * @return
     */
    @Query(value = "select * from sys_borrow_instrument order by status,create_time desc", nativeQuery = true)
    List<SysBorrowInstrument> findAllByStatus();


    /**
     * 查询多个
     *
     * @param ids
     * @return
     */
    @Query(value = "SELECT * FROM sys_borrow_instrument WHERE id not in ?1", nativeQuery = true)
    List<SysBorrowInstrument> queryByIds(List<Long> ids);


    /**
     * 修改状态
     *
     * @param id
     * @param status
     */
    @Modifying
    @Query(value = "update sys_borrow_instrument set status = ?2 where id = ?1", nativeQuery = true)
    void updateStatus(Long id, String status);

    /**
     * 修改状态
     *
     * @param id
     * @param status
     */
    @Modifying
    @Query(value = "update sys_borrow_instrument set borrow_status = ?2 where id = ?1", nativeQuery = true)
    void updateBorrowStatus(Long id, String status);

    /**
     * 查找id
     *
     * @return
     */
    @Query(value = "select instrument_id from sys_borrow_instrument", nativeQuery = true)
    List<Long> findInstrumentId();
}