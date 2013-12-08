package org.iwt2.nikky.model.process;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.actors.Table2D;
import org.iwt2.nikky.model.actors.Table2DFactory;
import org.junit.Before;
import org.junit.Test;

import testfactories.CombatObjectActorFactory;

public class TestRefillTableProcess {

	private CombatObjectActor co;
	private RefillTableProcess spyRefillProcess;
	private Table2D table;

	@Before
	public void setUp() throws Exception {
		table = new Table2D();
		co =new CombatObjectActor();
		table.add(co);
		
		spyRefillProcess = spy(new RefillTableProcess(table));
		
		co.addObserver(spyRefillProcess);
	}

	
	@Test
	public void whenAnObjexctIsClicked_RefillProcessIsNotified() {
		co.click();
		
		verify(spyRefillProcess ).clickInObject(co );
	}

	@Test
	public void whenLastIsClicked_RefillMethodIsCalled() {
		
		co.click();
		
		verify(spyRefillProcess ).refillTable();
	}

	@Test
	public void whenObjectIsClicked_andOtherObjectsRemainsInTable_RefillMethodIsNOTCalled() {
		Table2D table = new Table2D();
		CombatObjectActor co2 =new CombatObjectActor();
		
		table.add(co);
		table.add(co2);
		
		spyRefillProcess = spy(new RefillTableProcess(table));
		
		co.addObserver(spyRefillProcess);
		co2.addObserver(spyRefillProcess);
		
		co.click();
		
		verify(spyRefillProcess, never() ).refillTable() ;
	}
	
	
	@Test
	public void whenTableIsRefilled_FirstAllElementsAreErased() {
		assertThat(table.countElements(), is(1));
		
		this.spyRefillProcess.refillTable();
		
		assertThat(table.countElements(), is(0));
	}
	
	
	@Test
	public void whenTableIsRefilled_Table2DFactoryIsCalledWithThatTable() {
		Table2DFactory spyFactory = spy(new Table2DFactory(0));
		spyFactory.setCombatObjects(CombatObjectActorFactory.createEmptyList());
		
		this.spyRefillProcess.setTable2DFactory(spyFactory);
		
		this.spyRefillProcess.refillTable();
		
		verify(spyFactory).createTable2D(table);
	}

}
