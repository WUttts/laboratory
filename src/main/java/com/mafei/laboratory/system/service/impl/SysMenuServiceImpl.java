package com.mafei.laboratory.system.service.impl;

import com.mafei.laboratory.commons.exception.BadRequestException;
import com.mafei.laboratory.system.entity.SysMenu;
import com.mafei.laboratory.system.entity.vo.MenuVo;
import com.mafei.laboratory.system.repository.SysMenuRepository;
import com.mafei.laboratory.system.repository.SysRoleMenuRepository;
import com.mafei.laboratory.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wutangsheng
 * @create 2021-02-19 12:37
 * @info
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl implements SysMenuService {
    private final SysMenuRepository menuRepository;
    private final SysRoleMenuRepository sysRoleMenuRepository;


    @Override
    public SysMenu queryById(Long menuId) {
        return null;
    }

    @Override
    public List<SysMenu> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public SysMenu insert(SysMenu sysMenu) {
        return null;
    }

    @Override
    public SysMenu update(SysMenu sysMenu) {
        return null;
    }

    @Override
    public boolean deleteById(Long menuId) {
        return false;
    }

    @Override
    public List<MenuVo> queryMenuByRole(Long roleId) {
        List<Long> menuIds = sysRoleMenuRepository.findByRoleId(roleId);
        List<SysMenu> menus = menuRepository.findMenu(menuIds);
        if (menus.size() == 0) {
            throw new BadRequestException(HttpStatus.NOT_FOUND, "当前无菜单");
        }
        //查询父节点菜单
        List<MenuVo> rootMenu = menus.stream()
                .filter(menu -> menu.getParentId() == 0)
                .map(this::menuToMenuVo)
                .sorted(Comparator.comparing(MenuVo::getOrderNum))
                .collect(Collectors.toList());

        findChildMenu(menus, rootMenu);

        return rootMenu;
    }

    private void findChildMenu(List<SysMenu> menuList, List<MenuVo> menuVoList) {
        for (MenuVo menuVo : menuVoList) {
            List<MenuVo> subMenuVoList = new ArrayList<>();
            // 查找子级
            for (SysMenu sysMenu : menuList) {
                if (menuVo.getMenuId().equals(sysMenu.getParentId())) {
                    subMenuVoList.add(menuToMenuVo(sysMenu));
                }
                // 递归调用，不管有几级菜单，都能够适用
                findChildMenu(menuList, subMenuVoList);

                subMenuVoList.sort(Comparator.comparing(MenuVo::getOrderNum));
            }
            menuVo.setChildren(subMenuVoList);
        }
    }

    /**
     * 类转换
     *
     * @param menu
     * @return
     */
    private MenuVo menuToMenuVo(SysMenu menu) {
        MenuVo menuVo = new MenuVo();
        BeanUtils.copyProperties(menu, menuVo);
        return menuVo;
    }

}
