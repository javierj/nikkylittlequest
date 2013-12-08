package org.iwt2.nikky.model.stages;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.iwt2.nikky.model.actors.NikkiActor;
import org.iwt2.nikky.model.stages.CombatStage;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;


public class TestCombat {


	private CombatStage stage;
	private NikkiActor nikki;


	@Before
	public void setUp() throws Exception {
		Gdx.graphics = mock(Graphics.class);
		nikki = new NikkiActor(10);
		
		Batch dummyBatch =mock(Batch.class);
		stage = new CombatStage(nikki, dummyBatch );

	}

	/**
	 * Si no indico el tamaño del stage, la clase llama a Gdx.graphics y salta
	 * un puntero a nulo.
	 * 
	 * A dummy is an object never used during the test
	 */
	@Test
	public void combatStageHasANikky() {
		assertTrue(stage.getActors().contains(nikki, true));
	}
	
	
	@Test
	public void firstElementInStageIsAGroupForBackground() {
		
		assertTrue(stage.getActors().get(0) instanceof Group);
	}
	
	@Test
	public void aBackgourndelementIsAddedInTheGroup() {
		
		assertThat(stage.backgroundGroup.getChildren().size, is(0));
		
		stage.addBackground(new Actor());
		
		assertThat(stage.backgroundGroup.getChildren().size, is(1));
	}

}
