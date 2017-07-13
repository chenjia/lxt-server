package com.lxt.service;

import java.util.List;

import com.lxt.common.bean.PageData;
import com.lxt.model.User;
import com.lxt.model.UserExample;
import com.lxt.model.UserSetting;

public interface UserService {
	
	public User login(String username, String password) throws ServiceException;
	
	public PageData<User> queryUserByPage(UserExample userExample) throws ServiceException;
	
	public UserSetting getUserSettingByUserId(String userId) throws ServiceException;
	
	public List<User> queryUserByOrgId(String orgId) throws ServiceException;
	
	public void updateUserSetting(UserSetting userSetting) throws ServiceException;
}
