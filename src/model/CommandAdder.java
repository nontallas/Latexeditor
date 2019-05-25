package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandAdder {
	private Document document;
	private String commandType;

	public CommandAdder(Document document, String commandType) {
		super();
		this.document = document;
		this.commandType = commandType;
	}

	public void addCommand() {
		if (document.getCopyright().equals("Letter copyrights")) {
			System.out.println("You can't add this command in a letter.");
		} else if (document.getCopyright().equals("Article copyrights") && this.commandType.equals("chapter")){
			System.out.println("You can't add a chapter in an article");
		} else {
			String tempContents = new String (document.getContents());
			//set doc contents after reading files
			String path = new File (".").getAbsolutePath();
			Path tempPath = Paths.get(path + "\\tex_commands", commandType + ".txt");
			try {
				String command = new String(Files.readAllBytes(tempPath), StandardCharsets.UTF_8);
				tempContents += command;
				document.setContents(tempContents);
			} catch (IOException e){
				System.out.println(e);
			}
		}
	}
}
