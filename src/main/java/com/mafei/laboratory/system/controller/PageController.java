package com.mafei.laboratory.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wutangsheng
 * @create 2021-02-10 1:16
 * @info 管理常用页面，首页 404等
 */
@Controller
public class PageController {

    /**
     * @return 主页
     */
    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    /**
     * 登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * @return 404
     */
    @GetMapping("/error")
    public String error() {
        return "/error";
    }

    @GetMapping("/main")
    public String main() {
        return "/lyear_main";
    }
}
