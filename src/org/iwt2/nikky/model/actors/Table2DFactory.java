package org.iwt2.nikky.model.actors;

import java.util.List;

import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.process.ObjectObserver;
import org.iwt2.nikky.util.CombactObjectFactory;
import org.iwt2.nikky.view.TextureDict;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Table2DFactory {

	private int objectsInRow;

	public Table2DFactory(int objectsInRow) {
		this.objectsInRow = objectsInRow;
	}

	public Table2D createTable2D(List<CombatObject> objects, ObjectObserver observer) {
		
		CombatObjectActor object1; // =new CombatObjectActor(textures.getTexture("apple"));
		CombatObjectActor object2; // =new CombatObjectActor(textures.getTexture("carrot"));
		CombatObjectActor object3 ; //=new CombatObjectActor(textures.getTexture("banana"));
		CombatObjectActor object4; // =new CombatObjectActor(textures.getTexture("salad"));
		
		
		
		object1 = (CombatObjectActor) objects.get(0);
		
		object1.setObserver(observer);

		object2 = (CombatObjectActor) objects.get(1);
		
		object2.setObserver(observer);
		
		object3 = (CombatObjectActor) objects.get(2);
		object3.setObserver(observer);

		object4 = (CombatObjectActor) objects.get(3);
		object4.setObserver(observer);

		Table2D table = new Table2D(this.objectsInRow);
		table.setSpacing(10f);
		
		table.add(object1);
		table.add(object2);
		table.add(object3);
		table.add(object4);
		
		return table;
	}



	
}
