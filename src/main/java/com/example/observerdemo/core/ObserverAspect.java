package com.example.observerdemo.core;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.observerdemo.SystemInfo;



@Component
@Aspect
public class ObserverAspect {	
	private Logger log = LoggerFactory.getLogger(ObserverAspect.class);

	
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
