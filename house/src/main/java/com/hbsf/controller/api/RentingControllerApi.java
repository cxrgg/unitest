package com.hbsf.controller.api;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbsf.pojo.Employee;
import com.hbsf.pojo.EmployeeRole;
import com.hbsf.pojo.RentingHouse;
import com.hbsf.service.RentingService;
import com.hbsf.service.UserService;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import com.hbsf.websocket.SocketServer;
import com.sun.jnlp.ApiDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

/**
 * @author 岑祥荣
 * @date 2020/1/9 10:14
 */
@RestController
@RequestMapping("/api/renting")
public class RentingControllerApi {

    @Autowired
    private RentingService rentingService;
    @Autowired
    private UserService userService;
    /*
    管理员专属 所有订单列表
     */
    @RequestMapping("/list")
    public TableResultBean list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit , RentingHouse rentingHouse){

        return  rentingService.selectByAllToTab(page,limit,rentingHouse);
    }
    /*
    房主专属 订单列表
     */
    @RequestMapping("/myList")
    public TableResultBean myList(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit , RentingHouse rentingHouse,HttpServletRequest request){
        HttpSession session = request.getSession();
        Employee employee = (Employee)session.getAttribute("employee");
        return  rentingService.selectToTab(page,limit,rentingHouse,employee);
    }
    /*
    预订房屋
     */
    @RequestMapping("/toRenting")
    public ResultBean toRenting(Integer id, String beTime, HttpServletRequest request){
        Employee employee = (Employee)request.getSession().getAttribute("employee");
        ResultBean resultBean = rentingService.insert(id,beTime,employee);

        if (resultBean.getCode()==200){
            Integer data = (Integer)resultBean.getData();
            System.out.println(data);
            SocketServer.sendMessage("1111",data.toString());
        }
//        SocketServer.sendMessage(msg, username);
        return resultBean;
    }

    @RequestMapping("/delete")
    public ResultBean delete(String enos){
        return rentingService.delete(enos);
    }
    @RequestMapping("/add")
    public ResultBean update(Integer id,String beTime){
        System.out.println(id);
        System.out.println(beTime+"1");
        return rentingService.update(id,beTime);
    }




}
