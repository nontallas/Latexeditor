package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VolatileVersionsStrategyTest {

	@Test
	void testPutVersion() {
		Document curDoc = new Document("", "", "", "1", "lalala", "testDoc");
		VolatileVersionsStrategy volS = new VolatileVersionsStrategy();
		String expectedID = "2";
		volS.putVersion(curDoc);
		assertEquals(expectedID, curDoc.getVersionID());
	}

}
