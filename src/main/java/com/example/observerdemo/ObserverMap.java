package com.example.observerdemo;

import java.util.Map;

public class ObserverMap  {

	private static Map<String, Observer> observerMap;
	

	public static Map<String, Observer> getObserverMap() {
		return observerMap;
	}
	
	
}