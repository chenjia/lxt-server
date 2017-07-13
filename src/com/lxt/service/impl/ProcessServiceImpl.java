package com.lxt.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxt.common.bean.PageData;
import com.lxt.common.constant.DictionaryConstant;
import com.lxt.common.constant.ProcessVariable;
import com.lxt.dao.mapper.ProcessMapper;
import com.lxt.dao.mapper.UserMapper;
import com.lxt.model.Process;
import com.lxt.model.ProcessExample;
import com.lxt.model.User;
import com.lxt.model.vo.WorkflowVO;
import com.lxt.service.ProcessService;
import com.lxt.service.ServiceException;
import com.lxt.common.utils.CheckUtils;
import com.lxt.common.utils.DictionaryUtils;
import com.lxt.common.plugin.workflow.bpmn.utils.ActivitiUtils;

@Service
public class ProcessServiceImpl implements ProcessService{
	@Autowired
	private ProcessMapper workflowMapper;
	
	@Autowired
	private ActivitiUtils activitiUtils;
	
	@Autowired
	private UserMapper userMapper;
	
	public PageData<Process> queryByPage(ProcessExample example) throws ServiceException{
		PageData<Process> pageData = new PageData<Process>();
		
		List<Process> rows = workflowMapper.selectByExample(example);
		Long total = workflowMapper.countByExample(example);
		pageData.setRows(rows);
		pageData.setTotal(total.intValue());
		
		return pageData;
	}
	
	public WorkflowVO getById(String workflowId) throws ServiceException{
		WorkflowVO workflowVO = null;
		
		if(CheckUtils.isNotEmpty(workflowId)){
			Process workflow = workflowMapper.selectByPrimaryKey(workflowId);
			if(workflow != null){
				workflowVO = new WorkflowVO();
				try {
					BeanUtils.copyProperties(workflowVO, workflow);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new ServiceException(e);
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					throw new ServiceException(e);
				}
			}
		}
		
		return workflowVO;
	}
	
	public Map<String,String> saveWorkflow(String graphXml) throws ServiceException{
		return null;
//		Map<String,String> idMap = new HashMap<String, String>();
//		try {
//			Date createTime = new Date();
//			MxGraphModel model = XmlUtils.toGraphObj(graphXml);
//			com.lxt.workflow.bpmn.entity.Workflow workflow = XmlUtils.parseBpmn(model);
//			Root root = model.getRoot();
//			Workflow graphWorkflow = root.getWorkflow();
//			List<Vertex> vertexs = root.getVertexs();
//	
//			Workflow p = null;
//			String graphWorkflowId = graphWorkflow.getWorkflowId();
//			if(CheckUtils.isNotEmpty(graphWorkflowId)){
//				p = workflowMapper.selectByPrimaryKey(graphWorkflowId);
//			}else{
//				p = new Workflow();
//				p.setPublishStatus((Integer) DictionaryUtils.getDictionaryValue(CodeConstant.PROCESS_UNPUBLISH));
//			}
//			BeanUtils.copyProperties(p, graphWorkflow);
//			p.setGraphXml(graphXml);
//			p.setCreateTime(createTime);
//			p.setModifyTime(createTime);
//			p.setName(graphWorkflow.getLabel());
//			List<AbstractActivity> activities = workflow.getActivities();
//			for(Activity activity : activities){
//				String activityId = activity.getId();
//				String activityNodeId = activity.getNodeId();
//				LxtNode node = null;
//				for(Object obj : workflow.getLxtNodes()){
//					LxtNode lxtNode = (LxtNode) obj;
//					String nodeId = lxtNode.getNodeId();
//					if(CheckUtils.isNotEmpty(activityNodeId) && activityNodeId.equals(nodeId)){
//						node = lxtNode;
//						node.setCellId(activityId);
//						break;
//					}
//				}
//				if(node == null){
//					node = new LxtNode();
//					node.setCellId(activityId);
//				}
//				BeanUtils.copyProperties(node, activity);
//				Iterator<Vertex> iterator = vertexs.iterator();
//				while(iterator.hasNext()){
//					Vertex vertex = iterator.next();
//					if(vertex.getId().equals(activity.getId())){
//						BeanUtils.copyProperties(node, vertex);
//						Map<String,Object> map = vertex.getNodeAttributes();
////						Set<LxtNodeAttr> attrs = node.getLxtNodeAttrs();
////						for(Entry<String, Object> entry : map.entrySet()){
////							LxtNodeAttr attr = null;
////							for(Object obj : node.getLxtNodeAttrs()){
////								LxtNodeAttr lxtNodeAttr = (LxtNodeAttr) obj;
////								if(entry.getKey().equals(lxtNodeAttr.getNodeAttr())){
////									attr = lxtNodeAttr;
////									break;
////								}
////							}
////							if(attr == null){
////								attr = new LxtNodeAttr();
////							}
////							attr.setNodeAttr(entry.getKey());
////							attr.setNodeValue(entry.getValue().toString());
////							if(CheckUtils.isEmpty(attr.getId())){
////								attrs.add(attr);
////							}
////						}
//					}
//				}
//				if(CheckUtils.isEmpty(node.getNodeId())){
//					workflow.getLxtNodes().add(node);
//				}
//			}
//			workflowDAO.saveOrUpdate(workflow);
//			idMap.put("workflowId", workflow.getWorkflowId());
//			for(Object obj : workflow.getLxtNodes()){
//				LxtNode node = (LxtNode) obj;
//				idMap.put(node.getCellId(), node.getNodeId());
//			}
//			
//			model.setDescriptions(idMap);
//			
//			workflow = JpdlUtils.graphToJpdl(model);
//			String jpdlXml = JpdlUtils.toJpdlXml(workflow);
//			if(!jpdlXml.equals(workflow.getJbpmXml())){
//				String deployeId = jbpmUtils.deploy(graphWorkflow.getWorkflowKey(),jpdlXml);
//				workflow.setDeployeId(deployeId);
//			}
//			workflow.setJbpmXml(jpdlXml);
//			workflow.setGraphXml(graphXml);
//		} catch (DAOException e) {
//			e.printStackTrace();
//			throw new ServiceException(e);
//		} catch (Exception e){
//			e.printStackTrace();
//			throw new ServiceException(e);
//		}
//		return idMap;
	}
	
