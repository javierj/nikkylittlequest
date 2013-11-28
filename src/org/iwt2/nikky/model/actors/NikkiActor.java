package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class NikkiActor extends FighterActor {
	
	public NikkiActor(int hp) {
		super(hp);
	}

	@Override
	public boolean equals(Object o) {
		return true;
	}
	
	@Override
	public void hitted(int damage) {
		System.out.println("Nikkictor:hitted: " + this.hp + " / Test only. Remove in the future.");
		super.hitted(damage);
	}
	
}
