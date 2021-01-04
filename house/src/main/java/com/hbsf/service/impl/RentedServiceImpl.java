package com.hbsf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbsf.mapper.RentingHouseMapper;
import com.hbsf.mapper.RoomMapper;
import com.hbsf.pojo.Employee;
import com.hbsf.pojo.RentingHouse;
import com.hbsf.pojo.RentingHouseExample;
import com.hbsf.service.RentedService;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 岑祥荣
 * @date 2020/1/10 11:09
 */
@Service
public class RentedServiceImpl implements RentedService {

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private RoomMapper roomMapper;
  
    @Override
    public TableResultBean selectByAllToTab(Integer page, Integer limit, RentingHouse rentingHouse,Employee employee) {

        Page<RentingHouse> pageHelper = PageHelper.startPage(page,limit);
        rentingHouse.setLodger(employee.getId());
       List<RentingHouse> rentingHouses=  rentingHouseMapper.selectBySelect(rentingHouse);
        TableResultBean table;
        if (rentingHouses.size()==0){
            table = new TableResultBean(500, "没有订单数据", Long.valueOf(getCount().toString()), rentingHouses);
        }else {
            table = new TableResultBean(0, "成功", Long.valueOf(getCount().toString()), rentingHouses);
        }
        System.out.println(rentingHouses);
        return table;
    }

    private Integer getCount() {
        RentingHouseExample ex = new RentingHouseExample();
        return rentingHouseMapper.countByExample(ex);
    }

}
