package model;

import static org.junit.Assert.*;
import org.junit.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DocumentTest {

	@Test
	public void testSave() {
		String path = new File ("").getAbsolutePath();
		Document testDoc = new Document("Aris", "today", "book", "1", "lalalahhhhh", "filename");
		testDoc.save();
		Path tempPath = Paths.get(path + "\\tex_documents", "filename_1_author.txt");
		assertTrue(Files.exists(tempPath));
	}

	@Test
	public void testEditContent() {
		Document testDoc = new Document("Aris", "today", "book", "1", " ", "filename");
		testDoc.editContent("new text");
		assertEquals(testDoc.getContents(), "new text");
	}
	

	@Test
	public void testLoad() {
		Document testDoc = new Document("Aris", "today", "book", "1", "lalalahhhhh", "filename");
		testDoc.save();
		Document testLoadDoc = new Document("Aris", "today", "", "1", null, "filename");
		testLoadDoc.load();
		assertEquals(testLoadDoc.getContents(), "lalalahhhhh");
	}

}
