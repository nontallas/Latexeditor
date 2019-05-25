package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import model.VersionsManager;
import model.VolatileVersionsStrategy;

class ControlVersionsManagementCommandTest {

	@Test
	void testExecute() {
		VolatileVersionsStrategy volS = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, volS);
		Document curDoc = new Document("", "", "", "1", "", "");
		ControlVersionsManagementCommand cvm = new ControlVersionsManagementCommand(volS, vm, "disable", curDoc);
		boolean test = false;
		cvm.execute();
		assertEquals(test, vm.isEnabled());
		
	}

}
