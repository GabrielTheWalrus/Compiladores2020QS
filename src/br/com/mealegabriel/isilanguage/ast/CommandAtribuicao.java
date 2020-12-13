package br.com.mealegabriel.isilanguage.ast;


public class CommandAtribuicao extends AbstractCommand{

	private String id;
	private String expr;
	
	public CommandAtribuicao(String id, String expr) {
		this.id = id;
		this.expr = expr;
	}

	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id + " = "+expr+";";
	}
	
}
