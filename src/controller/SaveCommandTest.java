package controller;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Document;
import org.junit.Test;

public class SaveCommandTest {

	@Test
	public void testExecute() {
		String path = new File ("").getAbsolutePath();
		Document curDoc = new Document("", "", "", "1", "","filename");
		SaveCommand command = new SaveCommand(curDoc);
		command.execute();
		Path tempPath = Paths.get(path + "\\tex_documents", "filename_1_author.txt");
		assertTrue(Files.exists(tempPath));
	}

}
