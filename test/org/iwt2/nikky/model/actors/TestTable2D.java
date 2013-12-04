package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;

public class TestTable2D {

	private CombatObjectActor objectA;
	private CombatObjectActor objectB;
	private CombatObjectActor objectC;
	private Table2D table;

	@Before
	public void setUp() throws Exception {
		table = new Table2D();
		objectA = new CombatObjectActor();
		objectB = new CombatObjectActor();
		objectC = new CombatObjectActor();
	}

	@Test
	public void firstElementIsInFirstRow() {
		table.add(objectA);
		
		assertNotNull(table.get(0,0));
	}

	@Test
	public void secondElementIsInFirstRowSecondColumn() {
		table.add(objectA);
		table.add(objectB);
		
		assertTrue(table.get(0,1) == objectB);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void invalidElementThrowsAnException() {
		
		
		assertNotNull(table.get(0,0));
	}
	
	@Test
	public void whenRowsHasOneElement_secondElementIsInSecondRow() {
		Table2D table = new Table2D(1);
		table.add(objectA);
		table.add(objectB);
		
		assertTrue(table.get(1,0) == objectB);
		
		
	}
	
	@Test
	public void testStructureWhenRowLimitIs1() {
		Table2D table = new Table2D(1);
		table.add(objectA);
		table.add(objectB);
		
		HorizontalGroup groups = (HorizontalGroup)table.getChildren().get(0);
		assertThat(groups.getChildren().size, is(1));
		groups = (HorizontalGroup)table.getChildren().get(1);
		assertThat(groups.getChildren().size, is(1));
	}

	@Test
	public void testScturctureIs3InARow() {
		Table2D table = new Table2D(3);
		//System.out.println("testScturctureIs3InARow");
		table.add(objectA);
		table.add(objectB);
		table.add(objectC);
		
		HorizontalGroup groups = (HorizontalGroup)table.getChildren().get(0);
		assertThat(groups.getChildren().size, is(3));
		
	}

	
	@Test
	public void testScturctureIs2X1() {
		Table2D table = new Table2D(2);
		//System.out.println("testScturctureIs2X2");
		table.add(objectA);
		table.add(objectB);
		table.add(objectC);
		
		assertThat(table.getChildren().size, is(2));
		
		HorizontalGroup groups = (HorizontalGroup)table.getChildren().get(1);
		assertThat(groups.getChildren().size, is(1));
		
		groups = (HorizontalGroup)table.getChildren().get(0);
		assertThat(groups.getChildren().size, is(2));
		
	}
	

}
