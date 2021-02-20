package com.mafei.laboratory.page.controller;

import com.mafei.laboratory.commons.utils.CookieUtils;
import com.mafei.laboratory.commons.utils.JwtUtils;
import com.mafei.laboratory.system.entity.SysUser;
import com.mafei.laboratory.system.service.SysMenuService;
import com.mafei.laboratory.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wutangsheng
 * @create 2021-02-19 13:04
 * @info
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService userService;

    private String prefix = "user";

    @GetMapping("/user")
    public String user() {
        return prefix + "/user";
    }

    @GetMapping("/userinfo")
    public String userinfo(HttpServletRequest request, Model model) {
        Cookie cookie = CookieUtils.getCookie(request);
        String token = cookie.getValue();
        Map<String, Object> map = JwtUtils.parseToken(token);
        Long userId = Long.valueOf(String.valueOf(map.get("userId")));
        SysUser user = userService.queryById(userId);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("avatar", user.getAvatar());
        model.addAttribute("loginName", user.getLoginName());
        model.addAttribute("email", user.getEmail());

        return prefix + "/userinfo";
    }

    @GetMapping("/changePwd")
    public String changePwd() {
        return prefix + "/changePwd";
    }

}
