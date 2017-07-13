package com.lxt.common.plugin.workflow.bpmn.entity3;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public abstract class Activity {
	protected String id;
	protected String nodeId;
	protected String name;
	protected List<Transition> transitions = new ArrayList<Transition>();
	
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

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Transition> getTransitions() {
		return transitions;
	}
	
	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
	
}
