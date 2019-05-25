package model;

import java.time.LocalDate;

public class DocumentManager {
	private LocalDate date;
	private String name;

	TemplateReader tempReader = new TemplateReader();

	@Override
	public String toString() {
		return "" + date;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}


	public DocumentManager(String name) {
		super();
		this.date = LocalDate.now();
		this.name = name;
	}
	
	public Document createEmptyDocument(String documentType) {
		Document document = new Document("thEANamed", getDate().toString(), "Document copyrights", "1", "", this.name);
		return document;
	}

	public Document createArticleDocument(String documentType) {
		Document document = new Document("thEANamed", getDate().toString(), "Article copyrights", "1", tempReader.readTemplate(documentType), this.name);
		return document;
	}
	
	public Document createBookDocument(String documentType) {
		Document document = new Document("thEANamed", getDate().toString(), "Book copyrights", "1", tempReader.readTemplate(documentType), this.name);
		return document;
	}
	
	public Document createLetterDocument(String documentType) {
		Document document = new Document("thEANamed", getDate().toString(), "Letter copyrights", "1", tempReader.readTemplate(documentType), this.name);
		return document;
	}
	
	public Document createReportDocument(String documentType) {
		Document document = new Document("thEANamed", getDate().toString(), "Report copyrights", "1", tempReader.readTemplate(documentType), this.name);
		return document;
	}
}
