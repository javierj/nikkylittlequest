package org.iwt2.nikky.model.stages;

import org.iwt2.nikky.NikkyConstants;
import org.iwt2.nikky.model.actors.NikkiActor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CombatStage extends Stage {

	/**
	 * Si no indico el tamaño del stage, la clase llama a Gdx.graphics y salta
	 * un puntero a nulo.
	 */
	public CombatStage(NikkiActor nikki, Batch batch) {
		super(NikkyConstants.WEIGHT, NikkyConstants.HEIGHT, true, batch );
		this.addActor(nikki);
	}


}
