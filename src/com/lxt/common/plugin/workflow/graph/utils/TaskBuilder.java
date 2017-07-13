package com.lxt.common.plugin.workflow.graph.utils;

import com.lxt.common.plugin.workflow.bpmn.entity3.Activity;
import com.lxt.common.plugin.workflow.bpmn.entity3.Field;
import com.lxt.common.plugin.workflow.bpmn.entity3.Task;
import com.lxt.common.plugin.workflow.graph.entity.Vertex;

public class TaskBuilder extends NodeBuilder{
	@Override
public Activity build(Vertex vertex) {
		Task task = new Task();
		com.lxt.common.plugin.workflow.graph.entity.Task graphTask = (com.lxt.common.plugin.workflow.graph.entity.Task) vertex;
		task.setId(graphTask.getId());
		task.setNodeId(graphTask.getNodeId());
		task.setForm(graphTask.getForm());
		Field field = task.getAssignmentHandler().getField();
		field.setName("nodeId");
		field.getString().setValue(graphTask.getNodeId());
		task.setName(graphTask.getLabel());
		return task;
	}
}
