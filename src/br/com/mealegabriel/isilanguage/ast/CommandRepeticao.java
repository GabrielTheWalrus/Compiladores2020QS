package br.com.mealegabriel.isilanguage.ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand{

	private String condition;
	private ArrayList<AbstractCommand> listaComandos;
	
	public CommandRepeticao(String condition, ArrayList<AbstractCommand> lc) {
		this.condition = condition;
		this.listaComandos = lc;
	}


	@Override
	public String toString() {
		return "CommandRepeticao [condition=" + condition + ", listaComandos=" + listaComandos + "]";
	}


	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while ("+condition+") {\n");
		for (AbstractCommand cmd: listaComandos) {
			str.append(cmd.generateJavaCode());
		}
		str.append("}");
		
		return str.toString();
	}
		
	

}
