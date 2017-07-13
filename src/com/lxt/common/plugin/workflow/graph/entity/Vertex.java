package com.lxt.common.plugin.workflow.graph.entity;

import java.util.Map;

public abstract class Vertex {
	protected String id;
	protected String nodeId;
	protected String nodeType;
	protected MxCell mxCell = new MxCell();
	protected String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public MxCell getMxCell() {
		return mxCell;
	}

	public void setMxCell(MxCell mxCell) {
		this.mxCell = mxCell;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract String getNodeType();

	public abstract Map<String, Object> getNodeAttributes();
}
