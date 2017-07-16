package com.lxt.common.bean;

import com.lxt.common.utils.FormatUtils;

public class Body {
	private Object data = new Object();

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
