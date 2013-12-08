package org.iwt2.nikky.model.process;

import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.actors.Table2D;
import org.iwt2.nikky.model.actors.Table2DFactory;
import org.iwt2.nikky.model.base.CombatObject;

public class RefillTableProcess implements ObjectObserver {

	Table2D table;
	int objects;
	private Table2DFactory tableFactory;
	
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
		
		if (tableFactory == null) {
			System.out.println("RefillTableProcess::refillTable() - No Table2DFactory.CallsetTable2DFactory first");
			return;
		}
		
		this.tableFactory.createTable2D(table);
	}

	public void setTable2DFactory(Table2DFactory tableFactory) {
		this.tableFactory = tableFactory;
		
	}

}
