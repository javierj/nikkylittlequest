package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class HeartImage 
extends Image 
implements Cloneable
{

	@Override
	public HeartImage clone() {
		try {
			return (HeartImage) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
