package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class VolatileVersionsStrategy implements VersionsStrategy {
	private Stack<String> contentHistory = new Stack<String>();
	
	@Override
	public void putVersion(Document currDoc) {
		// TODO Auto-generated method stub
		contentHistory.push(currDoc.getContents());

		int id = Integer.parseInt(currDoc.getVersionID());
		id ++;
		currDoc.setVersionID(Integer.toString(id));

	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		
		return contentHistory.pop();
	}

	@Override
	public void setEntireHistory(Stack<String> contentHistory) {
		this.contentHistory = contentHistory;
		// TODO Auto-generated method stub

	}

	@Override
	public Stack<String> getEntireHistory() {
		// TODO Auto-generated method stub
		return contentHistory;
	}
	public void checkDiskForVersions(Document currDoc) throws IOException {
		int id = Integer.parseInt(currDoc.getVersionID());
		String path = new File ("").getAbsolutePath() + "\\tex_versions\\";
		for (int i = 1; i <= id; i++) {
			
			String contentsPath = path + currDoc.getName() + "_" + i + "_.tex";	
			Path versionPath = Paths.get(contentsPath);
			File versionF = new File(contentsPath);
			if (versionF.exists()) {
				String tmp = new String(Files.readAllBytes(versionPath), StandardCharsets.UTF_8);
				this.contentHistory.push(tmp);
				try {
					versionF.delete();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
	}
}
