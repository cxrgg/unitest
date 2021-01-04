package com.hbsf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbsf.mapper.EmployeeMapper;
import com.hbsf.mapper.EmployeeRoleMapper;
import com.hbsf.mapper.RoomMapper;
import com.hbsf.pojo.*;
import com.hbsf.service.RoomService;
import com.hbsf.util.ResultBean;
import com.hbsf.util.TableResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 岑祥荣
 * @date 2020/1/7 14:36
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    /**
     * 查询房源列表
     *
     * @param page     当前第几页
     * @param limit    一页几条数据
     * @param room     用来模糊查询
     * @param employee 根据权限判别
     * @return
     */
    @Override
    public TableResultBean SelectRoom(Integer page, Integer limit, Room room, Employee employee) {

        Page<RoomExample> es = PageHelper.startPage(page, limit);
        List<Room> rooms = null;
        /*
        查询员工角色
        如果是管理员查所有
        用户查正在出租的
         */
        EmployeeRoleExample ex = new EmployeeRoleExample();
        ex.createCriteria().andEmpidEqualTo(employee.getId());
        List<EmployeeRole> employeeRoles = employeeRoleMapper.selectByExample(ex);
        EmployeeRole employeeRole = employeeRoles.get(0);

        if (employeeRole.getRoleid() == 1) {
            rooms = roomMapper.selectBySelect(room);
        } else {
            room.setState(1);
            rooms = roomMapper.selectBySelect(room);
        }
        TableResultBean table = new TableResultBean(0, "成功", Long.valueOf(getCount().toString()), rooms);
        return table;
    }

    /*
    ajax查询
    用来获取房屋名
     */
    @Override
    public TableResultBean SelectRoomEmp(Integer page, Integer limit, Room room, Employee employee) {

        Page<RoomExample> es = PageHelper.startPage(page, limit);
        List<Room> rooms = null;
        if (employee.getRank() == 0) {
            rooms = roomMapper.selectBySelect(room);
        } else {
//            room.setState(1);
            room.setOwner(employee.getId());
            rooms = roomMapper.selectBySelect(room);
        }
        TableResultBean table = new TableResultBean(0, "成功", Long.valueOf(getCount().toString()), rooms);

        return table;

    }

    /**
     * 事务
     * 新增房屋
     *
     * @param room     要增加的房屋参数
     * @param employee 当前操作人
     * @return
     */
    @Override
    /*
    事务
     */
    @Transactional
    public ResultBean insert(Room room, Employee employee) {
        room.setCreatetime(new Date());
       /*
       这块是判断是否是管理员操作
       否则将当前操作者id塞进Room里面
       因为新增房屋的时候管理员和用户是不一样的
       用户页面没有选择房屋主人是谁
       不这样做会报空指针
        */
        EmployeeRoleExample ex = new EmployeeRoleExample();
        ex.createCriteria().andEmpidEqualTo(employee.getId());
        List<EmployeeRole> employeeRoles = employeeRoleMapper.selectByExample(ex);
        EmployeeRole employeeRole = employeeRoles.get(0);
        if (employeeRole.getRoleid() != 0) {
            room.setOwner(employee.getId());
        }

        /*
        新增操作
         */
        int insert = roomMapper.insert(room);
        if (insert == 1) {
            return ResultBean.ok();
        }
        return ResultBean.fail("新增失败");
    }


    @Override
    public ResultBean update(Room room) {
        room.setCreatetime(new Date());
        int update = roomMapper.updateByPrimaryKeySelective(room);
        if (update == 1) {
            return ResultBean.ok();
        }
        return ResultBean.fail("更新失败");
    }

    @Override
    public ResultBean delete(String enos) {
        int i = roomMapper.deleteByEnos(enos);
        if (i == 0) {
            return ResultBean.fail("删除失败");
        }
        return ResultBean.ok();
    }

    /**
     * 获取当前操作表的所有数据个数
     *
     * @return
     */
    @Override
    public Integer getCount() {
        RoomExample example = new RoomExample();
        return roomMapper.countByExample(example);
    }

    @Override
    public ResultBean selectByOne(Integer id) {
        Room room = roomMapper.selectByPrimaryKey(id);
        return ResultBean.ok(room);
    }
}
