package com.example.observerdemo;
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
		processObserverAnnotation(bean, beanName);
		return bean;
	}
	
	
	private void processObserverAnnotation(Object object, String beanName) {     
	    try {
			Class<?> clazz = object.getClass();
			if (clazz.isAnnotationPresent(ObserverAnnotation.class)) {
				Annotation annotation = clazz.getAnnotation(ObserverAnnotation.class);
				ObserverAnnotation observerAnnotation = (ObserverAnnotation) annotation;
				
			}
		} catch (Throwable e) {
			log.error("Errore in caricamento observers eventi procedimenti: " + e.getMessage());
		}        
	}
	
} 