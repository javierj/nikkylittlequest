package org.iwt2.nikky.view;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TestTextureLoader {

	private TextureLoader loader;
	private FakeTextureDict fakeDict;

	@Before
	public void setUp() throws Exception {
		loader = new TextureLoader();
		fakeDict = new FakeTextureDict();
		loader.dict = fakeDict;
	}

	@Test
	public void textureLoaderHasAListOfTexturesCharacter() {
		assertTrue(loader.characters.length > 1);
		
	}
	
	@Test
	public void whenLoadingCharacterTextures_textureDictIsCalled() {
		
		loader.loadCharacters();
		
		assertThat(fakeDict.add_called, is(loader.characters.length));
		assertThat(fakeDict.name, is("nikky"));
	}

	
	@Test
	public void getTextureDictionary() {
		
		TextureDict textureDict = loader.getTextureDictionary();
		
		assertTrue(fakeDict.load_called);
		assertEquals(fakeDict, textureDict);
		assertThat(fakeDict.add_called, is(loader.characters.length + loader.objects.length + loader.backgrounds.length));
	}

	
	
	@Test
	public void textureLoaderHasAListOfTexturesObjects() {
		assertTrue(loader.objects.length > 2);
		
	}

	@Test
	public void whenLoadingObjectTextures_textureDictIsCalled() {
		
		
		loader.loadObjects();
		
		assertThat(fakeDict.add_called, is(loader.objects.length));
		assertThat(fakeDict.name, is("apple"));
	}

	
	@Test
	public void testListOfObjectNames() {
		List<String> objectNames = this.loader.getObjectNames();
		
		assertTrue(objectNames.size() > 0);
		assertTrue(objectNames.contains("apple"));
	}
	
	// --------------------
	
	class FakeTextureDict extends TextureDict {
		public boolean load_called = false;
		int add_called = 0;
		String name = null;
		String file =null;
		
		@Override
		public void addTexture(String name, String file) {
			if (this.name == null)
				this.name =name;
			if (this.file == null)
				this.file = file;
			
			this.add_called++;
		}
		
		@Override
		public void load() {
			this.load_called = true;
		}
		
	}

}
