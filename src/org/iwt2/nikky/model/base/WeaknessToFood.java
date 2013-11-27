package org.iwt2.nikky.model.base;

public class WeaknessToFood implements Weakness {

	public boolean isWeakTo(CombatObject co) {
		return co.isFood();
	}

}
