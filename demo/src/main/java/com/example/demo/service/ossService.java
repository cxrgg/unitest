package com.example.demo.service;

import com.uni.uniossspringbootstarter.AliyunOSSTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author 岑祥荣
 * @date 2020/9/4
 */
@Service
public class ossService {

    @Autowired
    private AliyunOSSTemplate aliyunOSSTemplate;

}
