package com.lxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxt.dao.mapper.DictionaryMapper;
import com.lxt.model.Dictionary;
import com.lxt.service.ServiceException;
import com.lxt.service.DictionaryService;

@Service
public class DictionaryServiceImpl implements DictionaryService{
	
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Override
	public List<Dictionary> queryAll() throws ServiceException {
		List<Dictionary> dictionaryList = null;
		dictionaryList = dictionaryMapper.selectByExample(null);
		return dictionaryList;
	}
}
