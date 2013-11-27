package org.iwt2.nikky.util;

public class TimeAlert {

	float threshold;
	float count;
	/** Global variable. Not an atttribute */
	boolean b;
	
	public TimeAlert(float l) {
		threshold = l;
		count = 0;
	}


	/**
	 * @param delta
	 * @return True if the threshold time has passed by
	 */
	public void act(float delta) {
		count += delta;
	}


	public boolean expires() {
		b = count > this.threshold;
		if (b) {
			count = 0;
		}
		return b;
	}

}
