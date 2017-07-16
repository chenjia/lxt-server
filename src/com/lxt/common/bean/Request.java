package com.lxt.common.bean;

import java.util.Map;

public class Request extends Json {
	private Head head;

	private Body body;
	
	public String getString(String key){
		Map<String, Object> map = (Map<String, Object>) body.getData();
		return (String) map.get(key);
	}
	
	public int getInt(String key ) {
		Map<String, Object> map = (Map<String, Object>) body.getData();
		return (int) map.get(key);
	}

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
