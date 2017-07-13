package com.lxt.common.plugin.workflow.bpmn.entity3;

public class SubProcess extends Activity {
	private String subProcessId;
	private String subProcessKey;
	private String outcome;

	private ParameterIn parameterIn;
	private ParameterOut parameterOut;

	public String getSubProcessId() {
		return subProcessId;
	}

	public void setSubProcessId(String subProcessId) {
		this.subProcessId = subProcessId;
	}

	public String getSubProcessKey() {
		return subProcessKey;
	}

	public void setSubProcessKey(String subProcessKey) {
		this.subProcessKey = subProcessKey;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public ParameterIn getParameterIn() {
		return parameterIn;
	}

	public void setParameterIn(ParameterIn parameterIn) {
		this.parameterIn = parameterIn;
	}

	public ParameterOut getParameterOut() {
		return parameterOut;
	}

	public void setParameterOut(ParameterOut parameterOut) {
		this.parameterOut = parameterOut;
	}

}
