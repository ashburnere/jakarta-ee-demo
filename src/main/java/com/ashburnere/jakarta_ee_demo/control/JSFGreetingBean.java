package com.ashburnere.jakarta_ee_demo.control;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import com.ashburnere.jakarta_ee_demo.entity.RequestMonitorTransient;

@SuppressWarnings("serial")
@Named("JSFGreetingBean")
public class JSFGreetingBean implements Serializable {

	private String greeting = "I'm a regular JSF Bean";

	@Inject
	RequestMonitorTransient requestMonitorTransient;

	@PostConstruct
	public void start() {
		this.greeting = "I'm using lifecycle annotations";
		greeting += " and I'm using resource injection!";
		greeting += " " + requestMonitorTransient.getRequestCount();
	}

	public void setGreeting(String newGreeting) {
		this.greeting += newGreeting;
	}

	public String getGreeting() {
		return this.greeting;
	}
}