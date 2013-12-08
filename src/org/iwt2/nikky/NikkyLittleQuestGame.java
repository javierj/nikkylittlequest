package org.iwt2.nikky;

import java.util.List;

import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.actors.CombatObjectGroup;
import org.iwt2.nikky.model.actors.EnemyActor;
import org.iwt2.nikky.model.actors.NikkiActor;
import org.iwt2.nikky.model.actors.Table2D;
import org.iwt2.nikky.model.actors.Table2DFactory;
import org.iwt2.nikky.model.base.CombatObject;
import org.iwt2.nikky.model.base.WeaknessToFood;
import org.iwt2.nikky.model.process.CombatProcess;
import org.iwt2.nikky.model.process.RefillTableProcess;
import org.iwt2.nikky.model.stages.CombatStage;
import org.iwt2.nikky.util.CombactObjectFactory;
import org.iwt2.nikky.util.ObserversLoader;
import org.iwt2.nikky.util.TimeAlert;
import org.iwt2.nikky.view.TextureDict;
import org.iwt2.nikky.view.TextureLoader;

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

	
	CombatProcess process;
	CombatStage combatStage;
	//Stage combatStage;
	private CombatObjectGroup coGroup;
	private CombatObjectActor object;
	
	@Override
	public void create() {
		float floorY = 200f;
		
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
		TextureLoader loader = new TextureLoader();
		TextureDict textures = loader.getTextureDictionary();
		
		/*textures.addTexture("nikky", "characters/nikky.png");
		textures.addTexture("enemy01", "characters/enemy01.png");
		textures.load();
		*/
		//---Actors
		
		NikkiActor nikky = new NikkiActor(textures.getTexture("nikky"), NikkyConstants.NIKKYHP);
		
		// Tampoco funciona.Se arreglo en una nighlty building
		/*
		nikky.setDrawable(new SpriteDrawable(new Sprite(textures.getTexture("nikky"))));
		*/
		nikky.setPosition(10f, floorY);
		
		EnemyActor enemy = new EnemyActor(textures.getTexture("enemy01"), 20);
		//TimeAlert alert = ;
		enemy.setAttackTimeAlert(new TimeAlert(8.0f ));
		//enemy.setDrawable(new TextureRegionDrawable(new TextureRegion(textures.getTexture("enemy01"))));
		enemy.setPosition(200f, floorY);
		enemy.addWeakness(new WeaknessToFood());
		
		/*
		Texture textureObject = textures.getTexture("enemy01");
		Image demo = new Image(textures.getTexture("nikky"));
		demo.setDrawable(new TextureRegionDrawable(new TextureRegion(textureObject)));
		demo.setPosition(0f, 0f);
		
		Image demo2 = new Image(textures.getTexture("nikky"));
		*/
		
		//-- Stage
		
		combatStage = new CombatStage(nikky, new SpriteBatch());
		
		/*combatStage = new Stage();
		combatStage.addActor(nikky);
		combatStage.addActor(enemy);*/
		//this.combatStage.addActor(demo);
		Gdx.input.setInputProcessor(this.combatStage);
		
		combatStage.addBackground(new Image(textures.getTexture("background")));
		combatStage.addBackground(new Image(textures.getTexture("house03")));
		
		
		
		// Group & objects
		
		CombactObjectFactory coFactory = new CombactObjectFactory(textures);
		List<CombatObjectActor> combatObjects = coFactory.createObjects();
		
		
		
		/*
		CombatObjectActor object1; // =new CombatObjectActor(textures.getTexture("apple"));
		CombatObjectActor object2; // =new CombatObjectActor(textures.getTexture("carrot"));
		CombatObjectActor object3 ; //=new CombatObjectActor(textures.getTexture("banana"));
		CombatObjectActor object4 =new CombatObjectActor(textures.getTexture("salad"));
		
		List<CombatObject> objects = coFactory.createObjects();
		
		object1 = (CombatObjectActor) objects.get(0);
		object1.setDrawable(new TextureRegionDrawable ( new TextureRegion(textures.getTexture("apple")) ) );
		object1.setObserver(this.process);

		object2 = (CombatObjectActor) objects.get(1);
		object2.setDrawable(new TextureRegionDrawable ( new TextureRegion(textures.getTexture("carrot")) ) );
		object2.setObserver(this.process);
		
		object3 = (CombatObjectActor) objects.get(2);
		object3.setDrawable(new TextureRegionDrawable ( new TextureRegion(textures.getTexture("banana")) ) );
		object3.setObserver(this.process);
		
		//object =new CombatObjectActor(textures.getTexture("apple"));
		//object.setPosition(10f, 100f);
		//this.combatStage.addActor(object);
		*/
		/* -- Deprecated
		coGroup= new CombatObjectGroup();
		coGroup.addCombatObject(object1);
		coGroup.addCombatObject(object2);
		coGroup.addCombatObject(object3);
		coGroup.setPosition(150f, 150f);
		//System.out.println("Group: " + coGroup.getX() + ", " + coGroup.getY());
		//System.out.println("Demo 30,30expected: " + demo.getX() + ", " + demo.getY());
		
		this.combatStage.addActor(coGroup);
		*/
		
		// Tablet
		/*
		Table2D table = new Table2D(2);
		table.setSpacing(10f);
		
		table.add(object1);
		table.add(object2);
		table.add(object3);
		table.add(object4);
		*/
		
		Table2DFactory factory = new Table2DFactory(2);
		factory.setCombatObjects(combatObjects);
		Table2D table = factory.createTable2D();
		table.setPosition(100f, 150f);

		// Observers

		process = new CombatProcess(nikky, enemy);

		RefillTableProcess refill = new RefillTableProcess(table);
		refill.setTable2DFactory(factory);
		
		ObserversLoader decorator = new ObserversLoader();
		decorator.addObserver(process);
		decorator.addObserver(refill);
		
		decorator.decorate(combatObjects );

		this.combatStage.addActor(table);
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
