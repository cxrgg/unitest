package com.hbsf.service;

import com.hbsf.pojo.Employee;
import com.hbsf.pojo.Room;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import org.apache.ibatis.annotations.Select;

/**
 * @author 岑祥荣
 * @date 2020/1/7 14:34
 */
public interface RoomService {


    Integer getCount();

    TableResultBean SelectRoom(Integer page, Integer limit, Room room, Employee employee);

    TableResultBean SelectRoomEmp(Integer page, Integer limit, Room room, Employee employee);

    ResultBean insert(Room room,Employee employee);

    ResultBean update(Room room);

    ResultBean delete(String enos);

    ResultBean selectByOne(Integer id);


}
