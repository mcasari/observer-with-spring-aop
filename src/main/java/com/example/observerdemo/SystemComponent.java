package com.example.observerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemComponent  {
	private Logger log = LoggerFactory.getLogger(ObserverPostProcessor.class);
	
	public void enterSomeApplicationPhase(SystemInfo systemInfo) {
		log.info("Entered system phase: " + systemInfo.getSomeId());
	}
	
}