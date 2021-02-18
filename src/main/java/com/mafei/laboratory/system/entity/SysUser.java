package com.mafei.laboratory.system.entity;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;


/**
 * @author wutangsheng
 * @create 2021-02-10 16:51
 * @info
 */

@Entity
@Data
@Table(name="sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * 用户id
     */
    @Column(name = "user_id",length = 20)
    private Long userId;

    /**
     * 部门id
     */
    @Column(name = "dept_id",length = 20)
    private Long deptId;

    /**
     * 登录账号
     */
    @Column(name = "login_name",length = 30)
    private String loginName;

    /**
     * 用户昵称
     */
    @Column(name = "user_name",length = 30)
    private String userName;

    /**
     * 用户类型（00系统用户 01注册用户）
     */
    @Column(name = "user_type" ,length = 2)
    private String userType;

    /**
     * 用户邮箱
     */
    @Column(name = "email",length = 50)
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "phonenumber" ,length = 11)
    private Integer phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @Column(name = "sex",length = 1)
    private String sex;

    /**
     * 头像路径
     */
    @Column(name = "avatar",length = 100)
    private String avatar;

    /**
     * 密码
     */
    @Column(name = "password",length = 50)
    private String password;

    /**
     * 盐加密
     */
    @Column(name = "salt",length = 20)
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    @Column(name = "status",length = 1)
    private Integer status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Column(name = "del_flag",length = 1)
    private Integer delFlag;

    /**
     * 最后登录ip
     */
    @Column(name = "login_ip",length = 50)
    private String loginIp;

    /**
     * 最后登录时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 密码最后更新时间
     */
    @Column(name = "pwd_update_date")
    private Date pwdUpdateDate;

    /**
     * 创建者
     */
    @Column(name = "create_by",length = 50)
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by",length = 50)
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

}

