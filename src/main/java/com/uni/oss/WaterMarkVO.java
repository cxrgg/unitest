
package com.uni.oss;

import com.alibaba.fastjson.annotation.JSONField;

public class WaterMarkVO {

	@JSONField(name = "InputFile")
	private InputVO inputFile;

	@JSONField(name = "WaterMarkTemplateId")
	private String waterMarkTemplateId;

	public InputVO getInputFile() {
		return inputFile;
	}

	public void setInputFile(InputVO inputFile) {
		this.inputFile = inputFile;
	}

	public String getWaterMarkTemplateId() {
		return waterMarkTemplateId;
	}

	public void setWaterMarkTemplateId(String waterMarkTemplateId) {
		this.waterMarkTemplateId = waterMarkTemplateId;
	}

}
