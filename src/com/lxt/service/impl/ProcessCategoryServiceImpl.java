package com.lxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxt.dao.mapper.ProcessCategoryMapper;
import com.lxt.model.ProcessCategory;
import com.lxt.model.ProcessCategoryExample;
import com.lxt.service.ProcessCategoryService;
import com.lxt.service.ServiceException;
import com.lxt.common.utils.CheckUtils;

@Service
public class ProcessCategoryServiceImpl implements ProcessCategoryService{
	@Autowired
	private ProcessCategoryMapper workflowCategoryMapper;
	
	public List<ProcessCategory> queryChildren(String parentId) throws ServiceException{
		List<ProcessCategory> list = null;
		
		if(CheckUtils.isNotEmpty(parentId)){
			ProcessCategoryExample example = new ProcessCategoryExample();
			example.or().andParentIdEqualTo(parentId);
			list = workflowCategoryMapper.selectByExample(example);
		}
		
		return list;
	}
	
	public List<ProcessCategory> queryAll() throws ServiceException {
		List<ProcessCategory> list = null;
		
		list = workflowCategoryMapper.selectByExample(null);
		
		return list;
	}
}
