package com.example.observerdemo.core;
import java.lang.annotation.Annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ObserverPostProcessor implements BeanPostProcessor {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;	
	Logger log = LoggerFactory.getLogger(ObserverPostProcessor.class);
	
	
//	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
	    try {
			Class<?> clazz = bean.getClass();
			if (clazz.isAnnotationPresent(Observe.class)) {
				Annotation annotation = clazz.getAnnotation(Observe.class);
				if (annotation instanceof Observe) {
					Observe observerAnnotation = (Observe) annotation;
					String appPhaseContextId = observerAnnotation.appPhaseContextId();
					if (!ObserverMap.getObserverMap().containsKey(appPhaseContextId)) {
						ObserverMap.getObserverMap().put(appPhaseContextId, (Observer) bean);
					} else {
						log.error("Cannot register bean " + bean.getClass().getName() 
								+ " as observer. Another observer already configured with id: "
								+ appPhaseContextId);					
					}					
				}
			}
		} catch (Throwable e) {
			log.error("Unexpected error: " + e.getMessage());
		} 
		return bean;
	}
	
} 