package com.example.observerdemo;

import java.io.Serializable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class ObserverAspect implements Serializable {
	private static final long serialVersionUID = 1L;	
	private Logger log = LoggerFactory.getLogger(ObserverPostProcessor.class);

	
	@Before("execution(* it.eng.sira.procedimenti.web.IstanzaProcessoController.setPassoEventoEseguito(..)) || execution(* it.eng.sira.procedimenti.web.PassoEventoController.setPassoEventoEseguito(..))")
	public void beforeSetPassoEventoEseguito(JoinPoint joinPoint) {
		try {
			if(joinPoint.getArgs() != null) {
				Object istanzaProcessoBean = (Object) joinPoint.getArgs()[0];	
			}	
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@After("execution(* it.eng.sira.procedimenti.web.IstanzaProcessoController.setPassoEventoEseguito(..)) || execution(* it.eng.sira.procedimenti.web.PassoEventoController.setPassoEventoEseguito(..))")
	public void afterSetPassoEventoEseguito(JoinPoint joinPoint) {	
		try {
			if(joinPoint.getArgs() != null) {
	
			}	
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
}
