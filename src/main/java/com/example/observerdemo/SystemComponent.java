package com.example.observerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SystemComponent  {
	private Logger log = LoggerFactory.getLogger(SystemComponent.class);
	
	public void enterSomeApplicationPhase(SystemInfo systemInfo) {
		log.info("Entered system phase: " + systemInfo.getSomeId());
	}
	
}