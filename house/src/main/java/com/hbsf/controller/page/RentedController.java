package com.hbsf.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 岑祥荣
 * @date 2020/1/10 11:06
 */

@Controller
@RequestMapping("/page/rented")
public class RentedController {
    /**
     * 跳转到我的租借页面
     * @return
     */
    @RequestMapping("/rentOrder")
    public String renting(){
        return "page/rented/rentedList";
    }

}