package com.lxt.common.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

public class FormatUtils {

	public static final String SHORT_DATE = "yyyy-MM-dd";

	public static final String LONG_DATE = "yyyy-MM-dd HH:mm:ss";

	private static SimpleDateFormat dateFormat = new SimpleDateFormat();

	private static final XStream xstream = new XStream();

	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 日期对象转化成字符串
	 * @param date 日期对象
	 * @param pattern 日期字符串格式
	 * @return
	 */
	public static String date2Str(Date date, String pattern) {
		String dateStr = "";
		if(CheckUtils.isEmpty(pattern)){
			pattern = SHORT_DATE;
		}
		dateFormat.applyPattern(pattern);
		dateStr = dateFormat.format(date);
		return dateStr;
	}
	
	/**
	 * 日期对象转化成字符串
	 * @param date 日期对象
	 * @param pattern 日期字符串格式
	 * @return
	 */
	public static String date2Str(Date date) {
		String dateStr = null;
		dateFormat.applyPattern(SHORT_DATE);
		dateStr = dateFormat.format(date);
		return dateStr;
	}

	/**
	 * 字符串转化成日期对象
	 * @param dateStr 日期字符串
	 * @param pattern 日期格式
	 * @return
	 */
	public static Date str2Date(String dateStr, String pattern) {
		Date date = null;
		if(CheckUtils.isEmpty(pattern)){
			pattern = SHORT_DATE;
		}
		dateFormat.applyPattern(pattern);
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 字符串转化成日期对象
	 * @param dateStr 日期字符串
	 * @param pattern 日期格式
	 * @return
	 */
	public static Date str2Date(String dateStr) {
		Date date = null;
		dateFormat.applyPattern(SHORT_DATE);
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 对象转化成xml字符串
	 * @param obj
	 * @return
	 */
	public static String obj2Xml(Object obj) {
		String xml = "";
		xml = xstream.toXML(obj);
		return xml;
	}

	/**
	 * xml字符串转化成对象
	 * @param str
	 * @return
	 */
	public Object xml2Obj(String str) {
		Object obj = null;
		obj = xstream.fromXML(str);
		return obj;
	}

	public static String obj2Json(Object obj) {
		String jsonStr = "";
		try {
			jsonStr = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	public static <T> T json2Obj(String jsonStr, Class<T> clazz){
		T t = null;
		try {
			t = objectMapper.readValue(jsonStr.toString(), clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	public static Map<String,Object> json2Map(String json){
		Map<String, Object> map = null;
		 
		try {
			map = objectMapper.readValue(json, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return map;
	}
	
	public static List json2List(String json){
		List list = null;
		
		try {
			list = objectMapper.readValue(json, List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 对象转化成map
	 * @param obj
	 * @return
	 */
	public static Map<String,Object> obj2Map(Object obj){
		Map<String, Object> map = null;
		 
		try {
			map = BeanUtils.describe(obj);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		 
		return map;
	}
	
}
