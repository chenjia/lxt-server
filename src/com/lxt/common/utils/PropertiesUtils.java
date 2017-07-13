package com.lxt.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	public static Properties getProperties(String name){
		Properties p = null;
		try {
			InputStream in = PropertiesUtils.class.getResourceAsStream(name);
			p = new Properties();
			p.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}
