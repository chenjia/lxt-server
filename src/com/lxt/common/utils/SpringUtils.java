package com.lxt.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtils implements ApplicationContextAware{
	private static ApplicationContext ac;
	
	public void setApplicationContext(ApplicationContext ac)
			throws BeansException {
		this.ac = ac; 
	}
	
	public static Object getBean(String beanName){
		return ac.getBean(beanName);
	}
}
