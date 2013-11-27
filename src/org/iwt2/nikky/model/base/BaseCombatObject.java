package org.iwt2.nikky.model.base;

public class BaseCombatObject implements CombatObject {

	private String color = "NoColor";
	private boolean food = false;

	/**
	 * Use the color constrants defined in Nikkyconstants.
	 * 
	 * @param colorblue
	 * @return Always returns false
	 */
	public boolean isColor(String color) {
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
