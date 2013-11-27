package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class FighterActor extends Actor {

	 int hp;

	public FighterActor(int hp) {
		this.hp = hp;
	}

	public int getHP() {
		return this.hp;
	}

	public void hitted(int damage) {
		this.hp -= damage;
	}

	public boolean isDeath() {
		return this.hp <= 0;
	}

}
