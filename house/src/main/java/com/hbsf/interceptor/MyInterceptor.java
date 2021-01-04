package com.hbsf.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 岑祥荣
 * @date 2019/12/26 11:45
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    /**
     * 配置拦截器
     * 拦截规则
     * 所有的都拦截
     * 放行包含login,和logout
     * 放行所有api
     * 其他的页面
     * 如果页面有对象 放行
     * 其他的都到回到登录页面
     * @param
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getRequestURI().contains("phone")||request.getRequestURI().contains("login")||request.getRequestURI().contains("capt")){
            return true;
        }
        Object user = request.getSession().getAttribute("employee");
        if (request.getRequestURI().contains("api")||request.getRequestURI().contains(".jpg")) {
            response.setContentType("application/json;charset=utf-8");
            if (user == null) {
                response.sendRedirect("登陆过期");
            } else {
                //放行
                return true;
            }
        } else {
            if (user == null) {
                //跳转到登录页
                response.sendRedirect(request.getContextPath()+"/page/sys/login");
            } else {
                //放行
                return true;
            }
        }
        return false;
    }
}