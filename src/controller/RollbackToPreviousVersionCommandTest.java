package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import model.VersionsManager;
import model.VolatileVersionsStrategy;

class RollbackToPreviousVersionCommandTest {

	@Test
	void testExecute() {
		VolatileVersionsStrategy volS = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, volS);
		vm.enable();
		Document curDoc = new Document("", "", "", "1", "lalala", "testDoc");
		String previousID = curDoc.getVersionID();
		vm.setCurrentVersion(curDoc);
		curDoc.setContents("lololo");
		RollbackToPreviousVersionCommand rb = new RollbackToPreviousVersionCommand(vm, curDoc);
		rb.execute();
		assertEquals(previousID, curDoc.getVersionID());
	}

}
