package com.hbsf.util;

import javax.xml.crypto.Data;

public class TableResultBean extends ResultBean {
	public static final int DATA_SUCCESS_CODE = 0;
	private Long count;

	public Long getCount() {
		return count;
	}
	int a = 5;
	Integer aa = 5;
	String string = "1121212";


	public void setCount(Long count) {
		this.count = count;
	}

	public TableResultBean(Integer code,String msg,Long count,Object data) {
		super(code, msg, data);
		this.count = count;
	}
}
