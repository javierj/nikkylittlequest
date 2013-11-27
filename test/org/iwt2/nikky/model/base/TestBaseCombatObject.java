package org.iwt2.nikky.model.base;

import static org.junit.Assert.*;

import org.iwt2.nikky.NikkyConstants;
import org.junit.Before;
import org.junit.Test;

/**
 * A BaseCombatObject has no properties.
 * 
 * @author Javier
 *
 */
public class TestBaseCombatObject {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void aNewCombatObjectItHasNoColor() {
		CombatObject bco = new BaseCombatObject();
		
		assertFalse(bco.isColor(NikkyConstants.COLORBLUE));
	}

	@Test
	public void aNewCombatObjectItIsNotFood() {
		CombatObject bco = new BaseCombatObject();
		
		assertFalse(bco.isFood());
	}

	@Test
	public void aNewCombatObjectMayHasAColor() {
		CombatObject bco = new BaseCombatObject();
		
		bco.setColor(NikkyConstants.COLORBLUE);
		assertTrue(bco.isColor(NikkyConstants.COLORBLUE));
	}

	@Test
	public void aNewCombatObjectMayBeFood() {
		CombatObject bco = new BaseCombatObject();
		
		bco.setFood();
		assertTrue(bco.isFood());
	}

}
