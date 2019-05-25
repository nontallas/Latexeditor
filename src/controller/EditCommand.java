package controller;

import model.Document;

public class EditCommand implements Command {
	private String currentText;
	private Document currentDoc;	
	
	public EditCommand(String currentText, Document currentDoc) {
		super();
		this.currentText = currentText;
		this.currentDoc = currentDoc;
	}

	
	public String getCurrentText() {
		return currentText;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		currentDoc.editContent(currentText);
	}

}
