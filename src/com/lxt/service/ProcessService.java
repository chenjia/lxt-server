package com.lxt.service;

import java.util.Map;

import com.lxt.common.bean.PageData;
import com.lxt.model.Process;
import com.lxt.model.ProcessExample;
import com.lxt.model.vo.WorkflowVO;

public interface ProcessService {
	
	public PageData<Process> queryByPage(ProcessExample example) throws ServiceException;
	
	public WorkflowVO getById(String workflowId) throws ServiceException;
	
	public Map<String,String> saveWorkflow(String graphXml) throws ServiceException;
	
	public void publishWorkflow(String workflowId) throws ServiceException;
	
	public void deleteWorkflow(String workflowId) throws ServiceException;
	
	public void deleteAllWorkflow() throws ServiceException;
	
	public String startWorkflow(String workflowId, String userId) throws ServiceException;
	
	public Map<String,Object> queryHistoryStep(String workflowInstanceId) throws ServiceException;
}
