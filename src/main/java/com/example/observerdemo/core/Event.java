package com.example.observerdemo.core;

public class Event {
	
	private Object eventPayload;

	
	
	public Event(Object eventPayload) {
		super();
		this.eventPayload = eventPayload;
	}



	public Object getEventPayload() {
		return eventPayload;
	}
	
}
