grammar IsiLang;

@header{
	
	import br.com.mealegabriel.isilanguage.datastructures.*;
	import br.com.mealegabriel.isilanguage.exceptions.*;
	import br.com.mealegabriel.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{

	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiVariable symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	private ArrayList<AbstractCommand> listaComando;
	
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprIf;
	private String _exprWhile;
	
	private void insertSymbol(String varName){
	
		_varName = varName;
		_varValue = null;
		symbol = new IsiVariable(_varName, _tipo, _varValue);
		
		if(!symbolTable.exists(_varName)) 
			symbolTable.add(symbol); 
		else
			throw new IsiSemanticExceptions("Symbol " + _varName + " j� declarado.");
		
	}
	
	private void verificaID(String name){
		
		if(!symbolTable.exists(name))
        	throw new IsiSemanticExceptions("Symbol " + name + " not declared."); 
	}
	
	public void exibeComandos(){
		for(AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}



prog : 'programa' declara bloco 'fimprog.'
		{ program.setVarTable(symbolTable);
          program.setComandos(stack.pop());
        }
     ;
     
declara : ('declare' declaravar)+
        ;
        
declaravar : tipo ID {
				
				insertSymbol(_input.LT(-1).getText());
			} 
			(',' ID {
						insertSymbol(_input.LT(-1).getText());
			        }
			)* DOT
           ;
     
bloco : { curThread = new ArrayList<AbstractCommand>();
		  stack.push(curThread);	
 	    }

		(cmd)+
      ;
      
tipo : 'numero' { _tipo = IsiVariable.NUMBER; }
     | 'texto'  { _tipo = IsiVariable.TEXT; }
     ;
      
cmd : cmdleitura | cmdescrita | cmdif | cmdwhile | cmdexpr
    ;

cmdleitura : 'leia' AP ID {
                    
                    verificaID(_input.LT(-1).getText());
                    _readID = _input.LT(-1).getText();
				} 
				FP DOT
				{
					IsiVariable var = (IsiVariable)symbolTable.get(_readID);
					CommandLeitura cmd = new CommandLeitura(_readID, var);
					stack.peek().add(cmd);
				}
				
           ;
           
cmdescrita : 'escreva' AP (ID
				{
                    
                    verificaID(_input.LT(-1).getText());
                    _writeID = _input.LT(-1).getText();
				}  

			| TEXTO {
				_writeID = _input.LT(-1).getText();
			}
			) FP DOT
			{
				CommandEscrita cmd = new CommandEscrita(_writeID);
			    stack.peek().add(cmd);
			}
           ;
           
cmdif      : 'se' AP 
                  expr { _exprIf = _input.LT(-1).getText(); } 
				  Op_rel { _exprIf += _input.LT(-1).getText(); }  
				  expr { _exprIf += _input.LT(-1).getText(); }
				  FP
             'entao' 
                  AC 
                  { curThread = new ArrayList<AbstractCommand>(); 
                  	stack.push(curThread);
                  }
                  cmd 
                  FC
                  {
                  	listaTrue = stack.pop();
                  }
             ('senao' 
             	AC 
             	 {  curThread = new ArrayList<AbstractCommand>(); 
                  	stack.push(curThread);
                 }
             	cmd 
             	FC
             	{
                  	listaFalse = stack.pop();
                  	CommandDecisao cmd = new CommandDecisao(_exprIf, listaTrue, listaFalse);
                  	stack.peek().add(cmd);
                }
             )?
           ;

cmdwhile   : 'enquanto' 
					AP 
					expr { _exprWhile = _input.LT(-1).getText(); }
					Op_rel { _exprWhile += _input.LT(-1).getText(); }
					expr { _exprWhile += _input.LT(-1).getText(); }
					FP 
					AC 
						{ 	curThread = new ArrayList<AbstractCommand>(); 
                  			stack.push(curThread);
                  		}
					cmd 
					FC
					{
	                  	listaComando = stack.pop();
	                  	CommandRepeticao cmd = new CommandRepeticao(_exprWhile, listaComando);
	                  	stack.peek().add(cmd);
               		}
           ;

cmdexpr    : ID {
                    
                    verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
				} 
				
				ATTR { _exprContent = ""; }
				
				expr DOT
				
				{ 
					CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			    	stack.peek().add(cmd);
				}
           ;
           
expr : termo (OP 
		{ _exprContent += _input.LT(-1).getText(); } 

		termo)*
     ;
     
Op_rel     : '<' | '>' | '<=' | '>=' | '!=' | '=='
		   ;

termo : ID {
                    
                    verificaID(_input.LT(-1).getText());
                    _exprContent += _input.LT(-1).getText();
				} 
      | NUM 
      { _exprContent += _input.LT(-1).getText(); }
      | TEXTO
      { _exprContent += _input.LT(-1).getText(); } 
      ;

OP : '+' | '-' | '*' | '/'
   ;
    
ATTR  : ':='
      ;           
  
AP : '('
   ;

AS : '"'
   ;
   
ID  : ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*
    ; 

TEXTO : '"' ( [0-9] | [a-z] | [A-Z] | ' ')+ '"'
      ;

FP : ')'
   ;
   
DOT : '.'
    ;
   
WS : (' ' | '\t' | '\n' | '\r') -> skip;

NUM : ([0-9])+ ('.' [0-9]+)?
    ;
    
AC : '{'
   ;
   
FC : '}'
   ;


