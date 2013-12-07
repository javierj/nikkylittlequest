package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.base.WeaknessToBlue;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.base.WeaknessToFood;
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
		//SpyTimeAlert alert = new SpyTimeAlert(5);
		TimeAlert alert = new TimeAlert(5);
		TimeAlert spyalert = spy(alert);
		
		
		enemy.setAttackTimeAlert(spyalert);
		
		enemy.act(1f);
		
		//assertThat(alert.timeCalled, equalTo(1f));
		verify(spyalert).act(1f);
	}
	
	/**
	 * Warning !!
	 * This test must not know how to create blue objects.
	 */
	@Test
	public void whenAEnemyActorHasWeaknessForBlueObjects_AndGetsABlueObject_LosesOneHP() {
		
		this.enemy.addWeakness(new WeaknessToBlue());
		CombatObject blueObject = mock(CombatObject.class);
		when(blueObject.isColor(NikkyConstants.COLORBLUE)).thenReturn(true);
		
		this.enemy.hittedBy(blueObject);
		
		assertThat(this.enemy.getHP(), is(this.hitPoints -1));
	}

	/**
	 * Warning !!
	 * This test must not know how to create blue objects.
	 * 
	 * This is nor a good test, it may fail by EnemyActor or Weakness or CombactObject
	 */
	@Test
	public void whenAEnemyActorHasWeaknessForBlueObjects_AndGetsANotBlueObject_HPRemainsTheSame() {
		
		this.enemy.addWeakness(new WeaknessToBlue());
		CombatObject yellowObject = mock(CombatObject.class);
		when(yellowObject.isColor(NikkyConstants.COLORYELLOW)).thenReturn(true);
		
		this.enemy.hittedBy(yellowObject);
		
		assertThat(this.enemy.hp, is(this.hitPoints));
	}

	
	@Test
	public void whenAEnemyActorHasWeaknessForBlueObjectsAndFood_AndGetsBlueOrFoodObjects_LosesHP() {
		
		this.enemy.addWeakness(new WeaknessToBlue());
		this.enemy.addWeakness(new WeaknessToFood());
		CombatObject object = mock(CombatObject.class);
		when(object.isColor(NikkyConstants.COLORBLUE)).thenReturn(true);
		
		this.enemy.hittedBy(object);
		
		when(object.isColor(NikkyConstants.COLORBLUE)).thenReturn(false);
		when(object.isFood()).thenReturn(true);

		this.enemy.hittedBy(object);
		
		assertThat(this.enemy.hp, is(this.hitPoints -2));
	}


}
