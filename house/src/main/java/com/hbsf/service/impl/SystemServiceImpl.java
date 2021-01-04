package com.hbsf.service.impl;

import com.hbsf.mapper.EmployeeMapper;
import com.hbsf.pojo.Employee;
import com.hbsf.pojo.Power;
import com.hbsf.service.SystemService;
import com.hbsf.util.NavBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 岑祥荣
 * @date 2019/12/26 9:44
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private EmployeeMapper employeeMapper;
//    @Autowired
//    private EmployeeRoleMapper employeeRoleMapper;
//    @Autowired
//    private com.hbsf.mapper.RoleMapper RoleMapper;
//    @Autowired
//    private RolePowerMapper rolePowerMapper;





    @Override
    public List<NavBean> selectNavs(Employee employee) {

        List<Power> powers = employeeMapper.selectNavs(employee.getId());
        List<NavBean> Navs = getChildren(powers,0);

        for (NavBean nav : Navs) {
            List<NavBean> children = getChildren(powers, nav.getId());
            nav.setChildren(children);
        }
        return Navs;
    }
    private List<NavBean> getChildren(List<Power> power,Integer parent ) {
        List<NavBean> childs = new ArrayList<NavBean>();

        for (Power power1 : power) {
            if (parent.equals(power1.getParentId())) {
                NavBean nav = new NavBean(power1.getId(),power1.getName(),
                        power1.getMenutype(),power1.getUrl(),false,null);
                childs.add(nav);
            }
        }
        return childs;
    }


}
