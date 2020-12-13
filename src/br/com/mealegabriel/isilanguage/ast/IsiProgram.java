package br.com.mealegabriel.isilanguage.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.mealegabriel.isilanguage.datastructures.IsiSymbol;
import br.com.mealegabriel.isilanguage.datastructures.IsiSymbolTable;
import br.com.mealegabriel.isilanguage.datastructures.IsiVariable;
import br.com.mealegabriel.isilanguage.exceptions.IsiSemanticExceptions;

public class IsiProgram {
	
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;

	public void generateTarget() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass{ \n");
		str.append("\tpublic static void main(String args[]){\n ");
		str.append("\tScanner _key = new Scanner(System.in);\n");
		for (IsiSymbol symbol: varTable.getAll()) {
			str.append("\t");
			str.append(symbol.generateJavaCode()+"\n");
		}
		for (AbstractCommand command: comandos) {
			str.append("\t");
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("  }\n");
		str.append("}\n");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public IsiSymbolTable getVarTable() {
		return varTable;
	}
	
	
	public void getVariables() {
		
		List<IsiVariable> vars = varTable.getAllUnused();
		
		String errorMsg = "Variáveis declaradas mas não utilizadas: ";
		
		for(IsiVariable var: vars) {
			
			errorMsg += var.getName() + " - ";
		}
		
		if(vars.size() > 0) {
			throw new IsiSemanticExceptions(errorMsg);
		}
		
	}

	public void setVarTable(IsiSymbolTable varTable) {
		this.varTable = varTable;
	}
	
	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
	
	

}
