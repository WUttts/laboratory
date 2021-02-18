package com.mafei.laboratory.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wutangsheng
 * @create 2021-02-10 22:31
 * @info
 */
@Entity
@Data
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id", length = 11)
    private Long userId;

    /**
     * 角色id
     */
    @Column(name = "role_id", length = 11)
    private Long roleId;


}