	public void publishWorkflow(String workflowId) throws ServiceException{
		if(CheckUtils.isNotEmpty(workflowId)){
			Process workflow = workflowMapper.selectByPrimaryKey(workflowId);
			workflow.setPublishStatus((Integer) DictionaryUtils.getValue(DictionaryConstant.PROCESS_PUBLISHED));
			workflowMapper.updateByPrimaryKey(workflow);
		}else {
			throw new ServiceException("无效的流程ID");
		}
	}
	
	public void deleteWorkflow(String workflowId) throws ServiceException{
		if(CheckUtils.isNotEmpty(workflowId)){
			Process workflow = workflowMapper.selectByPrimaryKey(workflowId);
			workflowMapper.deleteByPrimaryKey(workflowId);
			activitiUtils.deleteDeployment(workflow.getDeployeId(), true);
		}else {
			throw new ServiceException("无效的流程ID");
		}
	}
	
	public void deleteAllWorkflow() throws ServiceException {
		activitiUtils.deleteDeployments();
		workflowMapper.deleteByExample(null);
	}
	
	public String startWorkflow(String workflowId, String userId) throws ServiceException{
		String workflowInstanceId = null;
		
		Process workflow = workflowMapper.selectByPrimaryKey(workflowId);
		if(!workflow.getPublishStatus().equals(DictionaryUtils.getValue(DictionaryConstant.PROCESS_PUBLISHED))){
			throw new RuntimeException("对不起，该流程尚未发布！");
		}
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.put(ProcessVariable.PROCESS_OWNER, userId);
		variables.put(ProcessVariable.PROCESS_ID, workflow.getProcessId());
		workflowInstanceId = activitiUtils.startWorkflow(workflow.getDeployeId(), variables);
		
		return workflowInstanceId;
	}
	
	public Map<String,Object> queryHistoryStep(String workflowInstanceId) throws ServiceException{
		Map<String,Object> historyStepMap = new HashMap<String, Object>();
		
		List<Map<String,Object>> currentList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> historyList = new ArrayList<Map<String,Object>>();
		List<HistoricActivityInstance> history = activitiUtils.getHistoryService().createHistoricActivityInstanceQuery().processInstanceId(workflowInstanceId).list();
		
		for(HistoricActivityInstance temp : history){
			if("TASK".equalsIgnoreCase(temp.getActivityType())){
				Map<String, Object> currentMap = new HashMap<String, Object>();
				Map<String,Object> historyMap = new HashMap<String, Object>();
				HistoricTaskInstance task = (HistoricTaskInstance) temp;
				if(task.getEndTime()==null){
					currentMap.put("activity", task.getName());
					currentMap.put("executionId", task.getExecutionId());
					if(!CheckUtils.isNotEmpty(task.getAssignee())){
						User assigner = userMapper.selectByPrimaryKey(task.getAssignee());
						if(assigner!=null){
							currentMap.put("userId", assigner.getUserId());
							currentMap.put("realname", assigner.getRealname());
						}else{
							currentMap.put("userId", "");
							currentMap.put("realname", "");
						}
					}
					currentList.add(currentMap);
				}else{
					historyMap.put("activity", temp.getActivityName());
					historyMap.put("eid", temp.getExecutionId());
//					historyMap.put("transition", task.getTransitionName());
					historyMap.put("createTime", temp.getStartTime());
					historyMap.put("endTime", temp.getEndTime());
					User user = userMapper.selectByPrimaryKey(task.getAssignee());
					historyMap.put("assigner", user.getUsername());
					historyMap.put("userId", user.getUserId());
					historyList.add(historyMap);
				}
			}
		}
		historyStepMap.put("history", historyList);
		historyStepMap.put("current", currentList);
		
		return historyStepMap;
	}
}
