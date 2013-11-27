package org.iwt2.nikky.model.process;
import org.iwt2.nikky.model.actors.EnemyActor;
import org.iwt2.nikky.model.actors.NikkiActor;


public class CombatProcess {

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

}
