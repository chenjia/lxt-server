package com.lxt.common.utils;

public class CheckUtils {
	
	public static boolean isNotEmpty(Object obj){
		boolean b = false;
		
		if(obj != null){
			String str = obj.toString();
			if(str.trim().length()!=0){
				b = true;
			}
		}
		
		return b;
	}
	
	public static boolean isEmpty(Object obj){
		return !isNotEmpty(obj);
	}
}
