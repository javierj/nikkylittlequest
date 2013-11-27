package org.iwt2.nikky.view;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class TextureDict {
	
	Map<String, String> loadQueue = new HashMap<String, String>();
	Map<String, Texture> textures;
	String path = "graphics/";

	public void addTexture(String name, String file) {
		this.loadQueue.put(name, file);
	}
	
	
	public void load() {
		this.textures = new HashMap<String, Texture>();
		for(Map.Entry<String, String> filename: this.loadQueue.entrySet()) {
			this.textures.put(filename.getKey(),
					newTextureFrom(Gdx.files.internal(path + filename.getValue())));
			//new Sprite(new Texture(Gdx.files.internal("data/block01.png")))
			
		}
	}
	
	Texture newTextureFrom(FileHandle internal) {
		return new Texture(internal);
	}


	public Texture getTexture(String name) {
		if (this.textures == null) {
			System.err.println("TextureDict::getTexture - No load() called before.");
			return null;
		}
		Texture t = this.textures.get(name);
		if (t ==null) {
			System.err.println("TextureDict::getTecture - " + name + " has no texture.");
		}
		return t;
	}
}
