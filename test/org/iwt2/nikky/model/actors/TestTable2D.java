package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTable2D {

	private CombatObjectActor objectA;
	private CombatObjectActor objectB;

	@Before
	public void setUp() throws Exception {
		objectA = new CombatObjectActor();
		objectB = new CombatObjectActor();
	}

	@Test
	public void firstElementIsInFirstRow() {
		Table2D table = new Table2D();
		table.add(objectA);
		
		assertNotNull(table.get(0,0));
	}

	@Test
	public void secondElementIsInFirstRowSecondColumn() {
		Table2D table = new Table2D();
		table.add(objectA);
		table.add(objectB);
		
		assertTrue(table.get(0,1) == objectB);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void invalidElementThrowsAnException() {
		Table2D table = new Table2D();
		
		assertNotNull(table.get(0,0));
	}
	
	@Test
	public void whenRowsHasOneElement_secondElementIsInSecondRow() {
		Table2D table = new Table2D(1);
		table.add(objectA);
		table.add(objectB);
		
		assertTrue(table.get(1,0) == objectB);
	}
	
	

}
