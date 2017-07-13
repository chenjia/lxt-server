package com.lxt.common.plugin.workflow.graph.utils;

import com.lxt.common.plugin.workflow.bpmn.entity3.Activity;
import com.lxt.common.plugin.workflow.bpmn.entity3.End;
import com.lxt.common.plugin.workflow.graph.entity.Vertex;


public class EndBuilder extends NodeBuilder {
	@Override
	public Activity build(Vertex vertex) {
		End end = new End();
		com.lxt.common.plugin.workflow.graph.entity.End graphEnd = (com.lxt.common.plugin.workflow.graph.entity.End) vertex;
		end.setId(graphEnd.getId());
		end.setNodeId(graphEnd.getNodeId());
		end.setName(graphEnd.getLabel());
		return end;
	}
}
