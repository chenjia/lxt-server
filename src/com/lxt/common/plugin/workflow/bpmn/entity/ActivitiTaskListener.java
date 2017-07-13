package com.lxt.common.plugin.workflow.bpmn.entity;

public class ActivitiTaskListener {
	private String event = "create";
	private String clazz = "com.lxt.workflow.bpmn.listener.MyAssignmentHandler";

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
