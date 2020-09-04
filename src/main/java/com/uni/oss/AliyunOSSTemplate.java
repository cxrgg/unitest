package com.uni.oss;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import com.aliyuncs.exceptions.ClientException;

import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * @author 岑祥荣
 * @date 2020/9/2
 */
public class AliyunOSSTemplate {

    private static final String ENDPOINT = "https://" + AliyunInfo.LOCATION_SHANGHAI;

    private static final OSS CLIENT = AliyunInfo.OSS_CLIENT;

    /**
     * 确认Bucket存在，没有就创建
     *
     * @param bucketName 类似于C盘 D盘
     */
    public static void ensureBucket(String bucketName) throws OSSException, com.aliyun.oss.ClientException {
        if (!CLIENT.doesBucketExist(bucketName)) {
            CLIENT.createBucket(bucketName);
        }
    }

    /**
     * 删除一个Bucket和其中的Objects
     *
     * @param bucketName 类似于C盘 D盘
     */
    /*
    public static void deleteBucket(String bucketName) throws OSSException, com.aliyun.oss.ClientException {
        if (CLIENT.doesBucketExist(bucketName)) {
            ObjectListing ObjectListing = CLIENT.listObjects(bucketName);
            List<OSSObjectSummary> listDeletes = ObjectListing.getObjectSummaries();
            for (OSSObjectSummary next : listDeletes) {
                CLIENT.deleteObject(bucketName, next.getKey());
            }
            CLIENT.deleteBucket(bucketName);
        }
    }*/


    /**
     * 简单上传
     *
     * @param bucketName 桶
     * @param filePath   文件在oss中的完整路径一直到后缀
     * @param file       文件
     */
    public static String simpleUploadFile(String bucketName, String filePath, File file) throws ClientException {
        ensureBucket(bucketName);
        PutObjectResult result = CLIENT.putObject(new PutObjectRequest(bucketName, filePath, file));
        return (result == null ? "" : result.getETag());
    }
    public static String simpleUploadInputStream(String bucketName, String filePath, String filename) throws ClientException, FileNotFoundException {
        ensureBucket(bucketName);
        PutObjectResult result = CLIENT.putObject(new PutObjectRequest(bucketName, filePath, new FileInputStream(filename)));
        return (result == null ? "" : result.getETag());
    }


    /**
     * 简单下载
     *
     * @param bucketName 桶
     * @param filePath   文件在oss中的完整路径一直到后缀
     * @throws ClientException ClientException
     */
    public static void simpleDownloadFile(String bucketName, String filePath, String filename) throws ClientException, IOException {
        ensureBucket(bucketName);
//        InputStream inputStream = new FileInputStream(filename);
        CLIENT.getObject(new GetObjectRequest(bucketName, filePath), new File(filename));
    }


    // 生成URL
    public static String getFileUrl(String bucketName, String key) throws OSSException, com.aliyun.oss.ClientException {
        URL url = CLIENT.generatePresignedUrl(bucketName, key, new Date(System.currentTimeMillis() + 3 * 3600 * 1000));
        return url.toString();
    }

    public static String getFileUrl(String bucketName, String key, String filename) throws OSSException, com.aliyun.oss.ClientException {
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, key);
        ResponseHeaderOverrides responseHeaderOverrides = new ResponseHeaderOverrides();
        responseHeaderOverrides.setContentDisposition("attachment;filename=" + filename);
        request.setResponseHeaders(responseHeaderOverrides);
        Date expiration = new Date(System.currentTimeMillis() + 3 * 3600 * 1000);
        request.setExpiration(expiration);
        URL url = CLIENT.generatePresignedUrl(request);
        return url.toString();
    }

    //创建文件夹
//    public static void createFolder(String bucketName, String folder) {
//        //文件夹名
//        final String keySuffixWithSlash = folder + "/";
//        CLIENT.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
//    }

//    public boolean doesObjectExist(String bucketName, String key) {
//        boolean found = false;
//        try {
//            found = CLIENT.doesObjectExist(bucketName, key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return found;
//    }

    /**
     * 关闭客户端
     */
    public void shutdown() {
        CLIENT.shutdown();
    }


    public static void main(String[] args) throws ClientException, IOException {

//        String s = simpleUploadFile(AliyunInfo.BUCKET_NAME, "oss/test/mxg.mp4", new File("E://mxg.mp4"));
        simpleUploadInputStream(AliyunInfo.BUCKET_NAME, "oss/test/mxg.mp4", "E://mxg.mp4");
//        String fileUrl = getFileUrl(AliyunInfo.BUCKET_NAME, "oss/test/mxg.mp4");
//        simpleDownloadFile(AliyunInfo.BUCKET_NAME, "oss/test/mxg.mp4", "cxr.mp4");
    }

}
