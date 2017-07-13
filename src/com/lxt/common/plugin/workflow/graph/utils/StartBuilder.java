package com.lxt.common.plugin.workflow.graph.utils;

import com.lxt.common.plugin.workflow.bpmn.entity3.Activity;
import com.lxt.common.plugin.workflow.bpmn.entity3.Start;
import com.lxt.common.plugin.workflow.graph.entity.Vertex;

public class StartBuilder extends NodeBuilder{
	@Override
	public Activity build(Vertex vertex) {
		Start start = new Start();
		com.lxt.common.plugin.workflow.graph.entity.Start graphStart = (com.lxt.common.plugin.workflow.graph.entity.Start) vertex;
		start.setId(graphStart.getId());
		start.setNodeId(graphStart.getNodeId());
		start.setName(graphStart.getLabel());
		return start;
	}
}
