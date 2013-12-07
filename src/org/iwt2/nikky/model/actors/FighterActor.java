package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class FighterActor extends Image {

	 int hp;
	 Table2D hpTable;
	private HeartImage hpImage;

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

	/**
	 * This image will be used to represent the hit points of the actor.
	 * Creates the table when receiving a new igmae
	 * 
	 * 
	 * @param heart Image must be cloneable
	 */
	public void setHPImage(HeartImage heart) {
		this.hpImage = heart;
		
		if (hpTable.countElements() > 0) {
			System.err.println("FighterAcotr::setHPImage() - Warning, hpTable already have elements. Don't call this method twice");
		}
		
		for (int i = 1; i <=hp; i++) {
			hpTable.add(this.hpImage.clone());
		}

	}

}
