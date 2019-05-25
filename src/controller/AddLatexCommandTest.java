package controller;

import static org.junit.Assert.*;
import model.Document;
import org.junit.Test;

public class AddLatexCommandTest {

	@Test
	public void testExecute() {
		Document curDoc = new Document("", "", "", "", "","");
		AddLatexCommand command = new AddLatexCommand("subsubsection", curDoc);
		command.execute();
		String check = "\\subsubsection{}";
		assertEquals(curDoc.getContents(), check);
	}

}
