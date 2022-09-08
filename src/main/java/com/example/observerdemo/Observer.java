package com.example.observerdemo;

public interface Observer {

	void notifyBefore(Event event);
	
	void notifyAfter(Event event);
	
}