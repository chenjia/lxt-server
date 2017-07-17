package com.lxt.common.bean;

import java.io.Serializable;

import com.lxt.common.utils.FormatUtils;

public class Body implements Serializable{
	private Object data = null;

	@Override
	public String toString() {
		return FormatUtils.obj2Json(data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
