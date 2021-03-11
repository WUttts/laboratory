package com.mafei.laboratory.system.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wutangsheng
 * @create 2021-03-11 19:51
 * @info
 */
@Data
public class Borrow {
    private Long id;
    private Long userId;
    private String userName;
    private String status;
    private String borrowStatus;
    private String comment;
    private Date createTime;
}
