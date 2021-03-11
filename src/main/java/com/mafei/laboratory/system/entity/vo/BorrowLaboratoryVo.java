package com.mafei.laboratory.system.entity.vo;

import com.mafei.laboratory.system.entity.Borrow;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wutangsheng
 * @create 2021-03-11 19:53
 * @info
 */
@Getter
@Setter
public class BorrowLaboratoryVo extends Borrow {
    private Long laboratoryId;
    private String laboratoryName;
}
