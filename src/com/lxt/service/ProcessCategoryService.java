package com.lxt.service;

import java.util.List;

import com.lxt.model.ProcessCategory;

public interface ProcessCategoryService {
	
	public List<ProcessCategory> queryChildren(String parentId) throws ServiceException;
	
	public List<ProcessCategory> queryAll() throws ServiceException;
}
