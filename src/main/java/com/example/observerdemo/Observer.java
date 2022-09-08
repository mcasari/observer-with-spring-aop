package com.example.observerdemo;

public interface Observer {

	void executeBefore(Event event);
	
	void executeAfter(Event event);
	
}