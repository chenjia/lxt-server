package com.lxt.common.plugin.workflow.bpmn.entity3;

import java.lang.String;

public class Transition {
	private String name;
	private String to;
	private Condition condition;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
