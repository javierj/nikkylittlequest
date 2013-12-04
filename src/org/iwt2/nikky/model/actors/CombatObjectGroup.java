package org.iwt2.nikky.model.actors;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.util.TimeAlert;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Deprecated. Now using Table2D.
 * 
 * @author Javier
 *
 */
public class CombatObjectGroup extends Group {

	public static  float SPACEBETWEENOBJECTS = 5f;

	TimeAlert alertTick;
	float pace;
	
	public CombatObjectGroup() {
		super();
		this.pace = SPACEBETWEENOBJECTS + NikkyConstants.COMBATOBJECTWIDTH;
	}
	
	/**
	 * Changes the X and Y of the object to set it to the groups
	 * @param object
	 */
	public void addCombatObject(CombatObjectActor object) {
		int objects = this.getChildren().size;
		float x = this.getX() + (this.pace * objects);
		object.setPosition(x, this.getY());
		this.addActor(object);
		
	}

	public void setTimeAlert(float time) {
		alertTick = new TimeAlert(time);
		
	}
	
	
	public void tick() {
		CombatObjectActor object;
		for(Actor actor: this.getChildren()) {
			actor.setX(actor.getX() - this.pace);
		}
	}

	/**
	 * Improvement: subscriptos fortimealert
	 */
	@Override
	public void act(float delta) {
		
		if(this.alertTick == null) {
			System.err.println("CombatObjectGroup::act - alertTick is null. you must call setTime() first");
		}
		
		this.alertTick.act(delta);
		if (this.alertTick.expires()) {
			this.tick();
		}
	}
}
