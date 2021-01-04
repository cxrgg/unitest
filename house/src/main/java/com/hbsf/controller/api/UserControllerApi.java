package com.hbsf.controller.api;


import com.hbsf.pojo.Employee;
import com.hbsf.service.UserService;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 岑祥荣
 * @date 2020/1/6 20:33
 */
@RestController
@RequestMapping("/api/employee")
public class UserControllerApi {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public ResultBean login(String username, String password,String imgCode,HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String loginCapcha = (String) session.getAttribute("loginCapcha");
        /*if (!loginCapcha.toLowerCase().equals(imgCode.toLowerCase())){
           return  ResultBean.fail("验证码错误");
        }*/
        ResultBean login = userService.login(username, password);
        if (login.getCode()==200){
            /*
            session 会话
            session作用域
             */
            session.setAttribute("employee",login.getData());
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);
        }
        /*
        json
         */
        return login;
    }

    /**
     * 返回所有员工 以结果集的形式
     * @return
     */
    @RequestMapping("/list")
    public ResultBean list(){
        ResultBean resultBean = userService.selectByAll();
        return resultBean;
    }
    @RequestMapping("/tabList")
    public TableResultBean tabList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, Employee employee){
        return userService.selectByAllToTab(page,limit,employee);
    }

    /**
     * 根据id查询单个用户,返回这个用户所有的信息
     * @param id
     * @return
     */
    @RequestMapping("/one/{id}")
    public ResultBean one(@PathVariable("id") Integer id ){

        return userService.selectByOne(id);
    }
    /**
     * 新增或者修改房屋信息
     *
     * @return 结果集
     */
    @RequestMapping("/add")
    public ResultBean add(Employee employee) {
        ResultBean ok = new ResultBean();
            if(employee.getId() ==null){
            ok = userService.insert(employee);
        }else {
            ok = userService.update(employee);
        }
        return ok;
    }
    @RequestMapping("/delete")
    public ResultBean delete(String enos){
        return userService.delete(enos);
    }
}
