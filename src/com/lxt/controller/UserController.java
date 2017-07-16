package com.lxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxt.common.bean.PageData;
import com.lxt.common.bean.Response;
import com.lxt.common.utils.CheckUtils;
import com.lxt.model.User;
import com.lxt.model.UserExample;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
    private UserService userService;

	@RequestMapping("/queryByPage")
	@ResponseBody
	public Response queryByPage(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

		super.setParams(request);
		
		String name = (String) params.get("name");
		String key = (String) params.get("key");
		String version = (String) params.get("version");
		String startCreateTime = (String) params.get("startCreateTime");
		String endCreateTime = (String) params.get("endCreateTime");
		String state = (String) params.get("state");
		String startPublishTime = (String) params.get("startPublishTime");
		String endPublishTime = (String) params.get("endPublishTime");
		String memo = (String) params.get("memo");
		String page = (String) params.get("page");
		String rows = (String) params.get("rows");
		String sort = (String) params.get("sort");
		String order = (String) params.get("order");
		int limitStart = (Integer.parseInt(page)-1)*Integer.parseInt(rows);
		int limitEnd = limitStart+Integer.parseInt(rows);
		
		UserExample example = new UserExample();
		if(CheckUtils.isNotEmpty(name)){
			example.or().andUsernameEqualTo(name);
		}
//		example.or().andProcessKeyLike(key);
//		example.or().andVersionNoLike(version);
//		example.or().andCreateTimeBetween(FormatUtils.str2Date(startCreateTime), FormatUtils.str2Date(endCreateTime));
//		example.or().andStatusEqualTo(Integer.parseInt(state));
//		example.or().andPublishTimeBetween(FormatUtils.str2Date(startPublishTime), FormatUtils.str2Date(endPublishTime));
//		example.or().andMemoLike(memo);
//		example.setLimitStart(limitStart);
//		example.setLimitEnd(limitEnd);
//		example.setOrderByClause(order+" "+sort);
		
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
