package com.lxt.common.bean;

import java.io.Serializable;

import com.lxt.common.utils.FormatUtils;

public class Json implements Serializable{

	private static final long serialVersionUID = -1174355411400737255L;

	public String toJson(){
		return FormatUtils.obj2Json(this);
	}
}
