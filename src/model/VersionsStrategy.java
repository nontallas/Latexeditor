package model;

import java.util.Stack;

public interface VersionsStrategy {
	public void putVersion(Document currentDoc);
	public String getVersion();
	public void setEntireHistory(Stack<String> contentHistory);
	public Stack<String> getEntireHistory();
}
