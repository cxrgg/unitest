package com.uni.uniossspringbootstarter.transcode;

/**
 * 
 *
 * Date: 2018年9月4日 下午3:43:41 <br>
 * 
 * @author kira
 * @version
 * @since JDK 1.7
 * @see
 */
public enum TranscondeJobStatus {
	NotExist("无作业记录"), All("全部"), Submitted("作业已提交"), Transcoding("转码中"), TranscodeSuccess("转码成功"), TranscodeFail(
			"转码失败"), TranscodeCancelled("转码取消");

	private String describe;

	private TranscondeJobStatus(String describe) {
		this.describe = describe;
	}

	public String getDescribe() {
		return describe;
	}

	public static TranscondeJobStatus getEnumByString(String str) {
		TranscondeJobStatus status = null;
		if (str != null && !"".equals(str)) {
			try {
				status = TranscondeJobStatus.valueOf(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
}
