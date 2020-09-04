import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetTranscodeSummaryResponse;
import com.aliyuncs.vod.model.v20170321.GetTranscodeTemplateGroupResponse;
import com.uni.oss.AliyunVODTemplate;
import org.junit.Test;

/**
 * @author 岑祥荣
 * @date 2020/9/3
 */

public class VOD {

//    @Test
//    public void getTranscodeSummary() throws Exception {
//        AliyunVODTemplate aliyunVODTemplate = new AliyunVODTemplate(AliyunVODTemplate.getOssClient());
//        GetTranscodeSummaryResponse transcodeSummary = aliyunVODTemplate.getTranscodeSummary(aliyunVODTemplate.client, "3f298d2f02b444f793d4f46943d60142,284c00bd34644b909069f7b7963d737b");
//        for (GetTranscodeSummaryResponse.TranscodeSummary summary : transcodeSummary.getTranscodeSummaryList()) {
//            //转码状态
//            System.out.println("TranscodeStatus = " + summary.getTranscodeStatus());
//            for (GetTranscodeSummaryResponse.TranscodeSummary.TranscodeJobInfoSummary jobInfoSummary : summary.getTranscodeJobInfoSummaryList()) {
//                //转码进度
//                System.out.println("TranscodeProgress = " + jobInfoSummary.getTranscodeProgress());
//                //转码作业状态
//                System.out.println("TranscodeJobStatus = " + jobInfoSummary.getTranscodeJobStatus());
//                //转码作业完成时间
//                System.out.println("CompleteTime = " + jobInfoSummary.getCompleteTime());
//            }
//        }
//    }
//
//    @Test
//    public void getTranscodeTemplateGroup() throws Exception {
//        AliyunVODTemplate aliyunVODTemplate = new AliyunVODTemplate(AliyunVODTemplate.getOssClient());
//
//        GetTranscodeTemplateGroupResponse response = new GetTranscodeTemplateGroupResponse();
//        try {
//            response = aliyunVODTemplate.getTranscodeTemplateGroup(aliyunVODTemplate.client);
//            if (response.getTranscodeTemplateGroup().getTranscodeTemplateList().size() > 0) {
//                //转码模板组ID
//                System.out.println("TranscodeTemplateGroupId = " + response.getTranscodeTemplateGroup().getTranscodeTemplateGroupId());
//                //转码模板组名称
//                System.out.println("Name = " + response.getTranscodeTemplateGroup().getName());
//                //是否是默认转码模板组
//                System.out.println("Name = " + response.getTranscodeTemplateGroup().getIsDefault());
//                //转码模板视频转码配置
//                System.out.println("Video = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getVideo());
//                //转码模板音频转码配置
//                System.out.println("Audio = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getAudio());
//                //转码模板清晰度标记
//                System.out.println("Definition = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getDefinition());
//                //转码需要压制的水印对应ID
//                System.out.println("WatermarkIds = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getWatermarkIds());
//                //转码模板封装格式配置
//                System.out.println("Container = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getContainer());
//                //转码模板ID
//                System.out.println("TranscodeTemplateId = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getTranscodeTemplateId());
//                //转码模板名称
//                System.out.println("TemplateName = " + response.getTranscodeTemplateGroup().getTranscodeTemplateList().get(0).getTemplateName());
//            }
//        } catch (Exception e) {
//            System.out.println("ErrorMessage = " + e.getLocalizedMessage());
//        }
//        System.out.println("RequestId = " + response.getRequestId());
//    }

}
