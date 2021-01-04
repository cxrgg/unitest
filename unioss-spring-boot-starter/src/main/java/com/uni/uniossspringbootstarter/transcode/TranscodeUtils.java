//package com.uni.uniossspringbootstarter.transcode;
//
//import com.alibaba.fastjson.JSONObject;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.mts.model.v20140618.*;
//import com.lineteam.oss.AliyunConfig;
//import org.apache.commons.lang.StringUtils;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class TranscodeUtils {
//
//	public static final String DEFAULT_PIPELINEID = "**************";
//
//	public static final String M3U8_AUTOADD_EX = ".m3u8";
//
//	/**
//	 * 搜索管道
//	 *
//	 * @author kira
//	 * @return
//	 * @throws ServerException
//	 * @throws ClientException
//	 */
//	public static List<SearchPipelineResponse.Pipeline> searchPipeline() throws ServerException, ClientException {
//		// 创建API请求并设置参数
//		SearchPipelineRequest request = new SearchPipelineRequest();
//		// 发起请求并处理应答或异常
//		SearchPipelineResponse response = AliyunConfig.ACSCLIENT.getAcsResponse(request);
//		return response.getPipelineList();
//	}
//
//	/**
//	 * 获取媒体信息
//	 *
//	 * @author kira
//	 * @param input
//	 * @return
//	 * @throws ServerException
//	 * @throws ClientException
//	 */
//	public static SubmitMediaInfoJobResponse.MediaInfoJob getmediainfo(InputVO input)
//			throws ServerException, ClientException {
//		SubmitMediaInfoJobRequest request = new SubmitMediaInfoJobRequest();
//		request.setInput(JSONObject.toJSONString(input));
//
//		SubmitMediaInfoJobResponse response = AliyunConfig.ACSCLIENT.getAcsResponse(request);
//
//		return response.getMediaInfoJob();
//	}
//
//	public static SubmitMediaInfoJobResponse.MediaInfoJob getmediainfo(String location, String bucket, String object) throws ServerException, ClientException {
//		InputVO input = new InputVO();
//		input.setBucket(bucket);
//		input.setLocation(location);
//		input.setObject(object);
//		return getmediainfo(input);
//	}
//
//	/**
//	 * 提交转码作业
//	 *
//	 * @author kira
//	 * @param pipelineid
//	 * @param input
//	 * @param outputLocation
//	 * @param outputBucket
//	 * @param outputs
//	 * @return
//	 * @throws ServerException
//	 * @throws ClientException
//	 */
//	public static List<SubmitJobsResponse.JobResult> submitjobs(String pipelineid, InputVO input, String outputLocation,
//			String outputBucket, List<OutputVO> outputs) throws ServerException, ClientException {
//		SubmitJobsRequest request = new SubmitJobsRequest();
//		request.setPipelineId(DEFAULT_PIPELINEID);
//		request.setInput(JSONObject.toJSONString(input));
//		request.setOutputBucket(outputBucket);
//		request.setOutputLocation(outputLocation);
//		request.setOutputs(JSONObject.toJSONString(outputs));
//
//		SubmitJobsResponse response = AliyunConfig.ACSCLIENT.getAcsResponse(request);
//		return response.getJobResultList();
//	}
//
//	/**
//	 * 提交转码作业，仅m3u8切片，输出至当前bucket
//	 *
//	 * @author kira
//	 * @param input
//	 * @return
//	 * @throws ServerException
//	 * @throws ClientException
//	 */
//	public static SubmitJobsResponse.JobResult submitm3u8copyJob(InputVO input,String outputbucket,OutputVO output)
//			throws ServerException, ClientException {
//
//		List<SubmitJobsResponse.JobResult> result = submitjobs(DEFAULT_PIPELINEID, input,
//				input.getLocation(), outputbucket, Arrays.asList(output));
//
//		return result != null && result.size() > 0 ? result.get(0) : null;
//	}
//
//	public static SubmitJobsResponse.JobResult submitm3u8copyJob(String location, String bucket, String object)
//			throws ServerException, ClientException {
//		InputVO input = new InputVO();
//		input.setBucket(bucket);
//		input.setLocation(location);
//		input.setObject(object);
//
//		String outputObject = input.getObject();
//		if (StringUtils.substringAfterLast(outputObject, ".").length() > 6) {
//			outputObject = outputObject + "/m3u8_copy";
//		} else {
//			outputObject = StringUtils.substringBeforeLast(outputObject, ".") + "/m3u8_copy";
//		}
//
//		OutputVO output = new OutputVO();
//		output.setTemplateId(TranscodeTemplateId.M3U8_COPY);
//		output.setOutputObject(outputObject);
//
//		return submitm3u8copyJob(input, input.getBucket(), output);
//	}
//
//	/**
//	 * 查询转码作业
//	 *
//	 * @author kira
//	 * @param jobid
//	 * @return
//	 * @throws ServerException
//	 * @throws ClientException
//	 */
//	public static QueryJobListResponse.Job queryJob(String jobid) throws ServerException, ClientException {
//		QueryJobListRequest request = new QueryJobListRequest();
//		request.setJobIds(jobid);
//
//		QueryJobListResponse response = AliyunConfig.ACSCLIENT.getAcsResponse(request);
//		if (response.getJobList() != null && response.getJobList().size() > 0) {
//			return response.getJobList().get(0);
//		} else {
//			return null;
//		}
//	}
//
//	/**
//	 * 批量查询转码作业，一次最多10个jobid
//	 *
//	 * @author kira
//	 * @param jobidlist
//	 *            最多10个
//	 * @return
//	 * @throws Exception
//	 */
//	public static List<QueryJobListResponse.Job> queryJobList(List<String> jobidlist) throws Exception {
//
//		if (jobidlist == null || jobidlist.size() == 0 || jobidlist.size() > 10) {
//			throw new Exception("jobidlist.size 需在1~10");
//		}
//
//		QueryJobListRequest request = new QueryJobListRequest();
//		request.setJobIds(StringUtils.join(jobidlist, ","));
//
//		QueryJobListResponse response = AliyunConfig.ACSCLIENT.getAcsResponse(request);
//		return response.getJobList();
//	}
//
//}
