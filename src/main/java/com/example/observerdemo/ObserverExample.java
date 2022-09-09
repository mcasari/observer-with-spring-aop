package com.example.observerdemo;

import org.springframework.stereotype.Component;

@Component
@Observe(appPhaseContextId = "someId")
public class ObserverExample implements Observer {


	@Override
	public void notify(Event event) {
		
	}

}