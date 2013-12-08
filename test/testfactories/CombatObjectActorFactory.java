package testfactories;

import java.util.Arrays;
import java.util.List;

import org.iwt2.nikky.model.actors.CombatObjectActor;
import org.iwt2.nikky.model.process.ObjectObserver;

public class CombatObjectActorFactory {

	public static CombatObjectActor createCombatObjectActor() {
		return new CombatObjectActor();
	}

	public static List<CombatObjectActor> createListWith_2_Objects() {
		
		return Arrays.asList(createCombatObjectActor(), createCombatObjectActor());
	}
	
}
