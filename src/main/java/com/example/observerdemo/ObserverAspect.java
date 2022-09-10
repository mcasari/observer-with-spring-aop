package com.example.observerdemo;

import java.io.Serializable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class ObserverAspect implements Serializable {
	private static final long serialVersionUID = 1L;	
	private Logger log = LoggerFactory.getLogger(ObserverPostProcessor.class);

	
	@After("execution(* com.example.observerdemo.SystemComponent.enterSomeApplicationPhase(..)))")
	public void afterPhaseChange(JoinPoint joinPoint) {
		try {
			if(joinPoint.getArgs() != null) {
				SystemInfo applicationInfo = (SystemInfo) joinPoint.getArgs()[0];	
				Observer observer = ObserverMap.getObserverMap().get(applicationInfo.getSomeId());
				if (observer != null) {
					Event event = new Event(applicationInfo);
					observer.notify(event);					
				}
			}	
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	
}
