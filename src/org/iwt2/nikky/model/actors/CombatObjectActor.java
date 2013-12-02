package org.iwt2.nikky.model.actors;



import org.iwt2.nikky.model.base.CombatObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class CombatObjectActor 
extends Image
implements CombatObject
{
	

	private String color = "NoColor";
	private boolean food = false;

	
	public CombatObjectActor() {
		super();
	}
	
	public CombatObjectActor(Texture texture) {
		super(texture);
	}

	/**
	 * Use the color constrants defined in Nikkyconstants.
	 * 
	 * @param colorblue
	 * @return Always returns false
	 */
	public boolean isColor(String color) {
		//System.out.println("My : " + this.color + " == " + color);
		return this.color.equals(color);
	}

	/**
	 * Use the color constrants defined in Nikkyconstants
	 */
	@Override
	public void setColor(String string) {
		this.color  = string;
		
	}

	@Override
	public void setFood() {
		this.food  = true;
	}

	@Override
	public boolean isFood() {
		return this.food;
	}



}
