package com.hbsf.controller.page;

import com.hbsf.pojo.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 岑祥荣
 * @date 2020/1/6 19:12
 */
@Controller
@RequestMapping("/page/sys")
public class SystemController {
    @RequestMapping("/index")
    public String index(){
        return "page/index";
    }
    @RequestMapping("/main")
    public String main(){
        return "page/main";
    }
    @RequestMapping("/login")
    public String login(){
        return "page/login/login";
    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("page/login/login");
    }
    @RequestMapping("/newEmp")
    public String newEmp(HttpServletRequest request ){
        System.out.println("走没走");
        return "page/login/new";
    }

}
