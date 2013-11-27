package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.CoreMatchers;
import org.iwt2.nikky.model.actors.FighterActor;

import org.junit.Before;
import org.junit.Test;

/**
 * A fighter Actor is a LibGDX Actor that has hit points
 * @author Javier
 *
 */
public class TestFighterActor {

	FighterActor fighter;
	int hitPoints = 30;
	
	@Before
	public void setUp() throws Exception {
		fighter = new FighterActor(hitPoints);
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

	
	@Test
	public void whenAFicherActorHasMoreHPThanCero_IsNotDeath() {
		assertFalse(fighter.isDeath());
		
	}
	
	@Test
	public void whenAFicherActorHasEqualHPThanCero_IsDeath() {
		fighter.hitted(this.hitPoints);
		assertTrue(fighter.isDeath());
		
	}

}
