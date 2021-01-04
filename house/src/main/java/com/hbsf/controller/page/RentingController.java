package com.hbsf.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 岑祥荣
 * @date 2020/1/9 10:35
 */
@Controller
@RequestMapping("/page/renting")
public class RentingController {
    /*
    新建房屋订单
     */
    @RequestMapping("/newRentOrder")
    public String renting(){
        return "page/renting/newRentOrder";
    }
    /*
    我的订单 房主 我的房屋被预定
     */
    @RequestMapping("/myRentingOrder")
    public String myRentOrder(){
        return "page/renting/myRentingOrder";
    }
    /*
    所有订单  管理员
     */
    @RequestMapping("/rentingList")
    public String rentingList(){
        return "page/renting/rentingList";
    }
  @RequestMapping("/rentingAdd")
    public String rentingAdd(){
        return "page/renting/rentingAdd";
    }

}
