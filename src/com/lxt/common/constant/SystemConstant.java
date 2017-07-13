package com.lxt.common.constant;

import com.lxt.common.utils.PropertiesUtils;


public class SystemConstant {
	public static String DEBUG = PropertiesUtils.getProperties("/config.properties").getProperty("debug");

	public static void setDebug(String isDebug){
		DEBUG = isDebug;
	}
}