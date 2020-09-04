package com.uni.uniossspringbootstarter.configuration;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.uni.uniossspringbootstarter.AliyunInfo;
import com.uni.uniossspringbootstarter.AliyunOSSTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 岑祥荣
 * @date 2020/9/4
 */
@Configuration
@EnableConfigurationProperties(AliyunInfo.class)
public class OSSAutoConfiguration {
    @Bean
    public AliyunOSSTemplate getBean(AliyunInfo aliyunInfo) {

        OSS ossClient = new OSSClientBuilder().build(aliyunInfo.getEndpointShanghai(), aliyunInfo.getAccesskeyId(), aliyunInfo.getAccesskeySecret());

        return new AliyunOSSTemplate(ossClient,aliyunInfo);
    }
}
