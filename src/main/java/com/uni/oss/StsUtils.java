//package com.uni.oss;
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.http.MethodType;
//import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
//import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
//
///**
// * @author 岑祥荣
// * @date 2020/9/2
// */
//public class StsUtils {
//
//    /**
//     * 获取oss读取权限的sts凭证
//     *
//     * @return
//     * @throws ClientException
//     */
//    public static AssumeRoleResponse.Credentials getVODWriteOnlyCredentials() throws ClientException {
//
//        DefaultAcsClient client = AliyunInfo.ACSCLIENT;
//        AssumeRoleRequest request = new AssumeRoleRequest();
//        request.setSysMethod(MethodType.POST);
////        request.setRoleArn(AliyunInfo.NCRVIDEO_WRITEONLY_ROLEARN);
////        request.setRoleArn(AliyunInfo.NCRVIDEO_READONLY_ROLEARN);
//        request.setRoleArn(AliyunInfo.NCRSTATIC_GETANDPUT_ROLEARN);
//        request.setRoleSessionName("test");
//        request.setDurationSeconds(AliyunInfo.STS_TOKEN_DURATION_SECONDS);
//        AssumeRoleResponse response = client.getAcsResponse(request);
//        return response.getCredentials();
//
//    }
//
//    public static void main(String[] args) throws ClientException {
//        final AssumeRoleResponse.Credentials vodWriteOnlyCredentials = getVODWriteOnlyCredentials();
//        System.out.println(vodWriteOnlyCredentials);
//    }
//
//    /**
//     * 获取VOD读取权限的sts凭证
//     *
//     * @return
//     * @throws ClientException
//     */
//    public static AssumeRoleResponse.Credentials getVODALLCredentials() throws ClientException {
//
//        DefaultAcsClient client = AliyunInfo.STS_VOD_CLIENT;
//        AssumeRoleRequest request = new AssumeRoleRequest();
//        request.setSysMethod(MethodType.POST);
//        request.setRoleArn(AliyunInfo.NCRVIDEO_WRITEONLY_ROLEARN);
//        request.setRoleSessionName("test");
//        request.setDurationSeconds(AliyunInfo.STS_TOKEN_DURATION_SECONDS);
//        AssumeRoleResponse response = client.getAcsResponse(request);
//        return response.getCredentials();
//
//    }
//
//    /**
//     * 方法重载 可自定义 填写sessionName 和 durationSeconds
//     *
//     * @return
//     * @throws ClientException
//     */
//    public static AssumeRoleResponse.Credentials getOSSAllCredentials(String roleArn, String sessionName, long durationSeconds) throws ClientException {
//
//        DefaultAcsClient client = AliyunInfo.STS_VOD_CLIENT;
//        AssumeRoleRequest request = new AssumeRoleRequest();
//        request.setSysMethod(MethodType.POST);
//        request.setRoleArn(roleArn);
//        request.setRoleSessionName(sessionName);
//        request.setDurationSeconds(durationSeconds);
//        AssumeRoleResponse response = client.getAcsResponse(request);
//        return response.getCredentials();
//
//    }
//}
