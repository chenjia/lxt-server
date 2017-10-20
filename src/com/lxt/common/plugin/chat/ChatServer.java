package com.lxt.common.plugin.chat;

import java.util.Collection;
import java.util.Date;

import org.directwebremoting.Browser;
import org.directwebremoting.Container;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.ScriptSessions;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.extend.ScriptSessionManager;

import com.lxt.common.constant.MessageConstant;
import com.lxt.common.utils.FormatUtils;
import com.lxt.common.utils.SpringUtils;
import com.lxt.common.utils.UUIDUtils;
import com.lxt.dao.mapper.ChatRecordMapper;
import com.lxt.model.vo.ChatRecordVO;

public class ChatServer {
	private static ScriptSessionManager manager = null;
	
	public ChatServer(){
		if(manager==null){
			initChatServer();
		}
	}
	
	private static void initChatServer(){
		Container container = ServerContextFactory.get().getContainer();
		ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
		manager.addScriptSessionListener(new ChatSessionListener());
	}
	
	public static void binding(String userId) {
		ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute("userId", userId);
	}
	
	public static void sendMessage(String messageJson) {
		
		ChatRecordVO record = FormatUtils.json2Obj(messageJson, ChatRecordVO.class);
		record.setRecordId(UUIDUtils.UUID());
		record.setInsertTime(new Date());
		record.setMsgType(MessageConstant.MESSAGE_TYPE_TEXT);
		ChatRecordMapper chatRecordMapper = (ChatRecordMapper) SpringUtils.getBean("chatRecordMapper");
		chatRecordMapper.insert(record);
		final String json = FormatUtils.obj2Json(record);
		
		ScriptSessionFilter filter = new ChatSessionFilter(record);
		Browser.withCurrentPageFiltered(filter,
			new Runnable() {
				public void run() {
					Collection<ScriptSession> sessions = Browser.getTargetSessions();
					System.out.println("【聊天会话数】" + sessions.size());
					System.out.println(json);
					
					ScriptSessions.addFunctionCall("receiveMessage", json);
				}
			}
		);
	}
	
	public static void main(String[] args) {
		ChatRecordVO vo = new ChatRecordVO();
		vo.setContent("testtesttest");
		vo.setInsertTime(new Date());
		vo.setInsertTimeMillis(System.currentTimeMillis());
		vo.setMsgType(0);
		vo.setReceiveId("admin");
		
		System.out.println(FormatUtils.obj2Json(vo));
		
	}
}
