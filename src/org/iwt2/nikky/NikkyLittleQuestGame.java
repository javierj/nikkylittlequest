package org.iwt2.nikky;

import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.actors.CombatObjectGroup;
import org.iwt2.nikky.model.actors.EnemyActor;
import org.iwt2.nikky.model.actors.NikkiActor;
import org.iwt2.nikky.model.process.CombatProcess;
import org.iwt2.nikky.model.stages.CombatStage;
import org.iwt2.nikky.util.TimeAlert;
import org.iwt2.nikky.view.TextureDict;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class NikkyLittleQuestGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	CombatProcess process;
	//CombatStage combatStage;
	Stage combatStage;
	private CombatObjectGroup coGroup;
	
	@Override
	public void create() {
		/*
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		*/
		
		//---
		TextureDict textures = new TextureDict();
		textures.addTexture("nikky", "characters/nikky.png");
		textures.addTexture("enemy01", "characters/enemy01.png");
		textures.load();
		
		//---Actors
		
		NikkiActor nikky = new NikkiActor(NikkyConstants.NIKKYHP);
		
		// Tampoco
		nikky.setDrawable(new SpriteDrawable(new Sprite(textures.getTexture("nikky"))));
		nikky.setPosition(10f, 10f);
		
		EnemyActor enemy = new EnemyActor(textures.getTexture("enemy01"), 20);
		TimeAlert alert = new TimeAlert(0.5f );
		enemy.setAttackTimeAlert(alert);
		//enemy.setDrawable(new TextureRegionDrawable(new TextureRegion(textures.getTexture("enemy01"))));
		enemy.setPosition(200f, 200f);
		
		Texture textureObject = textures.getTexture("enemy01");
		Image demo = new Image(textures.getTexture("nikky"));
		demo.setDrawable(new TextureRegionDrawable(new TextureRegion(textureObject)));
		demo.setPosition(0f, 0f);
		
		Image demo2 = new Image(textures.getTexture("nikky"));
		
		//-- Stage
		
		//combatStage = new CombatStage(nikky, new SpriteBatch());
		combatStage = new Stage();
		combatStage.addActor(nikky);
		combatStage.addActor(enemy);
		this.combatStage.addActor(demo);
		
		process = new CombatProcess(nikky, enemy);
		
		// Group & objects
		CombatObjectActor object1 =new CombatObjectActor(textureObject);
		CombatObjectActor object2 =new CombatObjectActor(textureObject);
		CombatObjectActor object3 =new CombatObjectActor(textureObject);
		
		coGroup= new CombatObjectGroup();
		coGroup.addCombatObject(object1);
		coGroup.addCombatObject(object2);
		coGroup.addCombatObject(object3);
		coGroup.setPosition(150f, 150f);
		//System.out.println("Group: " + coGroup.getX() + ", " + coGroup.getY());
		//System.out.println("Demo 30,30expected: " + demo.getX() + ", " + demo.getY());
		
		this.combatStage.addActor(coGroup);
	}

	@Override
	public void dispose() {
		//batch.dispose();
		//texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		/*
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();*/
		this.combatStage.act(Gdx.graphics.getDeltaTime());
		this.combatStage.draw();
		process.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
}
