package com.example.demo.controller;

import com.uni.uniossspringbootstarter.AliyunInfo;
import com.uni.uniossspringbootstarter.AliyunOSSTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.DownloadService;

/**
 * @author 岑祥荣
 * @date 2020/9/4
 */
@RestController
@RequestMapping("oss")
public class ossController {

    @Autowired
    private AliyunOSSTemplate aliyunOSSTemplate;

    @RequestMapping("download")
    public void downloadFile(){
        aliyunOSSTemplate.downloadFile();
    }
}
