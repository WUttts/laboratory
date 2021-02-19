package com.mafei.laboratory.system.controller;

import com.mafei.laboratory.system.entity.SysMenu;
import com.mafei.laboratory.system.entity.vo.MenuVo;
import com.mafei.laboratory.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author wutangsheng
 * @since 2021-02-18 11:07:01
 */
@RestController
@RequestMapping("/api/sysMenu")
@RequiredArgsConstructor
public class SysMenuController {
    private final SysMenuService menuService;

    @GetMapping
    public ResponseEntity<Object> getMenus(Long roleId) {
        List<MenuVo> menuVos = menuService.queryMenuByRole(roleId);
        return ResponseEntity.ok(menuVos);
    }

}
