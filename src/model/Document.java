package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Document {
	private String author;
	private String date;
	private String copyright;
	private String versionID;
	private String contents;
	private String name;
	
	
	public Document() {
		super();
	}

	public Document(String author, String date, String copyright, String versionID, String contents, String name) {
		super();
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getName() {
		return name;
	}

	public void save() {
		String path = new File ("").getAbsolutePath();
		File authorFile = new File (path + "\\tex_documents\\" + this.name + "_" + this.versionID + "_author.txt");
		File dateFile = new File (path + "\\tex_documents\\" + this.name + "_" + this.versionID + "_date.txt");
		File copyrightFile = new File (path + "\\tex_documents\\" + this.name + "_" + this.versionID + "_copyright.txt");
		File versionIDFile = new File (path + "\\tex_documents\\" + this.name + "_" + this.versionID + "_versionID.txt");
		File contentsFile = new File (path + "\\user_documents\\" + this.name + "_" + this.versionID + "_.tex");
		File nameFile = new File (path + "\\tex_documents\\" + this.name + "_name.txt");
		
		try {
			PrintWriter printWriter = new PrintWriter (authorFile);
			printWriter.print(this.author);
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			PrintWriter printWriter = new PrintWriter (nameFile);
			printWriter.print(this.name);
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			PrintWriter printWriter = new PrintWriter (dateFile);
			printWriter.print(this.date);
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			PrintWriter printWriter = new PrintWriter (copyrightFile);
			printWriter.print(this.copyright);
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			PrintWriter printWriter = new PrintWriter (versionIDFile);
			int id = Integer.parseInt(this.versionID);
			id ++;
			this.versionID = Integer.toString(id);
			
			printWriter.print(this.versionID);
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			PrintWriter printWriter = new PrintWriter (contentsFile);
			printWriter.print(this.contents);
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	//This method is for US2
	public void editContent(String editedInput) {
		setContents(editedInput);
	}
	
	public void load() {
		String path = new File ("").getAbsolutePath();
		Path authorPath = Paths.get(path + "\\tex_documents", this.name + "_" + this.versionID + "_author.txt");
		Path datePath = Paths.get(path + "\\tex_documents", this.name + "_" + this.versionID + "_date.txt");
		Path copyrightPath = Paths.get(path + "\\tex_documents", this.name + "_" + this.versionID + "_copyright.txt");
		Path versionIDPath = Paths.get(path + "\\tex_documents", this.name + "_" + this.versionID + "_versionID.txt");
		Path contentsPath = Paths.get(path + "\\user_documents", this.name + "_" + this.versionID + "_.tex");
		
		try {
			String tempAuthor = new String(Files.readAllBytes(authorPath), StandardCharsets.UTF_8);
			setAuthor(tempAuthor);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			String tempDate = new String(Files.readAllBytes(datePath), StandardCharsets.UTF_8);
			setDate(tempDate);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			String tempCopyright = new String(Files.readAllBytes(copyrightPath), StandardCharsets.UTF_8);
			setCopyright(tempCopyright);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			String tempVersionID = new String(Files.readAllBytes(versionIDPath), StandardCharsets.UTF_8);
			setVersionID(tempVersionID);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		try {
			String tempContents = new String(Files.readAllBytes(contentsPath), StandardCharsets.UTF_8);
			setContents(tempContents);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public Document clone() {
		Document document = null;
		try {
			document = (Document) super.clone();
		} catch (CloneNotSupportedException e) {
			document = new Document(this.author, this.date, this.copyright, this.versionID, this.contents, this.name);
		}
		return document;
	}
	
}
