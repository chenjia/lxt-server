package com.lxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxt.common.bean.Response;
import com.lxt.common.bean.SessionUser;
import com.lxt.common.constant.ControllerConstant;
import com.lxt.common.utils.FormatUtils;
import com.lxt.model.UserSetting;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;

@Controller
@RequestMapping("/desktop")
public class DesktopController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/saveDesktopMenu")
	@ResponseBody
	public Response saveDesktopMenu(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		String menus = request.getParameter("menus");
		
		SessionUser user = getUser(request);
		String menuConfig = user.getMenuConfig();
		
		Map<String, Object> menuConfigMap = (menuConfig==null||"".equals(menuConfig))?new HashMap<String, Object>():FormatUtils.json2Map(menuConfig);
		Map<String, Object> menuMap = FormatUtils.json2Map(menus);
		menuConfigMap.put("desktopMenus", menuMap.get("desktopMenus"));
		menuConfigMap.put("taskMenus", menuMap.get("taskMenus"));
		menuConfig = FormatUtils.obj2Json(menuConfigMap);
		
		try {
			UserSetting userSetting = userService.getUserSettingByUserId(user.getUserId());
			userSetting.setMenuConfig(menuConfig);
			userService.updateUserSetting(userSetting);
			user.setMenuConfig(menuConfig);
			setUser(user, request);
		} catch (ServiceException e) {
			e.printStackTrace();
			resp.getHead().setStatus(ControllerConstant.STATUS_ERROR);
			resp.getBody().setData("保存桌面失败！");
		}
		
		return resp;
	}
}
