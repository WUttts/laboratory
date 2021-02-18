package com.mafei.laboratory.system.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wutangsheng
 * @create 2021-02-10 22:50
 * @info
 */
@Data
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @Id
    @Column(length = 11)
    private Long roleId;

    /**
     * 菜单id
     */
    @Column(length = 11)
    private Long menuId;

}
