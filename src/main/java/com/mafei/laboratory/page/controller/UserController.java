package com.mafei.laboratory.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wutangsheng
 * @create 2021-02-19 13:04
 * @info
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private String prefix = "user";

    @GetMapping("/userinfo")
    public String userinfo() {
        return prefix + "/userinfo";
    }

    @GetMapping("/changePwd")
    public String changePwd() {
        return prefix + "/changePwd";
    }
}
