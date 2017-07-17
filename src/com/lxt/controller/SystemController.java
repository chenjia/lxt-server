package com.lxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxt.common.bean.Request;
import com.lxt.common.bean.Response;
import com.lxt.common.bean.SessionUser;
import com.lxt.common.constant.ControllerConstant;
import com.lxt.common.constant.SessionConstant;
import com.lxt.common.plugin.captcha.CaptchaServlet;
import com.lxt.common.utils.CheckUtils;
import com.lxt.common.utils.FormatUtils;
import com.lxt.common.utils.JWTUtils;
import com.lxt.common.utils.SecurityUtils;
import com.lxt.model.User;
import com.lxt.model.UserSetting;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;

@Controller
@Scope("prototype")
@RequestMapping("/system")
public class SystemController extends BaseController{
	
	@Autowired
    private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	public Response login(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Request req = getRequest(request);
		
		String username = req.getString("username");
		String password = req.getString("password");
		String captcha = req.getString("captcha");
		
		if (CheckUtils.isEmpty(captcha)) {
			resp.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
			resp.getBody().setData("验证码不能为空！");
		} else {
			Map<String, String> claimMap = new HashMap<String, String>();
			claimMap.put(CaptchaServlet.CAPTCHA, ""+captcha);
			boolean b = JWTUtils.unsign(req.getHead().getToken(), claimMap);
			System.out.println(b);
			if(b){
				try {
					User user = userService.login(username, SecurityUtils.md5Encrypt(password));
					if(user != null) {
						Map<String, Object> map = new HashMap<String, Object>();
						UserSetting userSetting = userService.getUserSettingByUserId(user.getUserId());
						map.put("msg", "登录成功！");
						map.put("user", user);
						map.put("userSetting", userSetting);
						
						claimMap.clear();
						claimMap.put("userId", user.getUserId());
						String token = JWTUtils.sign(claimMap);
						resp.getHead().setUserId(user.getUserId());
						resp.getHead().setToken(token);
						resp.getBody().setData(map);
					}else {
						resp.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
						resp.getBody().setData("用户名或密码错误！");
					}
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}else{
				resp.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
				resp.getBody().setData("验证码错误！");
			}
		}
//		else if(captcha.equalsIgnoreCase(sessionCaptchaShiro)) {
//			UsernamePasswordToken token = new UsernamePasswordToken(username, SecurityUtils.md5Encrypt(password));
//			
//			try {
//				currentUser.login(token);
//				if (currentUser.isAuthenticated()) {
//					Session session = currentUser.getSession();
//					
//					SessionUser user = (SessionUser) session.getAttribute(SessionConstant.SESSION_USER);
//					Map<String, Object> userMap = FormatUtils.obj2Map(user);
//					userMap.put("token", session.getId());
//					try {
//						UserSetting userSetting = userService.getUserSettingByUserId(user.getUserId());
//						session.setAttribute(SessionConstant.SESSION_USER_SETTING, userSetting);
//						userMap.putAll(FormatUtils.obj2Map(userSetting));
//					} catch (ServiceException e) {
//						e.printStackTrace();
//					}
//					result.getBody().setData(userMap);
//				} else {
//					token.clear();
//				}
//			} catch (UnknownAccountException uae) {
//				result.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
//				result.getBody().setData("用户名或密码错误！");
//			} catch (IncorrectCredentialsException ice) {
//				result.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
//				result.getBody().setData("密码不正确！");
//			} catch (LockedAccountException lae) {
//				result.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
//				result.getBody().setData("账户已锁定！");
//			} catch (ExcessiveAttemptsException eae) {
//				request.setAttribute("message_login", "用户名或密码错误次数过多");
//			} catch (AuthenticationException ae) {
//				ae.printStackTrace();
//				result.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
//				result.getBody().setData("用户名或密码不正确！");
//			}
//		}else{
//			result.getHead().setStatus(SessionConstant.HTTP_STATUS_FAIL);
//			result.getBody().setData("验证码错误！");
//		}
		
		System.out.println(resp.toJson());
		
		return resp;
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public Response logout(HttpServletRequest request, HttpServletResponse response){
//		Subject subject = org.apache.shiro.SecurityUtils.getSubject();
//		subject.getSession().setTimeout(3000);
//		result.getBody().setData("成功退出系统！");
		return resp;
	}
	
	@RequestMapping("/captcha")
	@ResponseBody
	public Response getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		resp.getBody().setData(request.getSession().getAttribute(SessionConstant.CAPTCHA));
		return resp;
	}
	
	@RequestMapping("/session")
	@ResponseBody
	public Response session(HttpServletRequest request, HttpServletResponse response){
//		try {
//			SessionUser user = (SessionUser)getSessionAttribute(SessionConstant.SESSION_USER);
//			if(CheckUtils.isNotEmpty(user)){
//				UserSetting userSetting = (UserSetting) getSessionAttribute(SessionConstant.SESSION_USER_SETTING);
//				Map<String, Object> data = FormatUtils.obj2Map(user);
//				data.put("sysTime", System.currentTimeMillis());
//				data.putAll(FormatUtils.obj2Map(userSetting));
//				result.getBody().setData(data);
//			}else{
//				result.getHead().setStatus(401);
//				result.getBody().setData("无会话信息");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			result.getHead().setStatus(ControllerConstant.STATUS_ERROR);
//			result.getBody().setData(e.getMessage());
//		}
		return resp;
	}
	
}
