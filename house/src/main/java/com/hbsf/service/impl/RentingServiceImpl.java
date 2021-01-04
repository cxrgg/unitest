package com.hbsf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbsf.mapper.EmployeeMapper;
import com.hbsf.mapper.EmployeeRoleMapper;
import com.hbsf.mapper.RentingHouseMapper;
import com.hbsf.mapper.RoomMapper;
import com.hbsf.pojo.*;
import com.hbsf.service.RentingService;
import com.hbsf.service.UserService;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 岑祥荣
 * @date 2020/1/9 10:10
 */
@Service
public class RentingServiceImpl implements RentingService {

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    /*
    管理员查房
     */
    @Override
    public TableResultBean selectByAllToTab(Integer page, Integer limit, RentingHouse rentingHouse) {
        Page<RentingHouse> pageHelper = PageHelper.startPage(page,limit);

        RentingHouseExample ex = new RentingHouseExample();
        List<RentingHouse> rentingHouses = rentingHouseMapper.selectByExample(ex);
        TableResultBean table;
        if (rentingHouses.size()==0){
            table = new TableResultBean(500, "没有订单数据", Long.valueOf(getCount().toString()), rentingHouses);
        }else {
            table = new TableResultBean(0, "成功", Long.valueOf(getCount().toString()), rentingHouses);
        }
        return table;
    }
    /*
        用户
         */
    @Override
    public TableResultBean selectToTab(Integer page, Integer limit, RentingHouse rentingHouse, Employee employee) {
        Page<RentingHouse> pageHelper = PageHelper.startPage(page,limit);

        RentingHouseExample ex = new RentingHouseExample();
        ex.createCriteria().andLandlordEqualTo(employee.getId());
        List<RentingHouse> rentingHouses = rentingHouseMapper.selectByExample(ex);
        TableResultBean table;

        if (rentingHouses.size()==0){
            table = new TableResultBean(500, "没有订单数据", Long.valueOf(getCount().toString()), rentingHouses);
        }else {
            table = new TableResultBean(0, "成功", Long.valueOf(getCount().toString()), rentingHouses);
        }
        return table;
    }

    /*
    预订房屋
     */

    @Override
    @Transactional
    public ResultBean insert(Integer id, String beTime,Employee employee) {
        Room room = roomMapper.selectByPrimaryKey(id);
        String[] split = beTime.split(" - ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date bTime = null;
        Date eTime = null;
        try {
            bTime = format.parse(split[0]);
            eTime = format.parse(split[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RentingHouseExample ex = new RentingHouseExample();
        RentingHouseExample.Criteria criteria = ex.createCriteria().andRoomEqualTo(id);
        List<RentingHouse> rentingHouses = rentingHouseMapper.selectByExample(ex);

        long begin = bTime.getTime();
        long end = eTime.getTime();

        for (RentingHouse reserve_House : rentingHouses) {
            long b_time = reserve_House.getStime().getTime();
            long e_time = reserve_House.getEtime().getTime();
            if((begin<=e_time && begin>=b_time||end<=e_time && end>=b_time||b_time>=begin&&e_time<=end)&&reserve_House.getStatus().equals(1) ){
                return ResultBean.fail("您预定的日期中有已被别人预定的时间，请重新选择");
            }
        }

        RentingHouse rentingHouse = new RentingHouse(null, id, room.getOwner(), employee.getId(), new Date(), bTime, eTime, "0", null);
        int insert = rentingHouseMapper.insert(rentingHouse);
        if (insert==1){
//            room.setState(2);
//            int i = roomMapper.updateByPrimaryKey(room);
            return ResultBean.ok(room.getOwner());
        }
        return ResultBean.fail("预订失败");
    }
    /*
    删除预订单
     */
    @Override
    public ResultBean delete(String enos) {
        int i = rentingHouseMapper.deleteByEnos(enos);
        if (i==0){
            return ResultBean.fail("删除失败");
        }
        return ResultBean.ok();
    }

    @Override
    public ResultBean update(Integer id, String beTime) {

        String[] split = beTime.split(" - ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date bTime = null;
        Date eTime = null;
        try {
            bTime = format.parse(split[0]);
            eTime = format.parse(split[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RentingHouse rentingHouse = new RentingHouse(id, null, null, null, null, bTime, eTime, null, null);
        int i = rentingHouseMapper.updateByPrimaryKeySelective(rentingHouse);
        if (i==0){
            return ResultBean.fail("失败");
        }
        return ResultBean.ok();
    }

    public Integer getCount() {
        RentingHouseExample ex = new RentingHouseExample();
        return rentingHouseMapper.countByExample(ex);
    }

}
