package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers;
import org.iwt2.nikky.view.TextureDict;
import org.iwt2.nikky.model.process.ObjectObserver;
import org.iwt2.nikky.util.CombactObjectFactory;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;

public class TestTable2DFactory {

	private Table2D table;
	private ObjectObserver observer;
	int objectsInRow = 2;

	@Before
	public void setUp() throws Exception {
		TextureDict fakeDict = new TextureDict();
		CombactObjectFactory coFactory =new CombactObjectFactory(fakeDict);
		
		observer = mock(ObjectObserver.class);
		
		Table2DFactory factory = new Table2DFactory(objectsInRow);
		table = factory.createTable2D(coFactory.createObjects(), observer);
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

	@Test
	public void whenCreatingANewTable2D_AllObjectsHaveTheObserver() {

		CombatObjectActor coa;
		for (int i = 0; i < table.getRowCount(); i++) {
			coa = table.get(i, 0);
			assertEquals(coa.observers.get(0), observer);
		}
	
	}


}
