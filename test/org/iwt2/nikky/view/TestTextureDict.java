package org.iwt2.nikky.view;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

/**
 * Class Texturedict is hard to test so tets cases are not very accurated
 * 
 * @author Javier
 *
 */
public class TestTextureDict {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenAddingAFile_ANewTextureIsInQueue() {
		TextureDict textures = new TextureDict();
		textures.addTexture("demo", "demo");
		
		assertEquals(1, textures.loadQueue.size());
	}

	
	@Test
	public void whenLoadingOneFile_ANewTextureIsInQueue() {
		Gdx.files = mock(Files.class);
		
		FakeTextureDict textures = new FakeTextureDict();
		textures.addTexture("demo", "demo");
		
		textures.load();
		
		verify(Gdx.files).internal(anyString());
	}
	
	@Test
	public void whenLoadingOneFile_PathIsAdded() {
		Gdx.files = mock(Files.class);
		
		FakeTextureDict textures = new FakeTextureDict();
		textures.addTexture("demo", "demo");
		
		textures.load();
		
		verify(Gdx.files).internal("graphics/demo");
	}

	
	@Test
	public void whenRecoveringATextureWithoutCallingLoadFirst_NullIsReturned() {
		Gdx.files = mock(Files.class);
		
		FakeTextureDict textures = new FakeTextureDict();
		textures.addTexture("demo", "demo");
		
		assertNull(textures.getTexture("demo"));
		
	}

	
	//-------------------------------------------------
	
	class FakeTextureDict extends TextureDict {
		Texture newTextureFrom(FileHandle internal) {
			return null;
		}
	}

}
