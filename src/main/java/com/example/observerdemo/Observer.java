package com.example.observerdemo;

import org.aspectj.lang.ProceedingJoinPoint;

public interface Observer {

	void executeBefore(Event event);
	
	void executeAfter(Event event);
	
	Object executeAround(Event event, ProceedingJoinPoint joinPoint) throws Throwable;

}