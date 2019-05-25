package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VersionsManagerTest {

	@Test
	void testSetCurrentVersion() {

		VolatileVersionsStrategy volS = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, volS);
		vm.enable();
		Document curDoc = new Document("", "", "", "1", "lalala", "testDoc");
		vm.setCurrentVersion(curDoc);
		assertEquals(curDoc.getContents(), volS.getVersion());
	}

	@Test
	void testGetPreviousVersion() {
		VolatileVersionsStrategy volS = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, volS);
		vm.enable();
		Document curDoc = new Document("", "", "", "1", "lalala", "testDoc");
		String previousContents = curDoc.getContents();
		vm.setCurrentVersion(curDoc);
		curDoc.setContents("lololo");
		assertEquals(previousContents, vm.getPreviousVersion());
	}

	@Test
	void testRollbackToPreviousVersion() {
		VolatileVersionsStrategy volS = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, volS);
		vm.enable();
		Document curDoc = new Document("", "", "", "1", "lalala", "testDoc");
		String previousContents = curDoc.getContents();
		vm.setCurrentVersion(curDoc);
		curDoc.setContents("lololo");
		vm.rollbackToPreviousVersion(curDoc);
		assertEquals(previousContents, curDoc.getContents());
	}

}
