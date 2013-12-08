package org.iwt2.nikky.util;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.process.ObjectObserver;

/**
 * This class stores a setof listeners (implementinterface ObjectObservable)
 * And andds those listenersto CombatbjectActor objects
 * 
 * @author Javier
 *
 */
public class ObserversLoader {

	private List<ObjectObserver> observers;

	
	
	/**
	 * 
	 */
	public ObserversLoader() {
		this.observers = new ArrayList<ObjectObserver>();
	}

	public void addObserver(ObjectObserver observer) {
		this.observers.add(observer);
		
	}

	public void decorate(CombatObjectActor object) {
		for (ObjectObserver oo: this.observers) {
			object.addObserver(oo);
		}
		
	}

	public void decorate(List<CombatObjectActor> objects) {
		for (CombatObjectActor object: objects) {
			this.decorate(object);
		}
		
	}

}
