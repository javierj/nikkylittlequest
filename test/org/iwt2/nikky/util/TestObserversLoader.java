package org.iwt2.nikky.util;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import static org.mockito.Mockito.*;
import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.process.ObjectObserver;
import org.junit.Before;
import org.junit.Test;

import testfactories.CombatObjectActorFactory;

public class TestObserversLoader {

	private CombatObjectActor object;
	private ObserversLoader loader;
	private ObjectObserver dummyListener01;


	@Before
	public void setUp() throws Exception {
		object = CombatObjectActorFactory.createCombatObjectActor();
		loader = new ObserversLoader();
		dummyListener01 = mock(ObjectObserver.class);		

	}

	@Test
	public void givenALoaderWithOneListener_whenDecoratingAnObject_objectHasThatListener() {
		loader.addObserver(dummyListener01);
		
		loader.decorate(object);
		
		assertThat(object.getObserver().size(), is(1));
		assertEquals(object.getObserver().get(0), dummyListener01);
	}

	
	@Test
	public void givenALoaderWithTwoListener_whenDecoratingAnObject_objectHasThoseListener() {

		ObjectObserver dummyListener02 = mock(ObjectObserver.class);
		
		
		loader.addObserver(dummyListener01);		
		loader.addObserver(dummyListener02);
		
		loader.decorate(object);
		
		
		assertThat(object.getObserver().size(), is(2));
		assertEquals(object.getObserver().get(0), dummyListener01);
		assertEquals(object.getObserver().get(1), dummyListener02);
	}

	
	@Test
	public void givenALoaderWithAListener_whenDecoratingAnListOfObjects_objectsHaveTheListener() {

		List<CombatObjectActor> objects = CombatObjectActorFactory.createListWith_2_Objects();
		
		loader.addObserver(dummyListener01);		
		
		loader.decorate(objects);
		
		for (CombatObjectActor object: objects) {
		assertThat(object.getObserver().size(), is(1));
		assertEquals(object.getObserver().get(0), dummyListener01);

		}
	}
}
