package com.lxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxt.common.bean.PageData;
import com.lxt.dao.mapper.UserMapper;
import com.lxt.dao.mapper.UserSettingMapper;
import com.lxt.model.User;
import com.lxt.model.UserExample;
import com.lxt.model.UserExample.Criteria;
import com.lxt.model.UserSetting;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserSettingMapper userSettingMapper;
	
	@Override
	public User login(String username, String password) throws ServiceException {
		User user = null;
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(example);
		if(userList.size() == 1){
			user = userList.get(0);
		}
		return user;
	}
	
	@Override
	public PageData<User> queryUserByPage(UserExample example)
			throws ServiceException {

		PageData<User> pageData = new PageData<User>();
		
		List<User> rows = userMapper.selectByExample(example);
		Long total = userMapper.countByExample(example);
		pageData.setRows(rows);
		pageData.setTotal(total.intValue());
		
		return pageData;
	}
	
	@Override
	public UserSetting getUserSettingByUserId(String userId)
			throws ServiceException {
		return userSettingMapper.selectByPrimaryKey(userId);
	}
	
	@Override
	public List<User> queryUserByOrgId(String orgId) throws ServiceException {
		List<User> users = null;
		
		UserExample example = new UserExample();
		example.or().andOrgIdEqualTo(orgId);
		users = userMapper.selectByExample(example);
		
		return users;
	}
	
	@Override
	public void updateUserSetting(UserSetting userSetting) throws ServiceException {
		userSettingMapper.updateByPrimaryKey(userSetting);
	}
}
