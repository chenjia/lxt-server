package com.lxt.common.plugin.workflow.bpmn.entity3;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Process {

	private String name;
	private String key;
	private String xmlns = "http://jbpm.org/4.4/jpdl";
	//private String version;
	private String description;
	private List<Activity> activities = new ArrayList<Activity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String string) {
		this.key = string;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

//	public String getVersion() {
//		return version;
//	}
//
//	public void setVersion(String version) {
//		this.version = version;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
