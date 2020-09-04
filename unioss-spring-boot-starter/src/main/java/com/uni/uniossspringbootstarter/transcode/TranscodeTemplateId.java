
package com.uni.uniossspringbootstarter.transcode;

public final class TranscodeTemplateId {

	private TranscodeTemplateId() {

	}

	/* 以下为预置智能模板,使用时需先提交分析作业*/
	public static final String I_M3U8_HD = "S00000000-100040";
	public static final String I_M3U8_SD = "S00000000-100030";
	public static final String I_M3U8_LD = "S00000000-100020";

	/* 以下为预置静态模板*/
	public static final String S_M3U8_HD = "S00000001-100030";
	public static final String S_M3U8_SD = "S00000001-100020";
	public static final String S_M3U8_LD = "S00000001-100010";

	/**
	 * 预置转封装模版:M3U8切片(转封装)
	 */
	public static final String M3U8_COPY = "S00000001-100000";
	
	/* 以下为预置静态窄带高清模板*/
	public static final String S_NB_M3U8_4K="S00000002-100070";//width:3840
	public static final String S_NB_M3U8_2K="S00000002-100060";//width:2040
	public static final String S_NB_M3U8_FHD="S00000002-100050";//width:1920
	public static final String S_NB_M3U8_HD="S00000002-100040";//width:1280
	public static final String S_NB_M3U8_SD="S00000002-100030";//width:848
	public static final String S_NB_M3U8_LD="S00000002-100020";//width:640
	
	/**
	 * 根据宽度获取静态窄带高清模板
	 *
	 * @author kira
	 * @param width
	 * @return
	 */
	public static String getSNBM3U8TemplateByWidth(int width) {
		if (width > 3840) {
			return S_NB_M3U8_4K;
		} else if (width > 2040) {
			return S_NB_M3U8_2K;
		} else if (width > 1920) {
			return S_NB_M3U8_FHD;
		} else if (width > 1280) {
			return S_NB_M3U8_HD;
		} else if (width > 848) {
			return S_NB_M3U8_SD;
		} else {
			return S_NB_M3U8_LD;
		}
	}

}
