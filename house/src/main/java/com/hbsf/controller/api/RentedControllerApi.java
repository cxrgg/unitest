package com.hbsf.controller.api;

import com.hbsf.pojo.Employee;
import com.hbsf.pojo.RentingHouse;
import com.hbsf.service.RentedService;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 岑祥荣
 * @date 2020/1/10 11:07
 */
@RestController
@RequestMapping("/api/rented")
public class RentedControllerApi {
    @Autowired
    private RentedService rentedService;

    @RequestMapping("/list")
    public TableResultBean list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit , RentingHouse rentingHouse, HttpServletRequest request){
        Employee employee = (Employee)request.getSession().getAttribute("employee");
        return  rentedService.selectByAllToTab(page,limit,rentingHouse,employee);
    }

}
