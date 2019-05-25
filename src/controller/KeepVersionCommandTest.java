package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class KeepVersionCommandTest {

	@Test
	void testExecute() {
		VolatileVersionsStrategy vs = new VolatileVersionsStrategy();
		VersionsManager vm = new VersionsManager(true, vs);
		Document curDoc = new Document("", "", "", "1", "", ""); 
		KeepVersionCommand com = new KeepVersionCommand(vm, curDoc);
		com.execute();
		assertEquals(curDoc.getVersionID(), "2");
	}

}
