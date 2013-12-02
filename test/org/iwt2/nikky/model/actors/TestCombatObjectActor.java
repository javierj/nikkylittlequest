package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.base.CombatObject;
import org.junit.Before;
import org.junit.Test;



public class TestCombatObjectActor {

	CombatObject bco;
	
	@Before
	public void setUp() throws Exception {
		 bco = new CombatObjectActor();
	}

	@Test
	public void aNewCombatObjectItHasNoColor() {
		
		
		assertFalse(bco.isColor(NikkyConstants.COLORBLUE));
		assertFalse(bco.isColor(NikkyConstants.COLORYELLOW));
	}

	@Test
	public void aNewCombatObjectItIsNotFood() {
		
		assertFalse(bco.isFood());
	}

	@Test
	public void aNewCombatObjectMayHasAColor() {
		
		bco.setColor(NikkyConstants.COLORBLUE);
		assertTrue(bco.isColor(NikkyConstants.COLORBLUE));
	}

	@Test
	public void aBlueObject_isNot_aYellowObject() {
		
		bco.setColor(NikkyConstants.COLORBLUE);
		assertFalse(bco.isColor(NikkyConstants.COLORYELLOW));
	}

	
	@Test
	public void aNewCombatObjectMayBeFood() {
		
		bco.setFood();
		assertTrue(bco.isFood());
	}

}
