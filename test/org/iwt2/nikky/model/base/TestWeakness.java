package org.iwt2.nikky.model.base;


import static org.junit.Assert.*;

import org.iwt2.nikky.NikkyConstants;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


/**
 * Warning. I don't control the constant NikkyConstants.COLORBLUE 
 * If this constant changes (it is a production code's constant) I have to modify
 * this code a lot
 * 
 * Maybe defining my own constant ?
 * @author Javier
 *
 */
public class TestWeakness {

	CombatObject co;
	Weakness weakness;
	String BLUE = NikkyConstants.COLORBLUE;

	@Before
	public void setUp() throws Exception {
		co = mock(CombatObject.class);

	}

	@Test
	public void whenReceivesABlueCombatObject_WeaknessToBlueReturnTrue() {
		weakness = new WeaknessToBlue();
		
		co.setColor(BLUE);
		when(co.isColor(BLUE)).thenReturn(true);
		
		
		assertTrue(weakness.isWeakTo(co));
		
	}

	@Test
	public void whenReceivesAnCombatObjectWithOtherColor_WeaknessToBlueReturnFalse() {
		weakness = new WeaknessToBlue();
		
		co.setColor("Yellow");
		when(co.isColor(BLUE)).thenReturn(false);
		
		
		assertFalse(weakness.isWeakTo(co));
	}

	@Test
	public void whenReceivesAFoodCombatObject_WeaknessToFoodReturnTrue() {
		weakness = new WeaknessToFood();
		
		co.setFood();
		when(co.isFood()).thenReturn(true);
		
		assertTrue(weakness.isWeakTo(co));	
	}

}
