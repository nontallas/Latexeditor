package model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class CommandAdderTest {

	@Test
	public void testAddCommandArticle() {
		DocumentManager testDocMan = new DocumentManager("filename");
		Document articleDoc = testDocMan.createArticleDocument("article");
		CommandAdder nextCom = new CommandAdder(articleDoc, "chapter");
		String previousConts = articleDoc.getContents();
		nextCom.addCommand();
		assertEquals(articleDoc.getContents(), previousConts);
	}
	
	@Test
	public void testAddCommandLetter() {
		DocumentManager testDocMan1 = new DocumentManager("filename");
		Document letterDoc = testDocMan1.createLetterDocument("letter");
		CommandAdder nextCom = new CommandAdder(letterDoc, "chapter");
		String previousConts = letterDoc.getContents();
		nextCom.addCommand();
		assertEquals(letterDoc.getContents(), previousConts);
	}

	@Test
	public void testCommand() {
		DocumentManager testDocMan2 = new DocumentManager("filename");
		Document reportDoc = testDocMan2.createReportDocument("report");
		CommandAdder nextCom = new CommandAdder(reportDoc, "table");
		String previousConts = reportDoc.getContents();
		nextCom.addCommand();
		assertThat(previousConts, not(equalTo(reportDoc.getContents())));
		System.out.println(reportDoc.getContents());
		System.out.println(previousConts);
	}
}
