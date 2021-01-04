package com.hbsf;

import com.hbsf.pojo.Room;
import com.hbsf.service.RoomService;
import com.hbsf.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class HouseApplicationTests {

    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
//        for (int i = 0; i < 100; i++) {
//            Employee room = new Employee(null,i+"用户","123456",null,"1","1589"+i,"34110119980101"+i,1);
//            userService.insert(room);
//        }
        /*for (int i = 0; i < 100; i++) {
            Room room = new Room(null, i + "小区", "安徽省合肥市" + i + "小区", "三室两厅", new BigDecimal(45.45), 1, i + "0", new Date(), 1, 0);
            roomService.insert(room);
//        }

        }*/

        for (int i = 0; i < 100; i++) {
            int v = (int)(Math.random() * 9) + 1;
            System.out.println(v);
        }

    }}
