package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Stack;

public class StableVersionsStrategy implements VersionsStrategy {
	private Stack<String> contentHistory = new Stack<String>();
	
	@Override
	public void putVersion(Document currDoc) {
		// TODO Auto-generated method stub
		contentHistory.push(currDoc.getContents());
		String path = new File ("").getAbsolutePath();
		File contentsFile = new File (path + "\\tex_versions\\" + currDoc.getName() + "_" + currDoc.getVersionID() + "_.tex");
		
		try {
			PrintWriter printWriter = new PrintWriter (contentsFile);
			printWriter.print(currDoc.getContents());
			printWriter.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		int id = Integer.parseInt(currDoc.getVersionID());
		id ++;
		currDoc.setVersionID(Integer.toString(id));
		
	}
	

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return contentHistory.pop();
	}

	public StableVersionsStrategy() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setEntireHistory(Stack<String> contentHistory) {
		
		this.contentHistory = contentHistory;
		
	}

	@Override
	public Stack<String> getEntireHistory() {
		// TODO Auto-generated method stub
		return contentHistory;
	}

}
