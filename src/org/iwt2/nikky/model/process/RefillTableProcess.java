package org.iwt2.nikky.model.process;

import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.actors.Table2D;
import org.iwt2.nikky.model.base.CombatObject;

public class RefillTableProcess implements ObjectObserver {

	Table2D table;
	int objects;
	
	public RefillTableProcess(Table2D table) {
		this.table = table;
		objects = table.countElements();
		if (objects == 0) {
			System.out.println("RefillTableProcess::constructor - Warning, table is empty.");
		}
	}

	@Override
	public void clickInObject(CombatObject co) {
		this.objects--;
		if (this.objects == 0)
			this.refillTable();

	}

	void refillTable() {
		this.table.clearObjects();
		
	}

}
