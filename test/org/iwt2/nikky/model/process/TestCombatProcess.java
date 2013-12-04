package org.iwt2.nikky.model.process;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.iwt2.nikky.model.actors.EnemyActor;
import org.iwt2.nikky.model.actors.FighterActor;
import org.iwt2.nikky.model.actors.NikkiActor;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.util.TimeAlert;
import org.junit.Before;
import org.junit.Test;


public class TestCombatProcess {

	private int hitPoints = 20;
	private float timeToHitNikky = 0.9f;
	private float deltaThatHitsNikky = this.timeToHitNikky + 0.1f;
	private float deltaThatDoesNotHitNikky = this.timeToHitNikky - 0.1f;
	
	NikkiActor nikky;
	EnemyActor enemy;
	TimeAlert alert;
	CombatProcess process;
	
	@Before
	public void setUp() throws Exception {
		nikky = new NikkiActor(hitPoints);
		enemy = new EnemyActor(hitPoints);
		alert = new TimeAlert(timeToHitNikky );
		enemy.setAttackTimeAlert(alert);
		process = new CombatProcess(nikky, enemy);
	}

	@Test
	public void whenEnemyHits_NikkyLosesOneHP() {
		
		process.act(this.deltaThatHitsNikky);
		
		assertThat(nikky.getHP(), is(this.hitPoints-1));
	}

	@Test
	public void whenEnemyDoesNotHit_NikkyDesNotLoseAnyHP() {
		process.act(this.deltaThatDoesNotHitNikky);
		
		assertThat(nikky.getHP(), is(this.hitPoints));
	}

	@Test
	public void whenNikkyIsDeath_and_EnemyHits_NikkyHPIs_0_() {
		nikky = new NikkiActor(0);
		process = new CombatProcess(nikky, enemy);
		
		process.act(this.deltaThatHitsNikky);
		
		assertThat(nikky.getHP(), is(0));
	}
	
	
	@Test
	public void whenPlayerSelectsAnObject_ThatEnemyReceivesTheObject() {
		FakeEnemy fakeenemy = new FakeEnemy();
		process.setEnemy(fakeenemy);
		
		CombatObject co = mock(CombatObject.class);
		
		process.clickInObject(co);
		
		assertTrue(fakeenemy.called_hittedBy);
	}

	//------------------
	
	class FakeEnemy extends EnemyActor {
		
		boolean called_hittedBy;

		public FakeEnemy() {
			super(30);
		}
		
		@Override
		public void hittedBy(CombatObject co) {
			this.called_hittedBy = true;
		}
	}
	
}
