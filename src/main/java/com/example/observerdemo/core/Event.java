package com.example.observerdemo.core;

import com.example.observerdemo.SystemInfo;

public class Event {
	
	private SystemInfo applicationInfo;

	
	
	public Event(SystemInfo applicationInfo) {
		super();
		this.applicationInfo = applicationInfo;
	}



	public SystemInfo getApplicationInfo() {
		return applicationInfo;
	}
	
}
