package com.hbsf.util;


import com.hbsf.pojo.Room;

import java.util.List;

public class ResultBean {
	
	public static final int SUCCESS_CODE = 200;
	public static final int FAILD_CODE = 500;
	
	private Integer code;
	private String msg;
	private Object data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public ResultBean(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	
	
	public ResultBean() {
		super();
	}
	
	
	public static ResultBean ok() {
		return new ResultBean(SUCCESS_CODE, "成功", null);
	}
	
	public static ResultBean ok(Object data) {
		return new ResultBean(SUCCESS_CODE, "成功", data);
	}
	
	public static ResultBean fail(String msg) {
		return new ResultBean(FAILD_CODE, msg, null);
	}
	
	public static ResultBean build(Integer code, String msg, Object data, List<Room> rooms) {
		return new ResultBean(code, msg, data);
	}
	
	//...
	
	

}

	