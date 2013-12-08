package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.CoreMatchers;
import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.process.ObjectObserver;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;



public class TestCombatObjectActor {

	CombatObject bco;
	CombatObjectActor bcoActor;
	
	@Before
	public void setUp() throws Exception {
		bcoActor = new CombatObjectActor();
		bco= bcoActor;
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
	
	//--- clicks and events
	
	@Test 
	public void testNewObjectHas_1_Listener() {
		assertThat(this.bcoActor.getListeners().size,is(1));
	}
	
	
	@Test
	public void whenClick_clickMethodOnmObjectIsCalled() {
		
		FakeObject fakeobject = new FakeObject();
		ClickListener listener = (ClickListener) fakeobject.getListeners().get(0);
		
		listener.clicked(null, 0f, 0f);
		
		assertTrue(fakeobject .clickCalled);
	}
	
	
	class FakeObject extends CombatObjectActor {
		FakeObject() {super();}
		boolean clickCalled = false;
		
		@Override
		public void click() {
			this.clickCalled = true;
		}
		
	}

	/**
	 * This test is not good.
	 * I'mnot testing that the object is a fadeout
	 * Is there are other diferent actions in the object this will fail
	 */
	@Test
	public void whenClick_AFadeOutActionIsAddedToObject() {
		
		ClickListener listener = (ClickListener) this.bcoActor.getListeners().get(0);
		
		listener.clicked(null, 0f, 0f);
		
		assertThat(this.bcoActor.getActions().size, is(1));
	}
	
	@Test
	public void afterClickOnce_ObjectIsDesactivated() {
		
		ClickListener listener = (ClickListener) this.bcoActor.getListeners().get(0);
		
		listener.clicked(null, 0f, 0f);
		listener.clicked(null, 0f, 0f);
		listener.clicked(null, 0f, 0f);
		
		assertThat(this.bcoActor.getActions().size, is(1));
	}

	
	@Test
	public void whenClick_TheObjectObservableIsNotiffied() {
		
		ObjectObserver observer = mock(ObjectObserver.class);
		this.bcoActor.addObserver(observer);
		
		ClickListener listener = (ClickListener) this.bcoActor.getListeners().get(0);
		
		listener.clicked(null, 0f, 0f);
		
		verify(observer).clickInObject(this.bco);
	}

	
	@Test
	public void givenTwoObservables_whenClick_allObservablesAreNotiffied() {
		
		ObjectObserver observer01 = mock(ObjectObserver.class);
		ObjectObserver observer02 = mock(ObjectObserver.class);

		this.bcoActor.addObserver(observer01);
		this.bcoActor.addObserver(observer02);
		
		ClickListener listener = (ClickListener) this.bcoActor.getListeners().get(0);
		
		listener.clicked(null, 0f, 0f);
		
		verify(observer01).clickInObject(this.bco);
		verify(observer02).clickInObject(this.bco);
	}
	
	@Test
	public void whenReset_ObjectIsReady() {
		
		bcoActor.click();
		bcoActor.act(10f);
		
		bcoActor.reset();
		
		assertFalse(bcoActor.inactive);
		assertEquals(bcoActor.getColor().a, 1.0f, 0.1f);

	}

}
