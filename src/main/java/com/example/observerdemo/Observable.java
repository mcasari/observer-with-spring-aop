package com.example.observerdemo;

import java.util.Set;

public class Observable  {

	private static Set<Observer> observerSet;
	
	public void add(Observer observer) {
		observerSet.add(observer);
	}


	public void remove(Observer observer) {
		observerSet.remove(observer);
	}


	public static Set<Observer> getObserverSet() {
		return observerSet;
	}
	
	
	

}