package org.iwt2.nikky.model.actors;

import org.iwt2.nikky.util.TimeAlert;

public class EnemyActor extends FighterActor {

	private TimeAlert attackTimeAlert;

	public EnemyActor(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}

	public void setAttackTimeAlert(TimeAlert alert) {
		this.attackTimeAlert = alert;
		
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		this.attackTimeAlert.act(delta);
	}

	public boolean hitNikky() {
		return this.attackTimeAlert.expires();
	}

}
