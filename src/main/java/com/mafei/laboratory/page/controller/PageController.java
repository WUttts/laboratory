package com.mafei.laboratory.page.controller;

import com.mafei.laboratory.commons.utils.CookieUtils;
import com.mafei.laboratory.commons.utils.JwtUtils;
import com.mafei.laboratory.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wutangsheng
 * @create 2021-02-10 1:16
 * @info 管理常用页面，首页 404等
 */
@Controller
@RequiredArgsConstructor
public class PageController {

    private final SysMenuService menuService;

    /**
     * @return 主页
     */
    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        String token = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (!StringUtils.isEmpty(cookie.getName()) && "token".equalsIgnoreCase(cookie.getName())) {
                token = cookie.getValue();
                break;
            }
        }

        Map<String, Object> map = JwtUtils.parseToken(token);
        Long roleId = Long.valueOf(String.valueOf(map.get("roleId")));
        model.addAttribute("avatar", map.get("avatar"));
        model.addAttribute("username", map.get("user") + "<span class=\"caret\"></span>");
        model.addAttribute("roleId", roleId);
        model.addAttribute("menus", menuService.queryMenuByRole(roleId));
        return "index";
    }

    /**
     * 登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        //否则就可以返回
        return "login";
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        Cookie cookie = CookieUtils.getCookie(request);
        CookieUtils.removeCookie(cookie);
        return "login";
    }

    /**
     * @return 404
     */
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/main")
    public String main() {
        return "lyear_main";
    }
}
