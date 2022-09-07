package com.example.observerdemo;

import org.aspectj.lang.ProceedingJoinPoint;



public class ObserverDefault implements Observer {



	@Override
	public void executeBefore(Event event) {
		
	}

	@Override
	public void executeAfter(Event event) {
		
	}

	@Override
	public Object executeAround(Event event, ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();		
	}


}