package controller;

import static org.junit.Assert.*;
import model.Document;
import org.junit.Test;

public class CommandsFactoryTest {

	@Test
	public void testCreateCommandCase() {
		CreateCommand createCommandByHand = new CreateCommand("empty", "filename");
		CommandsFactory comFactory = new CommandsFactory();
		CreateCommand createCommandByFactory = (CreateCommand) comFactory.createCommand("empty");
		assertEquals(createCommandByHand.getDocType(), createCommandByFactory.getDocType());
	}
	
	@Test
	public void testCreateCommandDefault() {
		Document curDoc = new Document("", "", "", "", "","");
		EditCommand editCommandByHand = new EditCommand("lalala", curDoc);
		CommandsFactory comFac = new CommandsFactory(curDoc, null, null, "");
		EditCommand editCommandByFactory = (EditCommand) comFac.createCommand("lalala");
		assertEquals(editCommandByHand.getCurrentText(), editCommandByFactory.getCurrentText());
	}

}
