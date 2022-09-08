package com.example.observerdemo;

import org.springframework.stereotype.Component;

@Component
@Observe(appPhaseContextId = "someId")
public class ObserverImplementation implements Observer {


	@Override
	public void notifyBefore(Event event) {
		
	}

	@Override
	public void notifyAfter(Event event) {
		
	}



}