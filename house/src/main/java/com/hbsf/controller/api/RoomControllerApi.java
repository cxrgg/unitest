package com.hbsf.controller.api;

import com.hbsf.pojo.Employee;
import com.hbsf.pojo.Room;
import com.hbsf.service.RoomService;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 岑祥荣
 * @date 2020/1/7 11:16
 */
@RestController
@RequestMapping("/api/room")
public class RoomControllerApi {

    @Autowired
    private RoomService roomService;

    /**
     * 管理员
     * 修改返回房屋列表
     */
    @RequestMapping("/list")
    public TableResultBean list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, Room room, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Employee employee = (Employee)session.getAttribute("employee");
//        System.out.println("roomlist"+employee);
        TableResultBean tableResultBean = roomService.SelectRoom(page, limit, room,employee);
        return tableResultBean;
    }

    /**
     *
     * @param page
     * @param limit
     * @param room
     * @param request
     * @return
     */
    @RequestMapping("/userList")
    public TableResultBean userList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit, Room room, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Employee employee = (Employee)session.getAttribute("employee");

        TableResultBean tableResultBean = roomService.SelectRoomEmp(page, limit, room,employee);
        return tableResultBean;
    }

    /**
     * 新增或者修改房屋信息
     *
     * @return 结果集
     */
    @RequestMapping("/add")
    public ResultBean add(Room room,HttpServletRequest request) {
        ResultBean ok = new ResultBean();
        Employee employee = (Employee)request.getSession().getAttribute("employee");

        if(room.getId() ==null){
            ok = roomService.insert(room,employee);
        }else {
            ok = roomService.update(room);
        }
        return ok;
    }

    @RequestMapping("/delete")
    public ResultBean delete(String enos){

        return roomService.delete(enos);
    }

    /**
     * 根据id查询单个用户,返回这个用户所有的信息
     * @param id
     * @return
     */
    @RequestMapping("/one/{id}")
    public ResultBean one(@PathVariable("id") Integer id ){
        return roomService.selectByOne(id);
    }

}
