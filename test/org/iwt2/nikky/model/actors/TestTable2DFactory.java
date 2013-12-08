package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.iwt2.nikky.view.TextureDict;
import org.iwt2.nikky.model.process.ObjectObserver;
import org.iwt2.nikky.util.CombactObjectFactory;
import org.junit.Before;
import org.junit.Test;

import testfactories.CombatObjectActorFactory;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;

public class TestTable2DFactory {

	private Table2D table;
	int objectsInRow = 2;
	private CombactObjectFactory coFactory;
	private Table2DFactory factory;

	@Before
	public void setUp() throws Exception {
		TextureDict fakeDict = new TextureDict();
		coFactory =new CombactObjectFactory(fakeDict);
		
		factory = new Table2DFactory(objectsInRow);
		factory.setCombatObjects(coFactory.createObjects());
		table = factory.createTable2D();
	}

	@Test
	public void whenCreatingANewTable2D_hasMoreThanOneRowAndColumn() {
		assertTrue(table.getRowCount() > 1 );		
	}

	@Test
	public void whenCreatingANewTable2D_hasObjectsInRowIndicated() {
		HorizontalGroup group = table.getGroupInRow(0);
		
		assertThat(group.getChildren().size,is(this.objectsInRow));		
	}

	/* - Settingobservrs has been extranted to another class.
	@Test
	public void whenCreatingANewTable2D_AllObjectsHaveTheObserver() {

		CombatObjectActor coa;
		for (int i = 0; i < table.getRowCount(); i++) {
			coa = table.get(i, 0);
			assertEquals(coa.observers.get(0), observer);
		}
	
	}
	*/

	@Test
	public void givenanExistedEmptyTable_thenThatTableIsFilled() {
		Table2D original = table;
		table = factory.createTable2D(coFactory.createObjects(), table);
		
		assertEquals(original, table);
		
	}
	
	@Test
	public void givenanNotEmptyTable_thenTabletHasRightObjectNumber() {
		Table2D original = factory.createTable2D();
		
		table = factory.createTable2D(coFactory.createObjects(), table);
		
		assertThat(table.countElements(), is(original.countElements()));
		
	}
	
	@Test
	public void givenANewListOfObjects_thenTableCointainsThatObjects() {
		this.factory.setCombatObjects(CombatObjectActorFactory.createListWith_2_Objects());
		
		table= factory.createTable2D(table);
		
		assertThat(table.countElements(), is(CombatObjectActorFactory.createListWith_2_Objects().size()));
		
	}
	
	@Test
	public void objectsAreResetBeforeEnteringTheTabled() {
		List<CombatObjectActor> l = CombatObjectActorFactory.createListWith_2_Objects();
		CombatObjectActor spy01 = spy(l.get(0));
		CombatObjectActor spy02 = spy(l.get(1));
		
		this.factory.setCombatObjects(Arrays.asList(spy01, spy02));

		
		table= factory.createTable2D(table);
		
		verify(spy01).reset();
		verify(spy02).reset();
	}
}
