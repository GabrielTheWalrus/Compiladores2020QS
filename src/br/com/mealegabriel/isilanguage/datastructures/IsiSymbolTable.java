package br.com.mealegabriel.isilanguage.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class IsiSymbolTable {

	private HashMap<String, IsiSymbol> map;
	
	public IsiSymbolTable() {

		map = new HashMap<String, IsiSymbol>();
	}
	
	public void add(IsiSymbol symbol) {
		
		map.put(symbol.getName(), symbol);
	}
	public void update(IsiSymbol symbol) {
		
		map.replace(symbol.getName(), symbol);
	}	
	
	public boolean exists(String symbolName) {
		
		return map.get(symbolName) != null;
	}
	
	public IsiSymbol get(String symbolName) {
		
		return map.get(symbolName);
	}
	
	public ArrayList<IsiVariable> getAllUnused(){
		
		ArrayList<IsiVariable> lista = new ArrayList<IsiVariable>();
		
		
		for(IsiSymbol symbol: map.values()) {

			IsiVariable a = (IsiVariable)map.get(symbol.name);
			
			if(a.value == null)
				lista.add(a);
			
		}
		return lista;
		
	}
	
		
	public ArrayList<IsiSymbol> getAll(){
		
		ArrayList<IsiSymbol> lista = new ArrayList<IsiSymbol>();
		for(IsiSymbol symbol : map.values()) {
			lista.add(symbol);
		}
		return lista;
		
	}
		
}


