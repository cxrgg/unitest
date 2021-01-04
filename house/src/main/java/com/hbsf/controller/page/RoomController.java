package com.hbsf.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 岑祥荣
 * @date 2020/1/7 11:18
 */
@Controller
@RequestMapping("/page/room")
public class RoomController {

    @RequestMapping("/roomlist")
    public String list(){
        return "page/room/room";
    }
    @RequestMapping("/myroomlist")
    public String mylist(){
        return "page/room/myroom";
    }
    @RequestMapping("/add")
    public String add(){
        return "page/room/roomAdd";
    }

}
