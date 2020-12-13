package br.com.mealegabriel.isilanguage.ast;

import java.util.ArrayList;

public class CommandFor extends AbstractCommand{

	private String startID;
	private String startContent;
	private String condition;
	private String incrementoID;
	private String incrementoContent;
	
	private ArrayList<AbstractCommand> listaComandos;
	
	public CommandFor(String startID, String startContent, String condition, String incrementoID, String incrementoContent, ArrayList<AbstractCommand> lc) {
		this.startID = startID;
		this.startContent = startContent;
		this.condition = condition;
		this.incrementoID = incrementoID;
		this.incrementoContent = incrementoContent;
		this.listaComandos = lc;
	}

	@Override
	public String generateJavaCode() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("for ("+ startID +"=" + startContent+"; "+ condition + "; " + incrementoID + "=" + incrementoContent+") {\n");
		for (AbstractCommand cmd: listaComandos) {
			str.append("\t");
			str.append(cmd.generateJavaCode() + "\n");
		}
		str.append("\t}");
		
		return str.toString();
	}

}
