package org.iwt2.nikky.util;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.view.TextureDict;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.Texture;

public class TestCombactObjectFactory {

	private CombactObjectFactory coFactory;
	private FakeTextureDict fakeDict;

	@Before
	public void setUp() throws Exception {
		fakeDict = new FakeTextureDict();
		coFactory = new CombactObjectFactory(fakeDict);
	}

	@Test
	public void firstObjectIs_Carrot() {
		List<CombatObject> objects = coFactory.createObjects();
		
		assertThat(objects.get(0).getName(), is("Carrot"));
		assertTrue(objects.get(0).isColor(NikkyConstants.COLORORANGE ));
		assertTrue(objects.get(0).isFood());
		
	}

	@Test
	public void secondObjectIs_Apple() {
		List<CombatObject> objects = coFactory.createObjects();
		
		assertThat(objects.get(1).getName(), is("Apple"));
		assertTrue(objects.get(1).isColor(NikkyConstants.COLORRED));
		assertTrue(objects.get(1).isFood());
		
	}

	@Test
	public void thirdObjectIs_Banana() {
		List<CombatObject> objects = coFactory.createObjects();
		
		assertThat(objects.get(2).getName(), is("Banana"));
		assertTrue(objects.get(2).isColor(NikkyConstants.COLORYELLOW));
		assertTrue(objects.get(2).isFood());
		
	}
	
	@Test
	public void whenCreatingCarrot_TextureCarrotIsSearchedInDict() {
		List<CombatObject> objects = coFactory.createObjects();
		
		assertTrue(fakeDict.carrotSearched);
	}

	//----------------
	
	class FakeTextureDict extends TextureDict {

		public boolean carrotSearched = false;
		
		@Override
		public Texture getTexture(String name) {
			if (name.equals("carrot"))
				this.carrotSearched = true;
			return null;
			
		}
		
	}
}
