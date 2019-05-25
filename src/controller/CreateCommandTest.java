package controller;

import static org.junit.Assert.*;
import model.Document;
import org.junit.Test;

public class CreateCommandTest {

	@Test
	public void testExecute() {
		CreateCommand command = new CreateCommand("empty", "filename");
		Document curDoc = new Document("", "", "", "", "","");
		command.execute();
		curDoc = command.getCurrentDoc();
		assertEquals(curDoc.getAuthor(), "thEANamed");
	}

}
