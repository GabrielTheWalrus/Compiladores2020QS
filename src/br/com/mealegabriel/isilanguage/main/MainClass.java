package br.com.mealegabriel.isilanguage.main;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.mealegabriel.isilanguage.exceptions.IsiSemanticExceptions;
import br.com.mealegabriel.isilanguage.parser.IsiLangLexer;
import br.com.mealegabriel.isilanguage.parser.IsiLangParser;

public class MainClass {
	
	public static void main(String[] args) {
		
		try {

			IsiLangLexer lexer;
			IsiLangParser parser;
			
			lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));
			
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new IsiLangParser(tokenStream);
			
			parser.prog();
			
			//parser.exibeComandos();
			
			parser.generateCode();
			
			
			
			System.out.println("Compilado com sucesso!");
			
		} catch (IsiSemanticExceptions e) {
			System.err.println("Semantic Error - " + e.getMessage());
			
		} catch (Exception e) {
			System.err.println("Error - " + e.getMessage());
			
		}
		
	}

}
