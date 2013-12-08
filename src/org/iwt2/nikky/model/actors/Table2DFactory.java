package org.iwt2.nikky.model.actors;

import java.util.List;

import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.process.ObjectObserver;
import org.iwt2.nikky.util.CombactObjectFactory;
import org.iwt2.nikky.view.TextureDict;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * This factory is still a fake.
 * 
 * @author Javier
 *
 */
public class Table2DFactory {

	private int objectsInRow;
	private List<CombatObjectActor> objects;

	public Table2DFactory(int objectsInRow) {
		this.objectsInRow = objectsInRow;
	}

	/**
	 * Will be private.
	 * 
	 * @param objects
	 * @param table
	 * @return
	 */
	public Table2D createTable2D(List<CombatObjectActor> objects,
			Table2D table) 
	{

		table.clearObjects();
		for (CombatObjectActor object: objects) {
			object.reset();
			table.add(object);
		}
		
		
		return table;
	}

	
	public Table2D  createTable2D() {
		if (this.objects == null) {
			System.out.println("Table2DFactory::createTable2D() - No object list. Call setObjects first");
		}
		
		Table2D table = new Table2D(this.objectsInRow);
		table.setSpacing(10f);
		
		return this.createTable2D(objects, table);
	}

	public void setCombatObjects(
			List<CombatObjectActor> objects) 
	{
		this.objects = objects;
		
	}

	public Table2D createTable2D(Table2D table) {
		if (this.objects == null) {
			System.out.println("Table2DFactory::createTable2D() - No object list. Call setObjects first");
		}
		return this.createTable2D(this.objects, table);
	}



	
}
