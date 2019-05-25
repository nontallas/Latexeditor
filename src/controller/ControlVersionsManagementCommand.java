package controller;

import java.io.IOException;

import model.*;

public class ControlVersionsManagementCommand implements Command {
	private VersionsStrategy strategy;
	private VersionsManager versionsManager;
	private String commandType;
	private Document currDoc;
	public ControlVersionsManagementCommand(VersionsStrategy strategy, VersionsManager versionsManager, String commandType, Document doc) {
		super();
		this.strategy = strategy;
		this.versionsManager = versionsManager;
		this.commandType = commandType;
		this.currDoc = doc;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (commandType.equals("enable")) {
			this.versionsManager.enable();	
			if (this.strategy instanceof VolatileVersionsStrategy) {
				try {
					((VolatileVersionsStrategy) this.strategy).checkDiskForVersions(currDoc);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			this.versionsManager.disable();
		}
	}

}
