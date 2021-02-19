package com.mafei.laboratory.system.repository;

import com.mafei.laboratory.system.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wts
 */
@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Long>, JpaSpecificationExecutor<SysMenu> {

    /**
     * 查询菜单
     *
     * @param menuIdS
     * @return
     */
    @Query(value = "select * from sys_menu where menu_id in ?1", nativeQuery = true)
    List<SysMenu> findMenu(List<Long> menuIdS);
}