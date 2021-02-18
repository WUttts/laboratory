package com.mafei.laboratory.system.entity;

import java.io.Serializable;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wutangsheng
 * @create 2021-02-10 22:45
 * @info
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @Id
    @GeneratedValue
    @Column(length = 11)
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(length = 64)
    private String roleName;

    /**
     * 角色权限字符串
     */
    @Column(length = 100)
    private String roleKey;

    /**
     * 显示顺序
     */
    @Column(length = 4)
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @Column(length = 1)
    private Integer dataScope;

    /**
     * 角色状态（0正常 1停用）
     */
    @Column(length = 1)
    private Integer status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Column(length = 1)
    private Integer delFlag;

    /**
     * 创建者
     */
    @Column(length = 64)
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    @Column(length = 64)
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}
