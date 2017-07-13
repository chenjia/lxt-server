package com.lxt.common.plugin.workflow.bpmn.entity3;

import java.lang.String;

public class AssignmentHandler {
	private String clazz = "com.lxt.workflow.assigner.TaskAssigneeHandler";
	private Field field = new Field();
	
	public Field getField() {
		return field;
	}
	
	public void setField(Field field) {
		this.field = field;
	}
	
	public String getClazz() {
		return clazz;
	}
	
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
