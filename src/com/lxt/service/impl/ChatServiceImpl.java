package com.lxt.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxt.dao.mapper.ChatFriendCategoryMapper;
import com.lxt.dao.mapper.ChatFriendMapper;
import com.lxt.dao.mapper.ChatGroupMapper;
import com.lxt.dao.mapper.ChatRecordMapper;
import com.lxt.dao.ext.ChatExtMapper;
import com.lxt.model.ChatFriend;
import com.lxt.model.ChatFriendCategory;
import com.lxt.model.ChatFriendCategoryExample;
import com.lxt.model.ChatFriendExample;
import com.lxt.service.ChatService;
import com.lxt.service.ServiceException;
import com.lxt.model.vo.ChatFriendCategoryVO;
import com.lxt.model.vo.ChatFriendVO;
import com.lxt.model.vo.ChatRecordVO;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatExtMapper chatMapperExt;
	
	@Autowired
	private ChatRecordMapper chatRecordMapper;
	
	@Autowired
	private ChatFriendMapper chatFriendMapper;
	
	@Autowired
	private ChatFriendCategoryMapper chatFriendCategoryMapper;
	
	@Autowired
	private ChatGroupMapper chatGroupMapper;
	
	@Override
	public List<ChatRecordVO> queryChatRecords(String sendId, String receiveId, Date beforeDate, Integer count) throws ServiceException {
		
		List<ChatRecordVO> chatRecords = null;
		
		if(beforeDate == null){
			beforeDate = new Date();
		}
		
		if(count == null){
			count = 100;
		}
		
		chatRecords = chatMapperExt.queryChatRecords(sendId, receiveId, beforeDate, count);
		
		return chatRecords;
	}
	
	@Override
	public void addFriend(ChatFriend friend) throws ServiceException {
		chatFriendMapper.insert(friend);
	}
	
	@Override
	public void deleteFriend(String userId, String friendId)
			throws ServiceException {
		ChatFriendExample example = new ChatFriendExample();
		example.or().andUserIdEqualTo(userId).andFriendIdEqualTo(friendId);
		example.or().andUserIdEqualTo(friendId).andFriendIdEqualTo(userId);
		chatFriendMapper.deleteByExample(example);
	}
	
	@Override
	public List<ChatFriendCategoryVO> queryFriendList(String userId)
			throws ServiceException {
		List<ChatFriendCategoryVO> list = null;
		
		ChatFriendCategoryExample friendCategoryExample = new ChatFriendCategoryExample();
		ChatFriendExample friendExample = new ChatFriendExample();
		friendCategoryExample.or().andUserIdEqualTo(userId);
		friendCategoryExample.setOrderByClause("SORT_SEQ");
		friendExample.or().andUserIdEqualTo(userId);
		friendExample.setOrderByClause("SORT_SEQ");
		List<ChatFriendCategory> categories = chatFriendCategoryMapper.selectByExample(friendCategoryExample);
		List<ChatFriend> friends = chatFriendMapper.selectByExample(friendExample);
		try {
			if(categories != null && categories.size() > 0){
				list = new ArrayList<ChatFriendCategoryVO>();
				for(ChatFriendCategory category : categories){
					ChatFriendCategoryVO categoryVO = new ChatFriendCategoryVO();
					BeanUtils.copyProperties(categoryVO, category);
					for(Iterator<ChatFriend> iter=friends.iterator();iter.hasNext();){
						ChatFriend friend = iter.next();
						if(category.getFriendCategoryId().equals(friend.getFriendCategoryId())){
							ChatFriendVO friendVO = new ChatFriendVO();
							BeanUtils.copyProperties(friendVO, friend);
							categoryVO.getFriends().add(friendVO);
							iter.remove();
						}
					}
					
					list.add(categoryVO);
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
