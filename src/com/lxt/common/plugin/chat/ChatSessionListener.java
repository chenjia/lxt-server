package com.lxt.common.plugin.chat;

import javax.servlet.http.HttpSession;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;

import com.lxt.common.bean.SessionUser;
import com.lxt.common.constant.SessionConstant;

public class ChatSessionListener implements ScriptSessionListener {
	@Override
	public void sessionCreated(ScriptSessionEvent event) {
		ScriptSession scriptSession = event.getSession();
		HttpSession httpSession = WebContextFactory.get().getSession();
		
		SessionUser user = (SessionUser) httpSession.getAttribute(SessionConstant.SESSION_USER);
		String userId = user.getUserId();
		System.out.println("【聊天用户】"+userId+" "+scriptSession.getId());
		if (userId == null) {
			scriptSession.invalidate();
			httpSession.invalidate();
		}
		scriptSession.setAttribute("userId", userId);
	}
	
	@Override
	public void sessionDestroyed(ScriptSessionEvent event) {
		ScriptSession session = event.getSession();
		System.out.println("【销毁聊天用户】"+session.getAttribute("userId")+" "+session.getId());
	}
}
