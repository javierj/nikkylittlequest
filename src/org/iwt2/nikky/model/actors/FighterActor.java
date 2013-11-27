package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class FighterActor extends Image {

	 int hp;

	public FighterActor(int hp) {
		this.hp = hp;
	}

	public FighterActor(Texture text, int hp) {
		super(text);
		this.hp= hp;
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
