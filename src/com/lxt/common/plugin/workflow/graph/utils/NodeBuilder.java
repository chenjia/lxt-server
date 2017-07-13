package com.lxt.common.plugin.workflow.graph.utils;

import com.lxt.common.plugin.workflow.bpmn.entity3.Activity;
import com.lxt.common.plugin.workflow.graph.entity.Vertex;


public abstract class NodeBuilder {
	public abstract Activity build(Vertex vertex);
}
