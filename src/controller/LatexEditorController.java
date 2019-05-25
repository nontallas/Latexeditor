package controller;

import model.*;

public class LatexEditorController {
	private Document currentDocument;
	private Command command;
	private CreateCommand createCommand;
	private LoadCommand loadCommand;
	private VersionsStrategy versionsStrategy;
	private VersionsManager versionsManager;
	private CommandsFactory comFac;
	private String name;
	

	public LatexEditorController(String name) {
		super();
		this.name = name;
		this.versionsStrategy = new VolatileVersionsStrategy();
		this.versionsManager = new VersionsManager(false, versionsStrategy);
	}

	public LatexEditorController(Document currentDocument) {
		super();
		this.currentDocument = currentDocument;
		//we have this so we can access the curdoc with the get doc of createCommand
	}

	public LatexEditorController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public void enact(String clickAct) {
		comFac = new CommandsFactory(currentDocument, versionsStrategy, versionsManager, "ADDTHEFIELDFROMVIEW");

		if (clickAct.equals("empty") || clickAct.equals("book") || clickAct.equals("article") || clickAct.equals("report") || clickAct.equals("letter")) {
			comFac.setName(name);
			this.createCommand = (CreateCommand) comFac.createCommand(clickAct);
			this.createCommand.execute();
			this.currentDocument = this.createCommand.getCurrentDoc();	
		}else if (clickAct.equals("enable")) {
			this.versionsManager = new VersionsManager(true, this.versionsStrategy);
			comFac.setVersionsManager(versionsManager);
			this.command = comFac.createCommand(clickAct);
			this.command.execute();
			
		}else if (clickAct.contentEquals("load")) {
			comFac.setName(name);
			this.loadCommand =(LoadCommand) comFac.createCommand(clickAct);
			this.loadCommand.execute();
			this.currentDocument = this.loadCommand.getLoadedDoc();
		}else if(clickAct.equals("stable")) {
			this.versionsStrategy = new StableVersionsStrategy();
			this.versionsManager.setVersionsStrategy(this.versionsStrategy);
			comFac.setVersionsManager(this.versionsManager);
			comFac.setVersionsStrategy(versionsStrategy);
			this.command = comFac.createCommand(clickAct);
			this.command.execute();
		}else if(clickAct.equals("volatile")) {
			this.versionsStrategy = new VolatileVersionsStrategy();
			this.versionsManager.setVersionsStrategy(this.versionsStrategy);
			comFac.setVersionsManager(this.versionsManager);
			this.command = comFac.createCommand(clickAct);
			this.command.execute();
			
		}else {
			this.command = comFac.createCommand(clickAct);
			this.command.execute();
		}
	}
	public String writeContents() {
		return this.currentDocument.getContents();
	}

	public Command getCommand() {
		return command;
	}

	public CreateCommand getCreateCommand() {
		return createCommand;
	}
	
}
