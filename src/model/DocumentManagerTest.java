package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DocumentManagerTest {

	@Test
	public void testCreateEmptyDocument() {
		DocumentManager testDocMan = new DocumentManager("filename");
		Document emptyDoc = testDocMan.createEmptyDocument("empty");
		assertEquals(emptyDoc.getAuthor(), "thEANamed");
		assertEquals(emptyDoc.getDate(), testDocMan.getDate().toString());
	}

	@Test
	public void testCreateArticleDocument() {
		DocumentManager testDocMan = new DocumentManager("filenameArticle");
		Document articleDoc = testDocMan.createArticleDocument("article");
		TemplateReader tmpReader = new TemplateReader();
		assertEquals(articleDoc.getContents(), tmpReader.readTemplate("article"));
	}

	@Test
	public void testCreateBookDocument() {
		DocumentManager testDocMan = new DocumentManager("filenameBook");
		Document bookDoc = testDocMan.createArticleDocument("book");
		TemplateReader tmpReader = new TemplateReader();
		assertEquals(bookDoc.getContents(), tmpReader.readTemplate("book"));
	}

	@Test
	public void testCreateLetterDocument() {
		DocumentManager testDocMan = new DocumentManager("filenameLetter");
		Document letterDoc = testDocMan.createArticleDocument("letter");
		TemplateReader tmpReader = new TemplateReader();
		assertEquals(letterDoc.getContents(), tmpReader.readTemplate("letter"));
	}

	@Test
	public void testCreateReportDocument() {
		DocumentManager testDocMan = new DocumentManager("filenameReport");
		Document reportDoc = testDocMan.createArticleDocument("report");
		TemplateReader tmpReader = new TemplateReader();
		assertEquals(reportDoc.getContents(), tmpReader.readTemplate("report"));
	}

}
