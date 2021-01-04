package com.hbsf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbsf.mapper.*;
import com.hbsf.pojo.*;
import com.hbsf.service.UserService;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 岑祥荣
 * @date 2020/1/6 19:22
 * 用户业务层
 * 处理用户信息
 * 分为UserService和UserServiceImpl
 * UserService是接口，里面只能定义方法名，不能有内容也就是不能有{}
 * UserServiceImpl是UserService的实现类，用来实现UserService 里面的方法
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;
    /**
     *
     *登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultBean login(String username,String password) {

        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andNameEqualTo(username);
        List<Employee> employees = employeeMapper.selectByExample(example);

        if(employees ==null || employees.size()==0){
            return ResultBean.fail("用户名或者密码错误");
        }
        Employee employee = employees.get(0);
        if(!employee.getPassword().equals(password)){
            return ResultBean.fail("用户名或者密码错误");
        }
        if(employee.getStatus().equals(0)){
            return ResultBean.fail("账户已经注销");
        }

        return ResultBean.ok(employee);
    }

    @Override
    public ResultBean selectByAll() {
        EmployeeExample example = new EmployeeExample();
        List<Employee> employees = employeeMapper.selectByExample(example);
        return ResultBean.ok(employees);
    }

    @Override
    public TableResultBean selectByAllToTab(Integer page, Integer limit, Employee employee) {
        Page<EmployeeExample> es = PageHelper.startPage(page, limit);
        List<Employee> employees = employeeMapper.selectBySelect(employee);
        TableResultBean table = new TableResultBean(0, "成功", Long.valueOf(getCount().toString()), employees);
        return table;
    }

    @Override
    public ResultBean selectByOne(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return ResultBean.ok(employee);
    }

    /**
     * 新增操作
     * @param employee
     * @return
     */
    @Override
    @Transactional
    public ResultBean insert(Employee employee) {
        Employee empByName = getEmpByName(employee.getName());
        if(empByName.getId()!=null){
            return ResultBean.fail("用户名重复");
        }
        /*
        在此设置激活用户
         */
        employee.setStatus(1);
        /*
        增加用户
         */
        int i = employeeMapper.insert(employee);
        /*
        新增用户权限
         */
        switch (employee.getRank()){

            case 0:employeeRoleMapper.insertSelective(new EmployeeRole(null,employee.getId(),1,null));break;
            case 1:employeeRoleMapper.insertSelective(new EmployeeRole(null,employee.getId(),2,null));break;
        }
        if(i==0){
            return ResultBean.fail("失败");
        }
        return ResultBean.ok();
    }

    @Override
    public ResultBean update(Employee employee) {
        Employee empByName = getEmpByName(employee.getName());
        Employee empById = getEmpById(employee.getId());
        /**
         * 如果用户名没有改 就不验证用户名是否重复
         */
        if(!empById.getName().equals(empByName.getName())){
            if(empByName.getId()!=null){
                return ResultBean.fail("用户名重复");
            }
        }
        int i = employeeMapper.updateByPrimaryKeySelective(employee);
        if(i==1){
            return ResultBean.ok();
        }
        return ResultBean.fail("失败");
    }

    @Override
    public ResultBean delete(String enos) {
//        int i = employeeMapper.delete(enos);
        

        int i = employeeMapper.delete(enos);
        if (i==0){
            return ResultBean.fail("删除失败");
        }
        return ResultBean.ok();
    }

    /**
     * 获取当前操作表的所有数据个数
     * @return
     */
    @Override
    public Integer getCount() {
        EmployeeExample example = new EmployeeExample();
        return employeeMapper.countByExample(example);
    }
    public Employee getEmpById(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据姓名查找用户
     * @param name
     * @return 返回查找到的员工
     */
    public Employee getEmpByName(String name){
        EmployeeExample ex = new EmployeeExample();
        ex.createCriteria().andNameEqualTo(name);
        List<Employee> employees = employeeMapper.selectByExample(ex);
        if (employees.size()!=0&&employees!=null){
            return employees.get(0);
        }
        return new Employee();
    }

}
