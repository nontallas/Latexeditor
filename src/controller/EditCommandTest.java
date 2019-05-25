package controller;

import static org.junit.Assert.*;
import model.Document;
import org.junit.Test;

public class EditCommandTest {

	@Test
	public void testExecute() {
		Document curDoc = new Document("", "", "", "", "","filename");
		EditCommand command = new EditCommand("lalala", curDoc);
		command.execute();
		assertEquals(curDoc.getContents(), "lalala");
	}

}
