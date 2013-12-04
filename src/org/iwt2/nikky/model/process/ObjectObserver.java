package org.iwt2.nikky.model.process;

import org.iwt2.nikky.model.base.CombatObject;

/**
 * Interface to be notified that a combat object has been selected
 * by user click
 * 
 * @author Javier
 *
 */
public interface ObjectObserver {
	public void clickInObject(CombatObject co);
}
