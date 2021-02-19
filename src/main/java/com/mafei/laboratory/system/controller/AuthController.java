package com.mafei.laboratory.system.controller;

import com.mafei.laboratory.commons.exception.BadRequestException;
import com.mafei.laboratory.commons.utils.JwtUtils;
import com.mafei.laboratory.system.entity.vo.LoginUserVo;
import com.mafei.laboratory.system.service.SysMenuService;
import com.mafei.laboratory.system.service.SysUserService;
import com.mafei.laboratory.system.service.dto.UserDto;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
    private final SysUserService userService;
    private final SysMenuService menuService;

    private String verCode;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Validated @RequestBody UserDto authUser, HttpServletRequest request) throws Exception {
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
        LoginUserVo user = userService.queryByUsername(authUser);
        // todo 生成token
        Map<String, Object> map = new HashMap<>(3);
        map.put("user", user.getUserName());
        map.put("avatar", user.getAvatar());
        map.put("roleId", user.getRoleId());

        String token = JwtUtils.createToken(map);
        //返回菜单
        return ResponseEntity.ok(token);
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
