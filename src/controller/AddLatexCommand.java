package controller;

import model.*;

public class AddLatexCommand implements Command {
	private String commandType;
	private Document currentDoc;

	public AddLatexCommand(String commandType, Document currentDoc) {
		super();
		this.commandType = commandType;
		this.currentDoc = currentDoc;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		CommandAdder nextCommand = new CommandAdder(this.currentDoc, this.commandType);
		nextCommand.addCommand();

	}
}
