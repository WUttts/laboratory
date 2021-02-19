package com.mafei.laboratory.system.service;

import com.mafei.laboratory.system.entity.SysMenu;
import com.mafei.laboratory.system.entity.vo.MenuVo;

import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务接口
 *
 * @author wutangsheng
 * @since 2021-02-18 11:06:53
 */
public interface SysMenuService {


    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    SysMenu queryById(Long menuId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu insert(SysMenu sysMenu);

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu update(SysMenu sysMenu);

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    boolean deleteById(Long menuId);

    /**
     * 根据id查询菜单
     *
     * @param roleId
     * @return
     */
    List<MenuVo> queryMenuByRole(Long roleId);


}
