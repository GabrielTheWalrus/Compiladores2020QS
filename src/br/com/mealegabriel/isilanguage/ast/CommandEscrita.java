package br.com.mealegabriel.isilanguage.ast;

public class CommandEscrita extends AbstractCommand {

	private String id;
	
	public CommandEscrita(String id) {
		this.id = id;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return "System.out.println("+id+");";
	}
	

}
