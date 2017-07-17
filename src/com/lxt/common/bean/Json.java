package com.lxt.common.bean;

import java.io.Serializable;

import com.lxt.common.utils.FormatUtils;

public class Json implements Serializable{
	public String toJson(){
		return FormatUtils.obj2Json(this);
	}
}
