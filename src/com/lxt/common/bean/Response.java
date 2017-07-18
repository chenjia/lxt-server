package com.lxt.common.bean;

import java.io.Serializable;

public class Response extends Json implements Serializable{

	private static final long serialVersionUID = 5974897824489203139L;

	private Head head = new Head();
	
	private Body body = new Body();

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
}
