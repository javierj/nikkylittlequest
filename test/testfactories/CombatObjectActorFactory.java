package testfactories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.iwt2.nikky.model.actors.CombatObjectActor;

public class CombatObjectActorFactory {

	public static CombatObjectActor createCombatObjectActor() {
		return new CombatObjectActor();
	}

	public static List<CombatObjectActor> createListWith_2_Objects() {
		
		return Arrays.asList(createCombatObjectActor(), createCombatObjectActor());
	}

	public static List<CombatObjectActor> createEmptyList() {
		
		return new ArrayList<CombatObjectActor>();
	}

}
