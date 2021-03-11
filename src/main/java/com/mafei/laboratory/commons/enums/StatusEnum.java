package com.mafei.laboratory.commons.enums;

/**
 * @author wutangsheng
 * @create 2021-03-10 10:49
 * @info
 */
public enum StatusEnum {
    //正常状态
    NORMAL("0", "正常"),

    //弃用状态
    DEPRECATED("1", "弃用"),

    //维修状态
    REPAIR("2", "维修中"),

    BORROW("3", "已借出");

    private String status;
    private String desc;

    StatusEnum() {
    }

    StatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
