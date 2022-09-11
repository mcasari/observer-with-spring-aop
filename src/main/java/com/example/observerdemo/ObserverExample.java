package com.example.observerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.observerdemo.core.Event;
import com.example.observerdemo.core.Observe;
import com.example.observerdemo.core.Observer;

@Component
@Observe(appPhaseContextId = "someId")
public class ObserverExample implements Observer {
	private Logger log = LoggerFactory.getLogger(SystemComponent.class);

	@Override
	public void notify(Event event) {
		log.info("Catched event related to applicationInfo id: " + ((SystemInfo) event.getEventPayload()).getSomeId());
	}

}