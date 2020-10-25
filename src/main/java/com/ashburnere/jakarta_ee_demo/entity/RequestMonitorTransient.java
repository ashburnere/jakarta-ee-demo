package com.ashburnere.jakarta_ee_demo.entity;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Singleton;

@Singleton
public class RequestMonitorTransient {
	
	private final List<String> requests = new LinkedList<>();
	
	public void addSession(String request) {
		this.requests.add(request);
	}
	
	public void addRequest(String request) {
		this.requests.add(request);
	}
	
	public int getRequestCount() {
		return this.requests.size();
	}

}
