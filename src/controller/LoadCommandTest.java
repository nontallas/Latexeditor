package controller;

import static org.junit.Assert.*;
import model.Document;
import org.junit.Test;

public class LoadCommandTest {

	@Test
	public void testExecute() {
		Document curDoc = new Document("", "", "", "", "","filename");
		LoadCommand command = new LoadCommand(curDoc, "filename_1_");
		command.execute();
		assertEquals(command.getLoadedDoc().getContents(), "lalala");
	}

}
