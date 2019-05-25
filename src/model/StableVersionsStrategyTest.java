package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class StableVersionsStrategyTest {

	@Test
	void testPutVersion() {
		String path = new File("").getAbsolutePath();
		Document curDoc = new Document("", "", "", "1", "lalala", "testDoc");
		StableVersionsStrategy volS = new StableVersionsStrategy();
		String expectedID = "2";
		volS.putVersion(curDoc);
		Path newPath = Paths.get(path + "\\tex_versions", "testDoc_1_.tex");
		assertEquals(expectedID, curDoc.getVersionID());
		assertTrue(Files.exists(newPath));
	}

}
