package com.hbsf.service;

import com.hbsf.pojo.Employee;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;

/**
 * @author 岑祥荣
 * @date 2020/1/6 19:21
 */
public interface UserService {

    ResultBean login(String username, String password);

    ResultBean selectByAll();

    ResultBean selectByOne(Integer id);

    public Integer getCount();

    TableResultBean selectByAllToTab(Integer page, Integer limit, Employee employee);

    ResultBean insert(Employee employee);

    ResultBean update(Employee employee);

    public Employee getEmpByName(String name);

    ResultBean delete(String enos);
}
