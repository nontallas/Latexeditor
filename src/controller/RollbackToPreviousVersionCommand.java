package controller;

import model.*;

public class RollbackToPreviousVersionCommand implements Command {
	private VersionsManager versionsManager;
	private Document currentDoc;
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager, Document currentDoc) {
		super();
		this.versionsManager = versionsManager;
		this.currentDoc = currentDoc;
	}
	@Override
	public void execute() {
		if (!currentDoc.getVersionID().equals("0")) {
			versionsManager.rollbackToPreviousVersion(currentDoc);
			int id = Integer.parseInt(currentDoc.getVersionID());
			id --;
			currentDoc.setVersionID(Integer.toString(id));
	
		}else {
			System.out.println("There isn't another previous version, you can't rollback!");
		}
	}
}
