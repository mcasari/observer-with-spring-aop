package com.example.observerdemo.core;

import java.util.HashMap;
import java.util.Map;

public class ObserverMap  {

	private static Map<String, Observer> observerMap;
	

	public static Map<String, Observer> getObserverMap() {
		if (observerMap == null) {
			observerMap = new HashMap<String, Observer>();
		}
		return observerMap;
	}
	
	
}