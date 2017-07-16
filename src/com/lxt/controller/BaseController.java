package com.lxt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxt.common.bean.Request;
import com.lxt.common.bean.Response;
import com.lxt.common.bean.SessionUser;
import com.lxt.common.constant.SessionConstant;
import com.lxt.common.constant.SystemConstant;
import com.lxt.common.utils.FormatUtils;
import com.lxt.common.utils.SecurityUtils;

public class BaseController {
	protected Map<String, Object> params = new HashMap<String, Object>();
	protected Response resp = new Response();
	
	public String getString(HttpServletRequest request){
		String opt = request.getParameter("opt");
		if("false".equals(SystemConstant.DEBUG)){
			try {
				opt = SecurityUtils.desDecrypt(opt,SecurityUtils.key);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return opt;
	}
	
	public Request getRequest(HttpServletRequest request){
		Request req = new Request();
		
		String opt = request.getParameter("request");
		if("false".equals(SystemConstant.DEBUG)){
			try {
				opt = SecurityUtils.desDecrypt(opt,SecurityUtils.key);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("【请求参数】"+opt);
		req = FormatUtils.json2Obj(opt, Request.class);
		
		return req;
	}
	
	public List getList(HttpServletRequest request){
		List list = null;
		
		String opt = request.getParameter("opt");
		if("false".equals(SystemConstant.DEBUG)){
			try {
				opt = SecurityUtils.desDecrypt(opt,SecurityUtils.key);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		list = FormatUtils.json2List(opt);
		
		return list;
	}
	
	public SessionUser getUser(HttpServletRequest request) {
		return (SessionUser) request.getSession().getAttribute(
				SessionConstant.SESSION_USER);
	}

	public void setUser(SessionUser user, HttpServletRequest request) {
		request.getSession().setAttribute(SessionConstant.SESSION_USER, user);
	}

	public void setSessionAttribute(String key, Object value,
			HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 返回json格式的字符串
	 * 
	 * @param obj
	 * @param response
	 */
	public void write2json(Object obj, HttpServletResponse response) {
		String jsonStr = FormatUtils.obj2Json(obj);
		write(jsonStr, response);
	}

	/**
	 * 返回字符串 使用springresponseBody后不再使用此方法
	 * 
	 * @param obj
	 * @param response
	 */
	public void write(Object obj, HttpServletResponse response) {
		String str = null;
		if (obj != null) {
			str = obj.toString();
		}
		PrintWriter out = null;
		try {
			response.setContentType("application/json;charset=UTF-8");
			System.out.println("【响应】" + str);
			out = response.getWriter();
			out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * 返回key为opt的json字符串
	 * 
	 * @param obj
	 * @param response
	 * @throws Exception 
	 */
	public void writeOpt(Object obj, HttpServletResponse response) throws ControllerException {
		write(resp, response);
	}
	
	/**
	 * 将请求中的参数封装到map中
	 * 
	 * @param request
	 */
	public void setParams(HttpServletRequest request) {
		Map<String, String[]> paramMap = request.getParameterMap();
		for (Entry<String, String[]> entry : paramMap.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (values.length == 1) {
				params.put(key, values[0]);
			} else {
				String value = values.toString();
				params.put(key, value);
			}
		}
	}
}
