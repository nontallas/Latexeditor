package controller;

import model.*;

public class CommandsFactory {
	private Document currentDoc;
	private VersionsStrategy versionsStrategy;
	private VersionsManager versionsManager;
	private String name;


	public CommandsFactory() {
		super();
	}
	
	public CommandsFactory(Document currentDoc, VersionsStrategy versionsStrategy, VersionsManager versionsManager, String name) {
		super();
		this.currentDoc = currentDoc;
		this.versionsStrategy = versionsStrategy;
		this.versionsManager = versionsManager;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
		
	}

	public void setVersionsStrategy(VersionsStrategy versionsStrategy) {
		this.versionsStrategy = versionsStrategy;
	}

	public Command createCommand(String commandType) {
		switch (commandType) {
			case "empty":
			case "book":
			case "article":
			case "letter":
			case "report":
				return new CreateCommand(commandType, name);
			case "chapter":
			case "section":
			case "subsection":
			case "subsubsection":
			case "figure":
			case "table":
			case "enumlist":
			case "bulletlist":
				return new AddLatexCommand(commandType, currentDoc);
			case "load":
				return new LoadCommand(currentDoc, name);
			case "save":
				return new SaveCommand(currentDoc);
			case "enable":
			case "disable":
				return new ControlVersionsManagementCommand(versionsStrategy, versionsManager , commandType, currentDoc);
			case "stable":
			case "volatile":
				return new ChangeVersionsStrategyCommand(versionsStrategy, versionsManager, commandType);
			case "keep":
				return new KeepVersionCommand(versionsManager, currentDoc);
			case "rollback":
				return new RollbackToPreviousVersionCommand(versionsManager, currentDoc);
			default:
				return new EditCommand(commandType, currentDoc);
				//As commandType we will use the context of the text field.
		}
	}

	
	
}
