package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class FighterActor extends Image {

	 int hp;
	 Table2D hpTable;

	public FighterActor(int hp) {
		init(hp);
		
	}

	public FighterActor(Texture text, int hp) {
		super(text);
		
		
	}

	private void init(int hp) {
		this.hp= hp;
		hpTable = new Table2D(3);
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
