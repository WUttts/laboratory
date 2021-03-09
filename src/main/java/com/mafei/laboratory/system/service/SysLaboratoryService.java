package com.mafei.laboratory.system.service;

import com.mafei.laboratory.system.entity.SysLaboratory;

import java.util.List;

/**
 * 实验室信息表(SysLaboratory)表服务接口
 *
 * @author wutangsheng
 * @since 2021-02-24 10:39:21
 */
public interface SysLaboratoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysLaboratory queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysLaboratory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysLaboratory 实例对象
     * @return 实例对象
     */
    SysLaboratory insert(SysLaboratory sysLaboratory);

    /**
     * 修改数据
     *
     * @param sysLaboratory 实例对象
     * @return 实例对象
     */
    SysLaboratory update(SysLaboratory sysLaboratory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
