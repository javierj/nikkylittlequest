package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.nikky.util.TimeAlert;
import org.junit.Before;
import org.junit.Test;

public class TestEnemyActor {

	int hitPoints = 20;
	EnemyActor enemy;
	
	@Before
	public void setUp() throws Exception {
		enemy = new EnemyActor(hitPoints);
	}

	@Test
	public void aNewEnemyActorHasHP() {
		assertThat(enemy.getHP(), equalTo(hitPoints));
	}
	
	
	@Test
	public void whenUpdatingAnEnemyActor__TimeAlertIsUpdatedYet() {
		SpyTimeAlert alert = new SpyTimeAlert(5);
		enemy.setAttackTimeAlert(alert);
		
		enemy.act(1f);
		
		assertThat(alert.timeCalled, equalTo(1f));
	}
	
	
	// --- Spies --------------------------------------------------
	
	class SpyTimeAlert extends TimeAlert {
		public SpyTimeAlert(long l) {
			super(l);
			// TODO Auto-generated constructor stub
		}

		public float timeCalled = 0;

		@Override
		public void act(float delta) {
			this.timeCalled = delta;
		}
		
	};

}
