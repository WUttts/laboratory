package com.mafei.laboratory.commons.interceptor;

import com.mafei.laboratory.commons.exception.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wutangsheng
 * @create 2021-02-10 21:36
 * @info 全局拦截器，主要用于验证token的合法性
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 验证token,部分接口不拦截，例如登录接口等
        String token = request.getHeader("token");
        System.out.println(token);
        if (!StringUtils.hasText(token)) {
            //跳转
            response.sendRedirect("/login");
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
