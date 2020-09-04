package com.uni.uniossspringbootstarter;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 岑祥荣
 * @date 2020/9/2
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "unioss.info")
@Component
public class AliyunInfo {
    /**
     * 默认sts过期时间
     */
    private Long stsTokenDurationSeconds = 3600L;
    /**
     * 拥有较高权限的子账号
     */
    private String accesskeyId;
    private String accesskeySecret;

    /**
     * 桶
     */
    private String bucketName;

    /**
     * 点播服务接入区域
     */
    private String regionidShanghai;
    private String locationShanghai;
    private String endpointShanghai;
    private String endpointShanghaiInternal;

//    /**
//     * 点播服务控制台
//     */
//    public static final DefaultAcsClient ACS_CLIENT = new DefaultAcsClient(
//            DefaultProfile.getProfile(REGIONID_SHANGHAI, ACCESSKEY_ID, ACCESSKEY_SECRET));

}
