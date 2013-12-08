package org.iwt2.nikky.model.actors;



import java.util.ArrayList;
import java.util.List;

import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.process.ObjectObserver;

import com.badlogic.gdx.graphics.Color;
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
	List<ObjectObserver> observers;

	
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
		this.observers = new ArrayList<ObjectObserver>();
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
		
		if (this.observers.isEmpty()) {
			System.err.println("CombarObjectActor::click() - observers are empty,no notification of theclick");
		} 
			for(ObjectObserver o: this.observers) {
				o.clickInObject(this);
			}
		
	}

	public void addObserver(ObjectObserver observer) {
		this.observers.add(observer);
		
	}

	/**
	 * For testingonly
	 * @return 
	 */
	public List<ObjectObserver> getObserver() {
		return this.observers;
		
	}

	/**
	 * Set the sate of the object as before receiving a click.
	 */
	public void reset() {
		this.inactive = false;
		Color c = this.getColor();
		c.a = 1.0f;
		this.setColor(c);
		
	}
}
