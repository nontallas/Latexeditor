package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class ChangeVersionsStrategyCommandTest {

	@Test
	void testExecute() {
		VersionsStrategy vs = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, vs);
		ChangeVersionsStrategyCommand com = new ChangeVersionsStrategyCommand(vs, vm, "stable");
		com.execute();
		assertTrue(vm.getVersionsStrategy() instanceof StableVersionsStrategy);
	}

}
