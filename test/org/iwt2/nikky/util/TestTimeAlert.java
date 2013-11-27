package org.iwt2.nikky.util;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestTimeAlert {

	long oneSecond = 1000;
	TimeAlert ta;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenAccumulateTimeIsLessThatLimitTime_timeAlertDoesntExpritae() {
		
		ta = new TimeAlert(oneSecond + oneSecond);
		ta.act(oneSecond);
		assertFalse(ta.expires());
	}

	@Test
	public void whenAccumulateTimeIsEqualsThatLimitTime_timeAlertDoesntExpritae() {
		
		ta = new TimeAlert(oneSecond + oneSecond);
		
		ta.act(oneSecond);
		ta.act(oneSecond);
		assertFalse(ta.expires());
	}

	@Test
	public void whenAccumulateTimeIsBiggerThatLimitTime_timeAlertExpritae() {
		
		ta = new TimeAlert(oneSecond + oneSecond);
		
		ta.act(oneSecond);
		ta.act(oneSecond);
		ta.act(oneSecond);
		assertTrue(ta.expires());
	}

	
	@Test
	public void whenTimealertsExpires_IsReseted() {
		
		ta = new TimeAlert(oneSecond);
		
		ta.act(oneSecond);
		ta.act(oneSecond);
		assertTrue(ta.expires());
		assertFalse(ta.expires());
		
	}

	/**
	 * Safeness test
	 */
	@Test
	public void whenTimealertsExpires_ThreeTimes() {
		
		ta = new TimeAlert(oneSecond);
		
		ta.act(oneSecond);
		ta.act(oneSecond);
		assertTrue(ta.expires());
		
		ta.act(oneSecond);
		ta.act(oneSecond);
		assertTrue(ta.expires());

		ta.act(oneSecond);
		ta.act(oneSecond);
		assertTrue(ta.expires());

	}

}
