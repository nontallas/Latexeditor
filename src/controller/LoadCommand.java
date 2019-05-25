package controller;

import model.Document;

public class LoadCommand implements Command {
	private Document loadedDoc;
	// TODO in the factory of the commands we will create an empty document so we can use it to load data from disk
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		loadedDoc.load();
	}
	public LoadCommand(Document loadedDoc, String name) {
		super();
		String [] fields = name.split("_");
		String docName = fields[0];
		String docVersion = fields[1];
		this.loadedDoc = new Document("", "", "", docVersion, "", docName);
	}
	public Document getLoadedDoc() {
		return loadedDoc;
	}
	
}
