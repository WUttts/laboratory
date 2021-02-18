package com.mafei.laboratory.system.controller;

import com.mafei.laboratory.commons.exception.BadRequestException;
import com.mafei.laboratory.system.entity.dto.UserDto;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author wutangsheng
 * @create 2021-02-17 17:30
 * @info
 */

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private String verCode;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@Validated @RequestBody UserDto authUser, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(authUser);
        String code = authUser.getCaptcha();
        // 判断验证码
        if (StringUtils.isBlank(code) || StringUtils.isEmpty(code)) {
            throw new BadRequestException("验证码不存在或已过期");
        }
        if (!StringUtils.isEmpty(verCode) && !verCode.equals(code)) {
            // 清除session中的验证码
            CaptchaUtil.clear(request);
            throw new BadRequestException("验证码错误");
        }

        // todo 验证账号密码

        // todo 生成token


        return ResponseEntity.ok("ok");
    }

    /**
     * 图形验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(120, 38);
        this.verCode = captcha.text().toLowerCase();
        CaptchaUtil.out(captcha, request, response);
    }
}
