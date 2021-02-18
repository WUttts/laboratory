package com.mafei.laboratory.system.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wutangsheng
 * @create 2021-02-10 22:37
 * @info
 */
@Entity
@Data
@Table(name = "sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "menu_id", length = 11)
    private Long menuId;

    /**
     * 菜单名称
     */
    @Column(length = 50)
    private String menuName;

    /**
     * 父菜单id
     */
    @Column(length = 20)
    private Long parentId;

    /**
     * 显示顺序
     */
    @Column(length = 4)
    private Integer orderNum;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 打开方式（menuitem页签 menublank新窗口）
     */
    @Column(length = 20)
    private String target;

    /**
     * 菜单类型（m目录 c菜单 f按钮）
     */
    @Column(length = 1)
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    @Column(length = 1)
    private Integer visible;

    /**
     * 是否刷新（0刷新 1不刷新）
     */
    @Column(length = 1)
    private Integer isRefresh;

    /**
     * 权限标识
     */
    @Column(length = 100)
    private String perms;

    /**
     * 菜单图标
     */
    @Column(length = 100)
    private String icon;

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
    @Column(length = 510)
    private String remark;

}
