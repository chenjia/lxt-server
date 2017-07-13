package com.lxt.common.bean;

import com.lxt.common.utils.FormatUtils;

public class Json {
	public String toJson(){
		return FormatUtils.obj2Json(this);
	}
}
