package com.uni.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author 岑祥荣
 * @date 2020/9/2
 */
public class AliyunInfo {
    /**
     * 默认sts过期时间
     */
    public static final Long STS_TOKEN_DURATION_SECONDS = 3600L;

    /**
     * 拥有较高权限的子账号
     */
    public static final String ACCESSKEY_ID = "**************";
    public static final String ACCESSKEY_SECRET = "**************";

    /**
     * 桶
     */
    public static final String BUCKET_NAME = "**************";

    /**
     * 点播服务接入区域
     */
    public static final String REGIONID_SHANGHAI = "cn-shanghai";
    public static final String LOCATION_SHANGHAI = "oss-cn-shanghai";

    public static final String ENDPOINT_SHANGHAI = "**************";
    public static final String ENDPOINT_SHANGHAI_INTERNAL = "**************";

    /**
     * 点播服务控制台
     */
    public static final DefaultAcsClient ACS_CLIENT = new DefaultAcsClient(
            DefaultProfile.getProfile(REGIONID_SHANGHAI, ACCESSKEY_ID, ACCESSKEY_SECRET));

//    public static final DefaultAcsClient ACS_CLIENT = new DefaultAcsClient(
//            DefaultProfile.getProfile(REGIONID_SHANGHAI, "LTAI4G9w8FyotDgCV8hMXj3a", "QkRtsAHHXCgJ7hHN5PySdvHWMgPMp6"));

//    public static final DefaultAcsClient ACS_CLIENT = new DefaultAcsClient(
//            DefaultProfile.getProfile("cn-hangzhou", "LTAIND0debxba2t1", "NDg6oI3JqEXJ3jsjLYnVjBIEfbnmur"));

    /**
     * oss控制台
     */
    public static final OSS OSS_CLIENT = new OSSClientBuilder().build(ENDPOINT_SHANGHAI, ACCESSKEY_ID, ACCESSKEY_SECRET);


    public static void main(String[] args) {
//        OSS ossclient = OSSCLIENT;
        DefaultAcsClient acsclient = ACS_CLIENT;
        System.out.println(acsclient);
    }
}
