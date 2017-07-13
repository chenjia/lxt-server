package com.lxt.service;

import java.util.Date;
import java.util.List;

import com.lxt.model.ChatFriend;
import com.lxt.model.vo.ChatFriendCategoryVO;
import com.lxt.model.vo.ChatRecordVO;

public interface ChatService {
	
	public List<ChatRecordVO> queryChatRecords(String sendId, String receiveId, Date beforeDate, Integer count) throws ServiceException;
	
	public void addFriend(ChatFriend friend) throws ServiceException;
	
	public void deleteFriend(String userId, String friendId) throws ServiceException;
	
	public List<ChatFriendCategoryVO> queryFriendList(String userId) throws ServiceException;
	
}
