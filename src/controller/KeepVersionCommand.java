package controller;

import model.*;

public class KeepVersionCommand implements Command {
	private VersionsManager versionsManager;
	private Document currentDoc;
	
	public KeepVersionCommand(VersionsManager versionsManager, Document currentDoc) {
		super();
		this.versionsManager = versionsManager;
		this.currentDoc = currentDoc;
	}
	
	@Override
	public void execute() {
		this.versionsManager.setCurrentVersion(currentDoc);
	}

	

}
