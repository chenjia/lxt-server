package com.lxt.common.plugin.workflow.bpmn.entity3;

public class Task extends Activity {
	private String assignee;
	private String candidateGroups;
	private String candidateUsers;
	private java.lang.String form;
	private AssignmentHandler assignmentHandler = new AssignmentHandler();
	private String swimlane;
	private Notification notification;
	private Reminder reminder;

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getCandidateGroups() {
		return candidateGroups;
	}

	public void setCandidateGroups(String candidateGroups) {
		this.candidateGroups = candidateGroups;
	}

	public String getCandidateUsers() {
		return candidateUsers;
	}

	public void setCandidateUsers(String candidateUsers) {
		this.candidateUsers = candidateUsers;
	}

	public AssignmentHandler getAssignmentHandler() {
		return assignmentHandler;
	}

	public void setAssignmentHandler(AssignmentHandler assignmentHandler) {
		this.assignmentHandler = assignmentHandler;
	}

	public String getSwimlane() {
		return swimlane;
	}

	public void setSwimlane(String swimlane) {
		this.swimlane = swimlane;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public java.lang.String getForm() {
		return form;
	}

	public void setForm(java.lang.String form) {
		this.form = form;
	}

}
