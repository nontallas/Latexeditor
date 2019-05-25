package controller;

import static org.junit.Assert.*;
import model.Document;
import org.junit.Test;

public class LatexEditorControllerTest {

	@Test
	public void testEnactIf() {
		LatexEditorController texController = new LatexEditorController();
		texController.enact("empty");
		assertNotNull(texController.getCreateCommand());
	}

	@Test
	public void testEnactElse() {
		Document curDoc = new Document("", "", "", "", "","");
		LatexEditorController texController = new LatexEditorController(curDoc);
		texController.enact("chapter");
		assertNotNull(texController.getCommand());
		
	}
}
