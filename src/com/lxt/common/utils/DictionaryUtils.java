package com.lxt.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lxt.model.Dictionary;

/**
 * 数据字典，用于存放码表信息
 * @author chenjia
 * @version 1.0
 * @date：2014-11-1
 */
public class DictionaryUtils {
	
	/**
	 * 保存码表信息的map
	 * key是码表类型，如SEX
	 * value是此类型的码表map对象
	 */
	private static Map<String, Map<String,Dictionary>> dictionaryMap = new HashMap<String, Map<String,Dictionary>>();
	
	/**
	 * 查询码表值
	 * @param typeDictionary 类型+下划线+代码，如SEX_MALE
	 * @return
	 */
	public static Object getValue(String typeDictionary){
		String[] array = typeDictionary.split("_");
		return dictionaryMap.get(array[0]).get(array[1]).getValue();
	}
	
	/**
	 * 查询码表文本
	 * @param typeDictionary 类型+下划线+代码，如SEX_MALE
	 * @return
	 */
	public static Object getText(String typeDictionary){
		String[] array = typeDictionary.split("_");
		return dictionaryMap.get(array[0]).get(array[1]).getText();
	}
	
	/**
	 * 获得指定类型的码表信息
	 * @param type
	 * @return
	 */
	public static Map<String,Dictionary> getDictionaryMapByType(String type){
		return dictionaryMap.get(type);
	}
	
	/**
	 * 获得指定类型的码表信息
	 * @param type
	 * @return
	 */
	public static List<Dictionary> getDictionaryListByType(String type){
		Map<String,Dictionary> map = dictionaryMap.get(type);
		List<Dictionary> list = new ArrayList<Dictionary>();
		for(Entry<String, Dictionary> entry : map.entrySet()){
			list.add(entry.getValue());
		}
		return list;
	}
	
	/**
	 * 加入指定类型的码表信息
	 * @param type
	 * @param typeStateMap
	 */
	public static void addDictionaryType(String type, Map<String,Dictionary> typeDictionaryMap){
		dictionaryMap.put(type,typeDictionaryMap);
	}
}
