package org.iwt2.nikky.model.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class Table2D 
extends VerticalGroup
{

	int rowNumber;
	
	public Table2D(int columns) {
		this.rowNumber = columns;
		this.addActor(new HorizontalGroup());
	}

	
	public Table2D() {
		this(Integer.MAX_VALUE);
	}


	/**
	 * Warning, you vanot addmore than the same object obce.
	 * @param combatObjectActor
	 */
	public void add(CombatObjectActor combatObjectActor) {	
		addInTable(combatObjectActor);
	}
	
	public void add(HeartImage clone) {
		addInTable(clone);
	}


	private void addInTable(Actor actor) {
		HorizontalGroup group = getLastGroup();
		if (group.getChildren().size >= this.rowNumber) {
			group = new HorizontalGroup();
			this.addActorAt(this.getChildren().size, group);
		}
		
		group.addActor(actor);

	}
	
	private HorizontalGroup getLastGroup() {
		return (HorizontalGroup)this.getChildren().get(this.getChildren().size-1);
	}

	
	
	public CombatObjectActor get(int row, int column) {
		HorizontalGroup group = (HorizontalGroup)this.getChildren().get(row);
		CombatObjectActor object = (CombatObjectActor) group.getChildren().get(column);
		return object;
	}

	/**
	 * When changing the spacing of the table, the space of the verticalgroup
	 * and horizontalgroups changestoo.
	 * 
	 * Untested method. 
	 * No way to access to the spacing information.
	 */
	@Override
	public void setSpacing(float space) {
		super.setSpacing(space);
		HorizontalGroup hGroup;
		for (Actor actor: this.getChildren()) {
			hGroup = (HorizontalGroup) actor;
			hGroup.setSpacing(space);
		}
	}

	/**
	 * Improve stestability
	 * @return
	 */
	public Integer getRowCount() {
		return this.getChildren().size;
	}

	/**
	 * Improve stestability
	 * @return
	 */
	public HorizontalGroup getGroupInRow(int i) {
		return (HorizontalGroup)this.getChildren().get(i);
	}
	
	/**
	 * Improve stestability
	 * @return
	 */
	public int columnLimit() {
		return this.rowNumber;
	}

	/**
	 * @return number of actors in the table.
	 */
	public Integer countElements() {
		int count = 0;
		HorizontalGroup group;
		
		for (int i = 0; i < this.getRowCount(); i++) {
			group = this.getGroupInRow(i);
			count += group.getChildren().size;
		}
		
		return count;
	}


	/**
	 * Removes all combat objects in table, but doe snot remove
	 * the horizontal groups in the vertical groups.
	 */
	public void clearObjects() {
		HorizontalGroup group;
		for(int i = 0; i < this.getChildren().size; i++) {
			group = this.getGroupInRow(i);
			group.clearChildren();
		}
		
	}



}
