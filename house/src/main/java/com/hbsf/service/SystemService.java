package com.hbsf.service;



import com.hbsf.pojo.Employee;
import com.hbsf.util.NavBean;

import java.util.List;

/**
 * @author 岑祥荣
 * @date 2019/12/26 9:42
 */
public interface SystemService {

    List<NavBean> selectNavs(Employee employee);
}
