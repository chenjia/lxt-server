package com.lxt.common.plugin.workflow.graph.entity;

import java.util.HashMap;
import java.util.Map;

public class End extends Vertex{
	private String label;
	private String nodeType = "end";
	private boolean isSymbol = true;
	private String id;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public boolean isSymbol() {
		return isSymbol;
	}

	public void setSymbol(boolean isSymbol) {
		this.isSymbol = isSymbol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Map<String, Object> getNodeAttributes() {
		return new HashMap<String, Object>();
	}
}
