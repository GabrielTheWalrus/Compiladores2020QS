package br.com.mealegabriel.isilanguage.datastructures;

public class IsiVariable extends IsiSymbol{

	public static final int NUMBER = 0;
	public static final int TEXT = 1;
	
	private int type;
	private String value;
	
	public IsiVariable(String name, int type, String value) {
		
		super(name);
		this.type = type;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static int getNumber() {
		return NUMBER;
	}

	public static int getText() {
		return TEXT;
	}

	@Override
	public String toString() {
		return "IsiVariable [type=" + type + ", value=" + value + ", name=" + name + "]";
	}

	@Override
	public String generateJavaCode() {
		
		String str;
		
		if(type == NUMBER) {
			str = "double ";
		}
		else
			str = "String ";
		
		return str + super.name + ";";
		
	}
	

}
