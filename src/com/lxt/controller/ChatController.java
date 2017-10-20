package com.lxt.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxt.common.bean.Request;
import com.lxt.common.bean.Response;
import com.lxt.common.utils.CheckUtils;
import com.lxt.common.utils.UUIDUtils;
import com.lxt.model.ChatFriendCategory;
import com.lxt.model.vo.ChatFriendCategoryVO;
import com.lxt.model.vo.ChatRecordVO;
import com.lxt.service.ChatService;
import com.lxt.service.ServiceException;

@Controller
@RequestMapping("/chat")
public class ChatController extends BaseController{
	
	@Autowired
    private ChatService chatService;
	
	
	@RequestMapping("/addChatFriendCategory")
	@ResponseBody
	public Response addChatFriendCategory(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Response result = new Response();
		
		String name = request.getParameter("name");
		String userId = getUser(request).getUserId();
		String sortSeq = request.getParameter("sortSeq");
		if(CheckUtils.isEmpty(sortSeq)){
			sortSeq = "999";
		}
		Date date = new Date();
		
		ChatFriendCategory category = new ChatFriendCategory();
		category.setFriendCategoryId(UUIDUtils.UUID());
		category.setInsertTime(date);
		category.setName(name);
		category.setSortSeq(Integer.parseInt(sortSeq));
		category.setUpdateTime(date);
		category.setUserId(userId);
		
		try {
			List list = chatService.queryFriendList(userId);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
		
		return result;
	}

	@RequestMapping("/friend")
	@ResponseBody
	public Response queryFriendList(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Request req = BaseController.getRequest(request);
		String userId = req.getHead().getUserId();
		
		List<ChatFriendCategoryVO> list = null;
		
		try {
			list = chatService.queryFriendList(userId);
			resp.getBody().setData(list);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
		
		return resp;
	}
	
	@RequestMapping("/record")
	@ResponseBody
	public Response queryChatRecord(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
		Request req = getRequest(request);
		
		String sendId = req.getString("sendId");
		String receiveId = req.getString("receiveId");
		long beforeDateTime = req.getLong("beforeDate");
		int count = req.getInt("count");
		
		Date beforeDate = null;
		
		if(CheckUtils.isNotEmpty(beforeDateTime)){
			beforeDate = new Date(beforeDateTime);
		}
		
		List<ChatRecordVO> chatRecords = null;
		try {
			chatRecords = chatService.queryChatRecords(sendId, receiveId, beforeDate, count);
			resp.getBody().setData(chatRecords);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException(e);
		}
		
		return resp;
	}
	
}
