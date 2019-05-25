package controller;

import java.util.Stack;

import model.*;

public class ChangeVersionsStrategyCommand implements Command {
	private VersionsStrategy versionsStrategy;
	private VersionsManager versionsManager;
	private String commandType;
	private Stack<String> tempStack;
	
	public ChangeVersionsStrategyCommand(VersionsStrategy versionsStrategy,
			VersionsManager versionsManager, String commandType) {
		super();
		this.versionsStrategy = versionsStrategy;
		this.versionsManager = versionsManager;
		this.commandType = commandType;
	}

	@Override
	public void execute() {
		if (commandType.equals("stable")) {
			VersionsStrategy newVersionsStrategy = new StableVersionsStrategy();
			tempStack = this.versionsStrategy.getEntireHistory();
			this.versionsStrategy = newVersionsStrategy;
			this.versionsStrategy.setEntireHistory(tempStack);
			this.versionsManager.setVersionsStrategy(newVersionsStrategy);
		}else {
			VersionsStrategy newVersionsStrategy = new VolatileVersionsStrategy();
			tempStack = this.versionsStrategy.getEntireHistory();
			this.versionsStrategy = newVersionsStrategy;
			this.versionsStrategy.setEntireHistory(tempStack);
			this.versionsManager.setVersionsStrategy(newVersionsStrategy);
		}
			

	}

}
