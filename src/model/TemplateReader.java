package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TemplateReader {

	public TemplateReader() {
		super();
	}
	
	public String readTemplate(String docType) {
		String path = new File ("").getAbsolutePath();
		Path tempPath = Paths.get(path + "\\tex_templates", docType + "-template.tex");
		
		try {
			String tempContents = new String(Files.readAllBytes(tempPath), StandardCharsets.UTF_8);
			return tempContents;
		}
		catch (IOException e) {
			System.out.println(e);
			return null;
		}
	}
	
}
