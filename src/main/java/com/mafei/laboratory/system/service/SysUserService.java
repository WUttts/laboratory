package com.mafei.laboratory.system.service;

import com.mafei.laboratory.system.entity.SysUser;
import com.mafei.laboratory.system.entity.vo.LoginUserVo;
import com.mafei.laboratory.system.service.dto.UserDto;

import java.util.List;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author wutangsheng
 * @since 2021-02-18 11:08:00
 */
public interface SysUserService {

    /**
     * 通过用户名查单条数据
     * @param userDto
     * @return
     */
    LoginUserVo queryByUsername(UserDto userDto);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUser queryById(Long userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}
