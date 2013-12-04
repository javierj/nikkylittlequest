package org.iwt2.nikky.model.process;
import org.iwt2.nikky.model.actors.EnemyActor;
import org.iwt2.nikky.model.actors.NikkiActor;
import org.iwt2.nikky.model.base.CombatObject;


public class CombatProcess 
implements ObjectObserver
{

	private NikkiActor nikky;
	private EnemyActor enemy;

	public CombatProcess(NikkiActor nikky, EnemyActor enemy) {
		this.nikky = nikky;
		this.enemy = enemy;
	}

	public void act(float f) {
		if (this.nikky.isDeath()) {
			System.out.println("CombatProcess:act - Nikky is detah.");
			return;
		}
		
		this.enemy.act(f);
		if (this.enemy.hitNikky()) {
			this.nikky.hitted(1);
		}
	}

	public void setEnemy(EnemyActor enemy) {
		this.enemy = enemy;
		/*
		 * Check if enemy is death.
		 */
	}

	public void clickInObject(CombatObject co) {
		this.enemy.hittedBy(co);
	}

}
