package org.iwt2.nikky.model.actors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHeartImage {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void aHeartImageCanBeCloned_ButIsDiferent() {
		HeartImage heart01 =new HeartImage();
		HeartImage heart02 = heart01.clone();
		
		assertNotNull(heart02);
		assertFalse(heart01.equals(heart02));
	}

}
