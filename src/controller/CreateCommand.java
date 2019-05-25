package controller;

import model.DocumentManager;
import model.Document;

public class CreateCommand implements Command {
	private String name;
	private DocumentManager docManager;
	private String docType;
	private Document currentDoc;
	// TODO add a versionsManager obj as a field
	
	public CreateCommand(String docType, String name) {
		this.docType = docType;
		this.name = name;
		this.docManager = new DocumentManager(this.name);
	}
		
	public String getDocType() {
		return docType;
	}

	public Document getCurrentDoc() {
		return currentDoc;
	}

	@Override
	public void execute() {
		docManager.setDate(docManager.getDate());
		// TODO this code will be removed when prototype pattern is done
		switch (docType) {
			case "book":
				this.currentDoc = docManager.createBookDocument(docType);
				break;
			case "article":
				this.currentDoc = docManager.createArticleDocument(docType);
				break;
			case "letter":
				this.currentDoc = docManager.createLetterDocument(docType);
				break;
			case "report":
				this.currentDoc = docManager.createReportDocument(docType);
				break;
			default :
				this.currentDoc = docManager.createEmptyDocument(docType);
		}
		
	}

}
