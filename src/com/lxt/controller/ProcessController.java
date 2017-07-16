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
import com.lxt.service.ProcessService;
import com.lxt.service.ServiceException;

@Controller
@RequestMapping("/process")
public class ProcessController extends BaseController {

	@Autowired
	private ProcessService processService;

	@RequestMapping("/list")
	@ResponseBody
	public Response queryByPage(HttpServletRequest request,
			HttpServletResponse response) throws ControllerException {

		// String name = params.get("name");
		// String key = params.get("key");
		// String version = params.get("version");
		// String startCreateTime = params.get("startCreateTime");
		// String endCreateTime = params.get("endCreateTime");
		// String state = params.get("state");
		// String startPublishTime = params.get("startPublishTime");
		// String endPublishTime = params.get("endPublishTime");
		// String memo = params.get("memo");
		// String page = params.get("page");
		// String rows = params.get("rows");
		// String sort = params.get("sort");
		// String order = params.get("order");

		Request req = getRequest(request);

		int currentPage = (int) params.get("currentPage");
		int pageSize = (int) params.get("pageSize");
		String sortColumn = (String) params.get("sortColumn");
		String sortType = (String) params.get("sortType");
		String processName = (String) params.get("processName");
		Integer status = (Integer) params.get("status");

		int limitEnd = pageSize;
		int limitStart = (currentPage - 1) * limitEnd;

		ProcessExample example = new ProcessExample();
		example.setLimitStart(limitStart);
		example.setLimitEnd(limitEnd);
		example.setOrderByClause(sortColumn + " " + sortType);

		if (CheckUtils.isNotEmpty(processName)) {
			example.or().andNameLike("%" + processName + "%");
		}

		if (CheckUtils.isNotEmpty(status)) {
			example.or().andStatusEqualTo(status);
		}

		// example.or().andProcessKeyLike(key);
		// example.or().andVersionNoLike(version);
		// example.or().andCreateTimeBetween(FormatUtils.str2Date(startCreateTime),
		// FormatUtils.str2Date(endCreateTime));
		// example.or().andStatusEqualTo(Integer.parseInt(state));
		// example.or().andPublishTimeBetween(FormatUtils.str2Date(startPublishTime),
		// FormatUtils.str2Date(endPublishTime));
		// example.or().andMemoLike(memo);

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
