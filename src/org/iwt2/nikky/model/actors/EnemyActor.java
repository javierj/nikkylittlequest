package org.iwt2.nikky.model.actors;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.base.Weakness;
import org.iwt2.nikky.model.base.WeaknessToBlue;
import org.iwt2.nikky.util.TimeAlert;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class EnemyActor extends FighterActor {

	private TimeAlert attackTimeAlert;
	List<Weakness> weakness;

	public EnemyActor(int hp) {
		super(hp);
		this.weakness = new ArrayList<Weakness>();
	}

	public EnemyActor(Texture text, int hp) {
		super(text, hp);
		this.weakness = new ArrayList<Weakness>();
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
	/*
	public void setTexture(Texture texture) {
		
		setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
		this.scaling = Scaling.stretch;
		this.align = Align.center;
		setWidth(getPrefWidth());
		setHeight(getPrefHeight());
	}
*/

	public void addWeakness(Weakness weakness) {
		this.weakness.add(weakness);
		
	}

	public void hittedBy(CombatObject co) {
		for(Weakness w: this.weakness) {
			if (w.isWeakTo(co)) {
				this.hp--;
				return;
			}
		}
		
	}
}
