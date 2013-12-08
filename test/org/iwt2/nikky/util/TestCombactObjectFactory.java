package org.iwt2.nikky.util;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import static org.mockito.Mockito.*;
import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.view.TextureDict;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.Texture;

public class TestCombactObjectFactory {

	private CombactObjectFactory coFactory;
	private TextureDict fakeDict;
	List<CombatObjectActor> objects;

	@Before
	public void setUp() throws Exception {
		fakeDict = spy(new TextureDict());
		coFactory = new CombactObjectFactory(fakeDict);
		objects = coFactory.createObjects();
	}

	@Test
	public void firstObjectIs_Carrot() {
		assertThat(objects.get(0).getName(), is("Carrot"));
		assertTrue(objects.get(0).isColor(NikkyConstants.COLORORANGE ));
		assertTrue(objects.get(0).isFood());
		
	}

	@Test
	public void secondObjectIs_Apple() {
		assertThat(objects.get(1).getName(), is("Apple"));
		assertTrue(objects.get(1).isColor(NikkyConstants.COLORRED));
		assertTrue(objects.get(1).isFood());
		
	}

	@Test
	public void thirdObjectIs_Banana() {
		assertThat(objects.get(2).getName(), is("Banana"));
		assertTrue(objects.get(2).isColor(NikkyConstants.COLORYELLOW));
		assertTrue(objects.get(2).isFood());
		
	}
	
	@Test
	public void whenCreatingCarrot_TextureCarrotIsSearchedInDict() {
		verify(fakeDict).getTexture("carrot");
	}

}
