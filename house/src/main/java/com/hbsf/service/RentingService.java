package com.hbsf.service;

import com.hbsf.pojo.Employee;
import com.hbsf.pojo.RentingHouse;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;

/**
 * @author 岑祥荣
 * @date 2020/1/9 10:10
 */
public interface RentingService {
    TableResultBean selectByAllToTab(Integer page, Integer limit, RentingHouse rentingHouse);
    TableResultBean selectToTab(Integer page, Integer limit, RentingHouse rentingHouse,Employee employee );
    ResultBean insert(Integer id, String beTime, Employee employee);

     ResultBean delete(String enos);

    ResultBean update(Integer id, String beTime);
}
