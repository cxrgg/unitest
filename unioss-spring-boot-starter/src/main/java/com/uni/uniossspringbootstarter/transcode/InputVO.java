/**
 * Project Name:uni-common
 * File Name:InputVO.java
 * Package Name:com.jyjy.common.uni.utils.oss.transcode
 * Date:2017年4月8日下午2:58:08
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.uni.uniossspringbootstarter.transcode;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * ClassName:InputVO <br/>
 * Date: 2017年4月8日 下午2:58:08 <br/>
 * 
 * @author kira
 * @version
 * @since JDK 1.6
 * @see
 */
public class InputVO {

	@JSONField(name = "Bucket")
	private String bucket;

	@JSONField(name = "Location")
	private String location;

	@JSONField(name = "Object")
	private String object;

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

}
