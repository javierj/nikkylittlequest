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
	
	/**
	 * Testing purpouses, no real code
	 */
	@Override
	public void draw(Batch batch, float parentAlpha) {
		System.out.println("Nikky:Draw() Called");
		super.draw(batch, parentAlpha);
	/*	batch.draw(
				((TextureRegionDrawable)this.getDrawable())
					.getRegion(), 10f, 10f);
	*/
	}
}
