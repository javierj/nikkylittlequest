package org.iwt2.nikky.model.actors;



import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.process.ObjectObserver;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CombatObjectActor 
extends Image
implements CombatObject
{
	private String color = "NoColor";
	private boolean food = false;
	
	boolean inactive;
	ObjectObserver observer;

	
	class Clicks extends ClickListener {
		public void clicked (InputEvent event, float x, float y) {
			//System.out.println("CobatObjectActor::Click::clicked - Clicked on " + CombatObjectActor.this.getName());
			CombatObjectActor.this.click();
		}
	}
	
	public CombatObjectActor() {
		super();
		init();
	}

	private void init() {
		this.addListener(new Clicks());
		inactive = false;
	}
	
	public CombatObjectActor(Texture texture) {
		super(texture);
		init();
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

	
	public void click() {
		System.out.println("CobatObjectActor::click - Clicked on " + this.getName());
		if (this.inactive) {
			return ;
		}
		this.addAction(Actions.fadeOut(1.0f));
		this.inactive = true;
		if (this.observer == null) {
			System.err.println("CombarObjectActor::click() - observer is null,no notification of theclick");
		} else {
			this.observer.clickInObject(this);
		}
	}

	public void setObserver(ObjectObserver observer) {
		this.observer = observer;
		
	}



}
