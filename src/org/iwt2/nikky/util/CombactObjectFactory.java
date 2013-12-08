package org.iwt2.nikky.util;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.view.TextureDict;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * This class contains a hard-coded list of all thw combat objects created
 * this class should be in a JSn or similar file.
 * 
 * @author Javier
 *
 */
public class CombactObjectFactory {

	private TextureDict dict;


	public CombactObjectFactory(TextureDict dict) {
		this.dict = dict;
	}

	public List<CombatObjectActor> createObjects() {
		
		List<CombatObjectActor> objects = new ArrayList<CombatObjectActor>();
		
		objects.add(createCarrod());
		objects.add(createApple());
		objects.add(createBanana());
		objects.add(createSalad());
		
		return objects;
	}

	private CombatObjectActor createCarrod() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Carrot");
		coa.setColor(NikkyConstants.COLORORANGE);
		coa.setFood();
		coa.setDrawable(createDrawable(dict.getTexture("carrot")) );
		
		return coa;
	}

	private CombatObjectActor createApple() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Apple");
		coa.setColor(NikkyConstants.COLORRED);
		coa.setFood();
		coa.setDrawable(createDrawable(dict.getTexture("apple")) );
		
		return coa;
	}
	
	private CombatObjectActor createBanana() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Banana");
		coa.setColor(NikkyConstants.COLORYELLOW);
		coa.setFood();
		coa.setDrawable(createDrawable(dict.getTexture("banana")) );
		
		return coa;
	}
	
	
	private CombatObjectActor createSalad() {
		
		CombatObjectActor coa =new CombatObjectActor();
		
		coa.setName("Salad");
		coa.setColor(NikkyConstants.COLORGREEN);
		coa.setFood();
		coa.setDrawable(createDrawable(dict.getTexture("salad")) );
		
		return coa;
	}
	
	
	/**
	 * Improves testability avoiding erro for null textures.
	 * @param texture
	 * @return
	 */
	private TextureRegionDrawable createDrawable(Texture texture) {
		if (texture == null)
			return null;
		return new TextureRegionDrawable ( new TextureRegion(texture) );
	}
}
