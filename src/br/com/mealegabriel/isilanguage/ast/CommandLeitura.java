package br.com.mealegabriel.isilanguage.ast;

import br.com.mealegabriel.isilanguage.datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private IsiVariable var;
	
	public CommandLeitura(String id, IsiVariable a) {
		this.id = id;
		this.var = a;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id +"= _key." + (var.getType()==IsiVariable.NUMBER? "nextDouble();": "nextLine();");
	}

}
