package org.iwt2.nikky.model.base;

import org.iwt2.nikky.NikkyConstants;

public class WeaknessToBlue implements Weakness {

	/* (non-Javadoc)
	 * @see org.iwt2.nikky.model.base.Weakness#isWeakTo(org.iwt2.nikky.model.base.CombatObject)
	 */
	@Override
	public boolean isWeakTo(CombatObject co) {
		return co.isColor(NikkyConstants.COLORBLUE);
	}

}
