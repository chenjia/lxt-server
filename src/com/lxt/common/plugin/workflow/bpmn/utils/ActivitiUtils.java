package com.lxt.common.plugin.workflow.bpmn.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * activiti流程引擎帮助类
 * @author chenjia
 * @version 
 * @date：2014-10-27
 */
public class ActivitiUtils{
	
	public ActivitiUtils(ProcessEngine processEngine) {
		this.processEngine = processEngine;
		this.repositoryService = processEngine.getRepositoryService();
		this.runtimeService = processEngine.getRuntimeService();
		this.taskService = processEngine.getTaskService();
		this.historyService = processEngine.getHistoryService();
		this.managementService = processEngine.getManagementService();
	}
	
	private ProcessEngine processEngine = null;
	private RepositoryService repositoryService = null;
	private RuntimeService runtimeService = null;
	private TaskService taskService = null;
	private HistoryService historyService = null;
	private ManagementService managementService = null;
	
	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public ManagementService getManagementService() {
		return managementService;
	}
	
	
	/**
	 * 级联删除已部署流程
	 * @param deploymentId 部署ID
	 * @param cascade 是否级联删除
	 */
	public void deleteDeployment(String deploymentId, boolean cascade) {
		Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
		if(deployment!=null){
			repositoryService.deleteDeployment(deploymentId, cascade);
		}
	}
	
	/**
	 * 级联删除已部署流程
	 */
	public void deleteDeployments(){
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
		for(ProcessDefinition pd : list){
			repositoryService.deleteDeployment(pd.getDeploymentId(), true);
		}
	}
	
	/**
	 * 部署流程
	 * @param resourceName 资源文件名
	 * @param xml 字符串
	 * @return
	 */
	public String deploy(String resourceName,String xml){
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		Deployment deployment = deploymentBuilder.addString(resourceName+".jpdl.xml", xml).name(resourceName).deploy();
		return deployment.getId();
	}
	
	/**
	 * 发起流程
	 * @param deployId 发布ID
	 * @return
	 */
	public String startWorkflow(String deployId){
		String pid = null;
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).list();
		if(list.size()==1){
			pid = runtimeService.startProcessInstanceById(list.get(0).getId()).getId();
		}
		return pid;
	}
	
	/**
	 * 发起流程
	 * @param deployId 发布ID
	 * @param variables 流程变量
	 * @return
	 */
	public String startWorkflow(String deployId,Map<String, Object> variables){
		String pid = null;
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).list();
		if(list.size()==1){
			pid = runtimeService.startProcessInstanceById(list.get(0).getId(),variables).getId();
			runtimeService.setVariables(pid, variables);
		}
		return pid;
	}
	
	/**
	 * 设置变量
	 * @param eid
	 * @param key
	 * @param value
	 */
	public void setVariable(String eid,String key,Object value){
		runtimeService.setVariable(eid, key, value);
	}
	
	/**
	 * 设置变量
	 * @param eid
	 * @param variables
	 */
	public void setVariables(String eid,Map<String,Object> variables){
		runtimeService.setVariables(eid, variables);
	}
	
	/**
	 * 获得变量
	 * @param eid
	 * @param key
	 * @return
	 */
	public Object getVariable(String eid,String key){
		return runtimeService.getVariable(eid, key);
	}
	
	/**
	 * 获得变量
	 * @param eid
	 * @param variableNames
	 * @return
	 */
	public Map<String,Object> getVariables(String eid,Set<String> variableNames){
		return runtimeService.getVariables(eid, variableNames);
	}
	
	/**
	 * 结束一个活动（任务）
	 * @param taskId 任务ID
	 */
	public void complete(String taskId){
		taskService.complete(taskId);
	}
}
