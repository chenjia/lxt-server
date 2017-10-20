package com.lxt.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxt.common.bean.Request;
import com.lxt.common.bean.Response;
import com.lxt.common.utils.CheckUtils;
import com.lxt.model.Organization;
import com.lxt.model.User;
import com.lxt.model.vo.ContactVO;
import com.lxt.service.OrganizationService;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;

@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController{
	
	@Autowired
    private OrganizationService organizationService;
	
	@Autowired
    private UserService userService;
	
	@RequestMapping("/getChildren")
	@ResponseBody
	public Response getChildren(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Request req = getRequest(request);
		
		String orgId = req.getString("orgId");
		List<Organization> organizations = null;
		
		if(CheckUtils.isEmpty(orgId)){
			orgId = "0";
		}
		try {
			organizations = organizationService.getSubOrganizationById(orgId);
			resp.getBody().setData(organizations);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
		
		return resp;
	}

	@RequestMapping("/getSubOrganizationById")
	@ResponseBody
	public List<ContactVO> getSubOrganizationById(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		String orgId = request.getParameter("orgId");
		
		List<ContactVO> contactVOs = new ArrayList<ContactVO>();
		List<Organization> organizations = null;
		List<User> users = null;
		
		if(CheckUtils.isEmpty(orgId)){
			orgId = "0";
		}
		try {
			organizations = organizationService.getSubOrganizationById(orgId);
			users = userService.queryUserByOrgId(orgId);
			ContactVO contactVO = null;
			if(organizations != null && organizations.size() != 0){
				for(Organization org : organizations){
					contactVO = new ContactVO();
					BeanUtils.copyProperties(contactVO, org);
					contactVOs.add(contactVO);
				}
			}
			if(users != null && users.size() != 0){
				for(User user : users){
					contactVO = new ContactVO();
					contactVO.setOrgId(user.getUserId());
					contactVO.setOrgName(user.getRealname());
					contactVO.setState("open");
					contactVO.setIconCls("icon-user");
					contactVOs.add(contactVO);
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
		
		return contactVOs;
	}
	
}
