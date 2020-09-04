/**
 * Project Name:uni-common
 * File Name:InputVO.java
 * Package Name:com.jyjy.common.uni.utils.oss.transcode
 * Date:2017年4月8日下午2:58:08
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.uni.oss;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 
 * ClassName: OutputsVO <br/>
 * date: 2017年4月10日 下午5:00:24 <br/>
 *
 * @author kira
 * @version
 * @since JDK 1.6
 */
public class OutputVO {

	@JSONField(name = "OutputObject")
	private String outputObject;

	@JSONField(name = "TemplateId")
	private String templateId;

	@JSONField(name = "WaterMarks")
	private List<WaterMarkVO> waterMarks;

	@JSONField(name = "UserData")
	private String userData;

	public String getOutputObject() {
		return outputObject;
	}

	public void setOutputObject(String outputObject) {
		this.outputObject = outputObject;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public List<WaterMarkVO> getWaterMarks() {
		return waterMarks;
	}

	public void setWaterMarks(List<WaterMarkVO> waterMarks) {
		this.waterMarks = waterMarks;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

}
