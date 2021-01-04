package com.hbsf.service;

import com.hbsf.pojo.Employee;
import com.hbsf.pojo.RentingHouse;
import com.hbsf.util.TableResultBean;

/**
 * @author 岑祥荣
 * @date 2020/1/10 11:09
 */
public interface RentedService {
    public TableResultBean selectByAllToTab(Integer page, Integer limit, RentingHouse rentingHouse, Employee employee);
}
