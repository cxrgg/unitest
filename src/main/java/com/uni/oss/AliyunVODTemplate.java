package com.uni.oss;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.mts.model.v20140618.*;
import com.aliyuncs.vod.model.v20170321.*;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author 岑祥荣
 * @date 2020/9/3
 */
public class AliyunVODTemplate {

    public static final DefaultAcsClient ACS_CLIENT = AliyunInfo.ACS_CLIENT;
    public static final OSS OSS_CLIENT = AliyunInfo.OSS_CLIENT;

    public static List<SearchPipelineResponse.Pipeline> searchPipeline() throws ServerException, ClientException {
        // 创建API请求并设置参数
        SearchPipelineRequest request = new SearchPipelineRequest();
        // 发起请求并处理应答或异常
        SearchPipelineResponse response = AliyunInfo.ACS_CLIENT.getAcsResponse(request);
        return response.getPipelineList();
    }

    public static SubmitMediaInfoJobResponse.MediaInfoJob getmediainfo(InputVO input)
            throws ServerException, ClientException {
        SubmitMediaInfoJobRequest request = new SubmitMediaInfoJobRequest();
        request.setInput(JSONObject.toJSONString(input));

        SubmitMediaInfoJobResponse response = AliyunInfo.ACS_CLIENT.getAcsResponse(request);

        return response.getMediaInfoJob();
    }

    private static String pipelineId = "0c9da8a3314a41a4a2c4a444e941624d";
    private static String templateId = "S00000002-100070";
    private static String ossLocation = "oss-cn-hangzhou";
    private static String ossBucket = AliyunInfo.BUCKET_NAME;
    private static String ossInputObject = "oss/test/mxg.mp4";
    private static String ossOutputObject = "output.mp4";

    public static void test() throws UnsupportedEncodingException {
        SubmitJobsRequest request = new SubmitJobsRequest();
        InputVO inputVO = new InputVO();
        inputVO.setBucket(AliyunInfo.BUCKET_NAME);
        inputVO.setLocation(ossLocation);
        inputVO.setObject(URLEncoder.encode(ossInputObject, "utf-8"));
        request.setInput(JSONObject.toJSONString(inputVO));
        String outputOSSObject = URLEncoder.encode(ossOutputObject, "utf-8");
        JSONObject output = new JSONObject();
        output.put("OutputObject", outputOSSObject);
        // Ouput->Container
        JSONObject container = new JSONObject();
        container.put("Format", "mp4");
        output.put("Container", container.toJSONString());
        // Ouput->Video
        JSONObject video = new JSONObject();
        video.put("Codec", "H.264");
        video.put("Bitrate", "1500");
        video.put("Width", "1280");
        video.put("Fps", "25");
        output.put("Video", video.toJSONString());
        // Ouput->Audio
        JSONObject audio = new JSONObject();
        audio.put("Codec", "AAC");
        audio.put("Bitrate", "128");
        audio.put("Channels", "2");
        audio.put("Samplerate", "44100");
        output.put("Audio", audio.toJSONString());
        // Ouput->TemplateId
        output.put("TemplateId", templateId);
        JSONArray outputs = new JSONArray();
        outputs.add(output);
        request.setOutputs(outputs.toJSONString());
        request.setOutputBucket(ossBucket);
        request.setOutputLocation(ossLocation);
        // PipelineId
        request.setPipelineId(pipelineId);
        // 发起请求并处理应答或异常
        SubmitJobsResponse response;
        try {
            response = ACS_CLIENT.getAcsResponse(request);
            System.out.println("RequestId is:" + response.getRequestId());
            if (response.getJobResultList().get(0).getSuccess()) {
                System.out.println("JobId is:" + response.getJobResultList().get(0).getJob().getJobId());
            } else {
                System.out.println("SubmitJobs Failed code:" + response.getJobResultList().get(0).getCode() +
                        " message:" + response.getJobResultList().get(0).getMessage());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClientException {
//        test();
        List<SearchPipelineResponse.Pipeline> pipelines = searchPipeline();
//        InputVO inputVO = new InputVO();
//        inputVO.setBucket(AliyunInfo.BUCKET_NAME);
//        inputVO.setLocation(ossLocation);
//        inputVO.setObject(URLEncoder.encode(ossInputObject, "utf-8"));
//        SubmitMediaInfoJobResponse.MediaInfoJob getmediainfo = getmediainfo(inputVO);
        System.out.println(pipelines);
    }

}
