package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.nikky.NikkyConstants;
import org.junit.Before;
import org.junit.Test;



/**
 * Codeunder test depends of the value of NikkyConstants.COMBATOBJECTWIDTH
 * Ifthis value changes, then al tests will fail.
 * 
 * @author Javier
 *
 */
public class TestCombatObjectGroup {

	private CombatObjectActor object01;
	private CombatObjectGroup group;
	private CombatObjectActor object02;


	@Before
	public void setUp() throws Exception {
		object01 = new CombatObjectActor(); 
		object02 = new CombatObjectActor(); 
		group = new CombatObjectGroup();
		group.setPosition(30f, 100f);
	}

	/**
	 * This test test nothingbut the LibGDXlibrary
	 */
	@Test
	public void a_new_group_has_no_objects() {
		assertThat(group.getChildren().size, is(0));
	}

	@Test
	public void a_new_group_has_space_between_objects() {
		assertNotNull(group.SPACEBETWEENOBJECTS);
	}

	@Test
	public void I_can_add_a_new_combatobject() {
		
		
		group.addCombatObject(object01);
		
		assertThat(group.getChildren().size, is(1));
	}
	

	@Test
	public void when_adding_a_new_combatobject_its_Y_is_the_same_that_group() {
		group.addCombatObject(object01);
		
		assertThat(object01.getY(), is(100f));
	}

	@Test
	public void when_adding_the_first_combatobject_its_X_is_the_same_than_groups() {
		group.addCombatObject(object01);
		
		assertThat(object01.getX(), is(30f));
	}

	@Test
	public void when_adding_the_second_combatobject_its_X_is_the_X_of_the_groups_plus_width_plus_space() {
		
		group.addCombatObject(object01);
		group.addCombatObject(object02);
		
		assertThat(object02.getX(), is(30f + NikkyConstants.COMBATOBJECTWIDTH + CombatObjectGroup.SPACEBETWEENOBJECTS));
	}

	
	@Test
	public void when_tick_Y_for_objects_decrease() {
		CombatObjectGroupFake objectFake = new CombatObjectGroupFake(); 
		objectFake.setTimeAlert(1f);
		
		objectFake.act(1.1f);
		
		assertTrue(objectFake.tickHasBeenCalled);
		
	}

	
	@Test
	public void when_timeAlert_exprires_tick_method_is_called() {
		CombatObjectGroupFake objectFake = new CombatObjectGroupFake(); 
		objectFake.setTimeAlert(1f);
		
		objectFake.act(1.1f);
		
		assertTrue(objectFake.tickHasBeenCalled);
		
	}
	
	
	@Test
	public void when_tick_valuesOfXOfObjects_AreDrecrased() {
		
		group.addCombatObject(object01);
		group.addCombatObject(object02);
		float x01 = object01.getX();
		float x02 = object02.getX();
		
		group.tick();
		
		assertThat(object02.getX(), is(x01));
	}

	
	
	//------------------------------------
	
	class CombatObjectGroupFake extends CombatObjectGroup {
		boolean tickHasBeenCalled = false;

		@Override 
		public void tick() {
			this.tickHasBeenCalled = true;
		}
	}

}
