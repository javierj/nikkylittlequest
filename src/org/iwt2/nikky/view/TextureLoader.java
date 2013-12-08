package org.iwt2.nikky.view;

import java.util.ArrayList;
import java.util.List;

public class TextureLoader {

	String[][] characters = {
			{"nikky", "characters/nikky.png"},
			{"enemy01", "characters/enemy01.png"}
	};

	String[][] objects = {
			{"apple", "objects/apple.png"},
			{"carrot", "objects/carrot.png"},
			{"cosmapolitan", "objects/cosmapolitan.jpg"},
			{"banana", "objects/bananas.jpg"},
			{"salad", "objects/salad.jpg"}
	};

	String[][] backgrounds = {
			{"background", "backgrounds/background.jpg"},
			{"house03", "backgrounds/house03.jpg"}
	};
	
	TextureDict dict;

	private List<String> objectNames;

	
	public TextureLoader() {
		dict = new TextureDict();
		objectNames = new ArrayList<String>();
		for(String[] dupla: this.objects) {
			this.objectNames.add(dupla[0]);
		}
		
	}
	
	
	void loadCharacters() {	
		for(String[] dupla: this.characters) {
			this.dict.addTexture(dupla[0], dupla[1]);
		}
		
	}


	void loadObjects() {
		for(String[] dupla: this.objects) {
			this.dict.addTexture(dupla[0], dupla[1]);
		}
		
	}

	void loadBackgrounds() {
		for(String[] dupla: this.backgrounds) {
			this.dict.addTexture(dupla[0], dupla[1]);
		}
		
	}

	
	/**
	 * 
	 * @return the dictionary containingall the texturesincluded in this loader.
	 */
	public TextureDict getTextureDictionary() {
		loadCharacters();
		this.loadObjects();
		this.loadBackgrounds();
		dict.load();
		return dict;
	}


	public List<String> getObjectNames() {
		return this.objectNames;
	}



}
