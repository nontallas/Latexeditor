package controller;

import model.Document;

public class SaveCommand implements Command {
	private Document currentDoc;

	public SaveCommand(Document currentDoc) {
		super();
		this.currentDoc = currentDoc;
	}

	@Override
	public void execute() {
		currentDoc.save();

	}
}
