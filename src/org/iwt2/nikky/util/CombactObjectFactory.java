package org.iwt2.nikky.util;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.base.CombatObject;

/**
 * This class contains a hard-coded list of all thw combat objects created
 * this class should be in a JSn or similar file.
 * 
 * @author Javier
 *
 */
public class CombactObjectFactory {

	public List<CombatObject> createObjects() {
		
		List<CombatObject> objects = new ArrayList<CombatObject>();
		
		objects.add(createCarrod());
		objects.add(createApple());
		objects.add(createBanana());
		
		return objects;
	}

	private CombatObject createCarrod() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Carrot");
		coa.setColor(NikkyConstants.COLORORANGE);
		coa.setFood();
		
		return coa;
	}

	private CombatObject createApple() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Apple");
		coa.setColor(NikkyConstants.COLORRED);
		coa.setFood();
		
		return coa;
	}
	
	private CombatObject createBanana() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Banana");
		coa.setColor(NikkyConstants.COLORYELLOW);
		coa.setFood();
		
		return coa;
	}
}
