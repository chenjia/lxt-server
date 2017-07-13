package com.lxt.common.plugin.workflow.graph.utils;

import com.lxt.common.plugin.workflow.graph.entity.Vertex;

public class NodeBuilderFactory {
	
	public static NodeBuilder getBuilder(Vertex vertex){
		NodeBuilder builder = null;
		
		String nodeType = vertex.getNodeType();
		
		if("start".equals(nodeType)){
			builder = new StartBuilder();
		}else if("task".equals(nodeType)){
			builder = new TaskBuilder();
		}else if("end".equals(nodeType)){
			builder = new EndBuilder();
		}
		
		return builder;
	}
}
