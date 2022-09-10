package com.example.observerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Observe(appPhaseContextId = "someId")
public class ObserverExample implements Observer {
	private Logger log = LoggerFactory.getLogger(SystemComponent.class);

	@Override
	public void notify(Event event) {
		log.info("Catched event related to applicationInfo id: " + event.getApplicationInfo().getSomeId());
	}

}