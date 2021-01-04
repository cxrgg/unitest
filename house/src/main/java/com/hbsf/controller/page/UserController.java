package com.hbsf.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 岑祥荣
 * @date 2020/1/6 19:20
 */
@Controller
@RequestMapping("/page/employee")
public class UserController {

    @RequestMapping("/employeelist")
    public String employeeList(){
        return "page/employee/empList";
    }
    @RequestMapping("/empAdd")
    public String empAdd(){
        return "page/employee/empAdd";
    }

}
