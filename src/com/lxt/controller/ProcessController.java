package com.lxt.controller;

import java.util.Map;

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
import com.lxt.model.Process;
import com.lxt.model.ProcessExample;
import com.lxt.model.ProcessExample.Criteria;
import com.lxt.service.ProcessService;
import com.lxt.service.ServiceException;

@Controller
@RequestMapping("/process")
public class ProcessController extends BaseController {

	@Autowired
	private ProcessService processService;

	@RequestMapping("/list")
	@ResponseBody
	public Response queryByPage(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Request req = getRequest(request);

		int page = req.getInt("page");
		int rows = req.getInt("rows");
		String sort = req.getString("sort");
		String orderBy = req.getString("orderBy");
		
		String name = req.getString("name");
		Integer status = req.getInt("status");

		ProcessExample example = new ProcessExample();
		Criteria criteria = example.createCriteria();
		
		example.setLimitStart((page-1)*rows);
		example.setLimitEnd(rows);
		example.setOrderByClause(orderBy+" "+sort);

		if (CheckUtils.isNotEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}

		if (CheckUtils.isNotEmpty(status)) {
			criteria.andStatusEqualTo(status);
		}

		try {
			PageData<Process> pageData = processService.queryByPage(example);
			resp.getBody().setData(pageData);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}

		return resp;
	}

}
