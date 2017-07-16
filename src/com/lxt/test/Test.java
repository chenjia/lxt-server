package com.lxt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lxt.dao.mapper.UserMapper;
import com.lxt.model.User;
import com.lxt.model.UserExample;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext-mvc.xml");
		context.start();
		
		UserMapper userMapper = (UserMapper) context.getBean("userMapper");
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameLike("%in%");
		List<User> userList = userMapper.selectByExample(userExample);
		System.out.println(userList.size());
	}
}
