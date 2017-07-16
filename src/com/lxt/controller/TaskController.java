package com.lxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lxt.common.bean.Response;
import com.lxt.common.bean.SessionUser;
import com.lxt.common.constant.ControllerConstant;
import com.lxt.common.constant.SessionConstant;
import com.lxt.common.utils.CheckUtils;
import com.lxt.model.User;
import com.lxt.service.ServiceException;
import com.lxt.service.UserService;



@Controller
@RequestMapping("/task")
public class TaskController extends BaseController{
	
	@Autowired
    private UserService userService;

}
