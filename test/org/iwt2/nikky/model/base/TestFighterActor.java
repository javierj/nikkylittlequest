package org.iwt2.nikky.model.base;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.CoreMatchers;
import org.iwt2.nikky.model.actors.FighterActor;

import org.junit.Before;
import org.junit.Test;


public class TestFighterActor {

	FighterActor fighter;
	
	@Before
	public void setUp() throws Exception {
		fighter = new FighterActor(30);
	}

	@Test
	public void aFighterHasHitPoints() {
		
		assertThat(fighter.getHP(), equalTo(30));
	}

	@Test
	public void whenAFighterIsHitted_HisHPDecreaed() {

		fighter.hitted(5);
		
		assertThat(fighter.getHP(), equalTo(25));
	}

}
