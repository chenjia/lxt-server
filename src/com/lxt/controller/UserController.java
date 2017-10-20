package com.lxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxt.common.bean.PageData;
import com.lxt.common.bean.Request;
import com.lxt.common.bean.Response;
import com.lxt.common.utils.CheckUtils;
import com.lxt.model.User;
import com.lxt.model.UserExample;
import com.lxt.model.UserExample.Criteria;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
    private UserService userService;

	@RequestMapping("/list")
	@ResponseBody
	public Response queryByPage(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Request req = getRequest(request);
		
		int page = req.getInt("page");
		int rows = req.getInt("rows");
		String sort = req.getString("sort");
		String orderBy = req.getString("orderBy");
		
		String orgId = req.getString("orgId");
		String username = req.getString("username");
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		
		example.setLimitStart((page-1)*rows);
		example.setLimitEnd(rows);
		example.setOrderByClause(orderBy+" "+sort);
		
		if(CheckUtils.isNotEmpty(orgId)){
			criteria.andOrgIdEqualTo(orgId);
		}
		if(CheckUtils.isNotEmpty(username)){
			criteria.andUsernameLike(username);
		}
		
		try {
			PageData<User> pageData = userService.queryUserByPage(example);
			resp.getBody().setData(pageData);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
		
		return resp;
	}
}
