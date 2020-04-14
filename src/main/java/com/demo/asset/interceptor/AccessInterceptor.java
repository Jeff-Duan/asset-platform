package com.demo.asset.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    HttpSession session;

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) {
        if (modelAndView != null) {
            modelAndView.getModel().put("User", session.getAttribute("userName"));
            modelAndView.getModel().put("Role", (boolean) session.getAttribute("userRole") ? 1 : 0);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        return true;
    }
}
