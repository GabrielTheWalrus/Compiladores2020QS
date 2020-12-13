// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.mealegabriel.isilanguage.parser;

	
	import br.com.mealegabriel.isilanguage.datastructures.*;
	import br.com.mealegabriel.isilanguage.exceptions.*;
	import br.com.mealegabriel.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, Op_rel=14, OP=15, ATTR=16, AP=17, 
		AS=18, ID=19, TEXTO=20, FP=21, DOT=22, WS=23, LINE_COMMENT=24, COMMENT=25, 
		NUM=26, AC=27, FC=28;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaravar = 2, RULE_bloco = 3, 
		RULE_tipo = 4, RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, 
		RULE_cmdif = 8, RULE_cmdwhile = 9, RULE_cmdfor = 10, RULE_cmdexpr = 11, 
		RULE_expr = 12, RULE_termo = 13;
	public static final String[] ruleNames = {
		"prog", "declara", "declaravar", "bloco", "tipo", "cmd", "cmdleitura", 
		"cmdescrita", "cmdif", "cmdwhile", "cmdfor", "cmdexpr", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "','", "'numero'", "'texto'", 
		"'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", "'para'", 
		null, null, "':='", "'('", "'\"'", null, null, "')'", "'.'", null, null, 
		null, null, "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "Op_rel", "OP", "ATTR", "AP", "AS", "ID", "TEXTO", "FP", "DOT", 
		"WS", "LINE_COMMENT", "COMMENT", "NUM", "AC", "FC"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



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
		private String _exprStartID;
		private String _exprStartContent;
		private String _exprCondition;
		private String _exprIncrementoID;
		private String _exprIncrementoContent;
		
		private void insertSymbol(String varName){
		
			_varName = varName;
			_varValue = null;
			symbol = new IsiVariable(_varName, _tipo, _varValue);
			
			if(!symbolTable.exists(_varName)) 
				symbolTable.add(symbol); 
			else
				throw new IsiSemanticExceptions("Symbol " + _varName + " já declarado.");
			
		}
		
		private void insertValueSymbol(){
		
			symbol = (IsiVariable)symbolTable.get(_varName);
			
			if(symbol != null){
				symbol.value = _varValue;
				symbolTable.update(symbol);
			} 
			else
				throw new IsiSemanticExceptions("Symbol " + _varName + " não declarado.");
			
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
			program.getVariables();
		}

	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			declara();
			setState(30);
			bloco();
			setState(31);
			match(T__1);
			 program.setVarTable(symbolTable);
			          program.setComandos(stack.pop());
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				match(T__2);
				setState(35);
				declaravar();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(IsiLangParser.DOT, 0); }
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			tipo();
			setState(41);
			match(ID);

							
							insertSymbol(_input.LT(-1).getText());
						
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(43);
				match(T__3);
				setState(44);
				match(ID);

										insertSymbol(_input.LT(-1).getText());
							        
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(DOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>();
					  stack.push(curThread);	
			 	    
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				cmd();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(T__4);
				 _tipo = IsiVariable.NUMBER; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(T__5);
				 _tipo = IsiVariable.TEXT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdwhileContext cmdwhile() {
			return getRuleContext(CmdwhileContext.class,0);
		}
		public CmdexprContext cmdexpr() {
			return getRuleContext(CmdexprContext.class,0);
		}
		public CmdforContext cmdfor() {
			return getRuleContext(CmdforContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				cmdleitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				cmdescrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				cmdif();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				cmdwhile();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				cmdexpr();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				cmdfor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode DOT() { return getToken(IsiLangParser.DOT, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__6);
			setState(74);
			match(AP);
			setState(75);
			match(ID);

			                    
			                    verificaID(_input.LT(-1).getText());
			                    _readID = _input.LT(-1).getText();
							
			setState(77);
			match(FP);
			setState(78);
			match(DOT);

								IsiVariable var = (IsiVariable)symbolTable.get(_readID);
								CommandLeitura cmd = new CommandLeitura(_readID, var);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode DOT() { return getToken(IsiLangParser.DOT, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__7);
			setState(82);
			match(AP);
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(83);
				match(ID);

				                    
				                    verificaID(_input.LT(-1).getText());
				                    _writeID = _input.LT(-1).getText();
								
				}
				break;
			case TEXTO:
				{
				setState(85);
				match(TEXTO);

								_writeID = _input.LT(-1).getText();
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(89);
			match(FP);
			setState(90);
			match(DOT);

							CommandEscrita cmd = new CommandEscrita(_writeID);
						    stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdifContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Op_rel() { return getToken(IsiLangParser.Op_rel, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(IsiLangParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(IsiLangParser.AC, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> FC() { return getTokens(IsiLangParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(IsiLangParser.FC, i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__8);
			setState(94);
			match(AP);
			setState(95);
			expr();
			 _exprIf = _input.LT(-1).getText(); 
			setState(97);
			match(Op_rel);
			 _exprIf += _input.LT(-1).getText(); 
			setState(99);
			expr();
			 _exprIf += _input.LT(-1).getText(); 
			setState(101);
			match(FP);
			setState(102);
			match(T__9);
			setState(103);
			match(AC);
			 curThread = new ArrayList<AbstractCommand>(); 
			                  	stack.push(curThread);
			                  
			setState(105);
			cmd();
			setState(106);
			match(FC);

			                  	listaTrue = stack.pop();
			                  
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(108);
				match(T__10);
				setState(109);
				match(AC);
				  curThread = new ArrayList<AbstractCommand>(); 
				                  	stack.push(curThread);
				                 
				setState(111);
				cmd();
				setState(112);
				match(FC);

				                  	listaFalse = stack.pop();
				                  	CommandDecisao cmd = new CommandDecisao(_exprIf, listaTrue, listaFalse);
				                  	stack.peek().add(cmd);
				                
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdwhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Op_rel() { return getToken(IsiLangParser.Op_rel, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLangParser.AC, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public TerminalNode FC() { return getToken(IsiLangParser.FC, 0); }
		public CmdwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdwhile(this);
		}
	}

	public final CmdwhileContext cmdwhile() throws RecognitionException {
		CmdwhileContext _localctx = new CmdwhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdwhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__11);
			setState(118);
			match(AP);
			setState(119);
			expr();
			 _exprWhile = _input.LT(-1).getText(); 
			setState(121);
			match(Op_rel);
			 _exprWhile += _input.LT(-1).getText(); 
			setState(123);
			expr();
			 _exprWhile += _input.LT(-1).getText(); 
			setState(125);
			match(FP);
			setState(126);
			match(AC);
			 	curThread = new ArrayList<AbstractCommand>(); 
			                  			stack.push(curThread);
			                  		
			setState(128);
			cmd();
			setState(129);
			match(FC);

				                  	listaComando = stack.pop();
				                  	CommandRepeticao cmd = new CommandRepeticao(_exprWhile, listaComando);
				                  	stack.peek().add(cmd);
			               		
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdforContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> ATTR() { return getTokens(IsiLangParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(IsiLangParser.ATTR, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(IsiLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(IsiLangParser.DOT, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Op_rel() { return getToken(IsiLangParser.Op_rel, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLangParser.AC, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public TerminalNode FC() { return getToken(IsiLangParser.FC, 0); }
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public CmdforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdfor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdfor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdfor(this);
		}
	}

	public final CmdforContext cmdfor() throws RecognitionException {
		CmdforContext _localctx = new CmdforContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdfor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__12);
			setState(133);
			match(AP);
			setState(134);
			match(ID);
			 
										verificaID(_input.LT(-1).getText());
										_exprStartID = _input.LT(-1).getText(); 
								   
			setState(136);
			match(ATTR);
			setState(137);
			termo();
			 _exprStartContent = _input.LT(-1).getText(); 
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(139);
				match(OP);
				 _exprStartContent += _input.LT(-1).getText(); 
				setState(141);
				termo();
				 _exprStartContent += _input.LT(-1).getText(); 
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			match(DOT);
			setState(150);
			expr();
			 _exprCondition = _input.LT(-1).getText(); 
			setState(152);
			match(Op_rel);
			 _exprCondition += _input.LT(-1).getText(); 
			setState(154);
			expr();
			 _exprCondition += _input.LT(-1).getText(); 
			setState(156);
			match(DOT);
			setState(157);
			match(ID);
			 
										verificaID(_input.LT(-1).getText());
										_exprIncrementoID = _input.LT(-1).getText(); 
									
			setState(159);
			match(ATTR);
			setState(160);
			termo();
			 _exprIncrementoContent = _input.LT(-1).getText(); 
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(162);
				match(OP);
				 _exprIncrementoContent += _input.LT(-1).getText(); 
				setState(164);
				termo();
				 _exprIncrementoContent += _input.LT(-1).getText(); 
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(FP);
			setState(173);
			match(AC);

										curThread = new ArrayList<AbstractCommand>(); 
			                  			stack.push(curThread);
									
			setState(175);
			cmd();
			setState(176);
			match(FC);

				                  	listaComando = stack.pop();
				                  	CommandFor cmd = new CommandFor(_exprStartID, _exprStartContent, _exprCondition, _exprIncrementoID,  _exprIncrementoContent, listaComando);
				                  	stack.peek().add(cmd);
			               		
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(IsiLangParser.DOT, 0); }
		public CmdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdexpr(this);
		}
	}

	public final CmdexprContext cmdexpr() throws RecognitionException {
		CmdexprContext _localctx = new CmdexprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(ID);

			                    
			                    verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
			                    _varName = _input.LT(-1).getText();
							
			setState(181);
			match(ATTR);
			 _exprContent = ""; 
			setState(183);
			expr();
			 _varValue = _input.LT(-1).getText(); 
			setState(185);
			match(DOT);
			 insertValueSymbol(); 
			 
								CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
						    	stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			termo();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(190);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(192);
				termo();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUM() { return getToken(IsiLangParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(ID);

				                    
				                    verificaID(_input.LT(-1).getText());
				                    _exprContent += _input.LT(-1).getText();
							
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(NUM);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(TEXTO);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00d1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\6\3\'\n\3\r\3\16\3(\3\4\3\4\3\4\3\4\3\4\3\4\7\4\61\n\4\f\4\16\4\64"+
		"\13\4\3\4\3\4\3\5\3\5\6\5:\n\5\r\5\16\5;\3\6\3\6\3\6\3\6\5\6B\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7J\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tZ\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nv\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0093\n\f\f"+
		"\f\16\f\u0096\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u00aa\n\f\f\f\16\f\u00ad\13\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\7\16\u00c4\n\16\f\16\16\16\u00c7\13\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00cf\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2"+
		"\2\2\u00d2\2\36\3\2\2\2\4&\3\2\2\2\6*\3\2\2\2\b\67\3\2\2\2\nA\3\2\2\2"+
		"\fI\3\2\2\2\16K\3\2\2\2\20S\3\2\2\2\22_\3\2\2\2\24w\3\2\2\2\26\u0086\3"+
		"\2\2\2\30\u00b5\3\2\2\2\32\u00bf\3\2\2\2\34\u00ce\3\2\2\2\36\37\7\3\2"+
		"\2\37 \5\4\3\2 !\5\b\5\2!\"\7\4\2\2\"#\b\2\1\2#\3\3\2\2\2$%\7\5\2\2%\'"+
		"\5\6\4\2&$\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*+\5\n\6\2"+
		"+,\7\25\2\2,\62\b\4\1\2-.\7\6\2\2./\7\25\2\2/\61\b\4\1\2\60-\3\2\2\2\61"+
		"\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65"+
		"\66\7\30\2\2\66\7\3\2\2\2\679\b\5\1\28:\5\f\7\298\3\2\2\2:;\3\2\2\2;9"+
		"\3\2\2\2;<\3\2\2\2<\t\3\2\2\2=>\7\7\2\2>B\b\6\1\2?@\7\b\2\2@B\b\6\1\2"+
		"A=\3\2\2\2A?\3\2\2\2B\13\3\2\2\2CJ\5\16\b\2DJ\5\20\t\2EJ\5\22\n\2FJ\5"+
		"\24\13\2GJ\5\30\r\2HJ\5\26\f\2IC\3\2\2\2ID\3\2\2\2IE\3\2\2\2IF\3\2\2\2"+
		"IG\3\2\2\2IH\3\2\2\2J\r\3\2\2\2KL\7\t\2\2LM\7\23\2\2MN\7\25\2\2NO\b\b"+
		"\1\2OP\7\27\2\2PQ\7\30\2\2QR\b\b\1\2R\17\3\2\2\2ST\7\n\2\2TY\7\23\2\2"+
		"UV\7\25\2\2VZ\b\t\1\2WX\7\26\2\2XZ\b\t\1\2YU\3\2\2\2YW\3\2\2\2Z[\3\2\2"+
		"\2[\\\7\27\2\2\\]\7\30\2\2]^\b\t\1\2^\21\3\2\2\2_`\7\13\2\2`a\7\23\2\2"+
		"ab\5\32\16\2bc\b\n\1\2cd\7\20\2\2de\b\n\1\2ef\5\32\16\2fg\b\n\1\2gh\7"+
		"\27\2\2hi\7\f\2\2ij\7\35\2\2jk\b\n\1\2kl\5\f\7\2lm\7\36\2\2mu\b\n\1\2"+
		"no\7\r\2\2op\7\35\2\2pq\b\n\1\2qr\5\f\7\2rs\7\36\2\2st\b\n\1\2tv\3\2\2"+
		"\2un\3\2\2\2uv\3\2\2\2v\23\3\2\2\2wx\7\16\2\2xy\7\23\2\2yz\5\32\16\2z"+
		"{\b\13\1\2{|\7\20\2\2|}\b\13\1\2}~\5\32\16\2~\177\b\13\1\2\177\u0080\7"+
		"\27\2\2\u0080\u0081\7\35\2\2\u0081\u0082\b\13\1\2\u0082\u0083\5\f\7\2"+
		"\u0083\u0084\7\36\2\2\u0084\u0085\b\13\1\2\u0085\25\3\2\2\2\u0086\u0087"+
		"\7\17\2\2\u0087\u0088\7\23\2\2\u0088\u0089\7\25\2\2\u0089\u008a\b\f\1"+
		"\2\u008a\u008b\7\22\2\2\u008b\u008c\5\34\17\2\u008c\u0094\b\f\1\2\u008d"+
		"\u008e\7\21\2\2\u008e\u008f\b\f\1\2\u008f\u0090\5\34\17\2\u0090\u0091"+
		"\b\f\1\2\u0091\u0093\3\2\2\2\u0092\u008d\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0098\7\30\2\2\u0098\u0099\5\32\16\2\u0099\u009a\b\f\1\2\u009a"+
		"\u009b\7\20\2\2\u009b\u009c\b\f\1\2\u009c\u009d\5\32\16\2\u009d\u009e"+
		"\b\f\1\2\u009e\u009f\7\30\2\2\u009f\u00a0\7\25\2\2\u00a0\u00a1\b\f\1\2"+
		"\u00a1\u00a2\7\22\2\2\u00a2\u00a3\5\34\17\2\u00a3\u00ab\b\f\1\2\u00a4"+
		"\u00a5\7\21\2\2\u00a5\u00a6\b\f\1\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8"+
		"\b\f\1\2\u00a8\u00aa\3\2\2\2\u00a9\u00a4\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ae\u00af\7\27\2\2\u00af\u00b0\7\35\2\2\u00b0\u00b1\b\f\1\2\u00b1"+
		"\u00b2\5\f\7\2\u00b2\u00b3\7\36\2\2\u00b3\u00b4\b\f\1\2\u00b4\27\3\2\2"+
		"\2\u00b5\u00b6\7\25\2\2\u00b6\u00b7\b\r\1\2\u00b7\u00b8\7\22\2\2\u00b8"+
		"\u00b9\b\r\1\2\u00b9\u00ba\5\32\16\2\u00ba\u00bb\b\r\1\2\u00bb\u00bc\7"+
		"\30\2\2\u00bc\u00bd\b\r\1\2\u00bd\u00be\b\r\1\2\u00be\31\3\2\2\2\u00bf"+
		"\u00c5\5\34\17\2\u00c0\u00c1\7\21\2\2\u00c1\u00c2\b\16\1\2\u00c2\u00c4"+
		"\5\34\17\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2"+
		"\u00c5\u00c6\3\2\2\2\u00c6\33\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9"+
		"\7\25\2\2\u00c9\u00cf\b\17\1\2\u00ca\u00cb\7\34\2\2\u00cb\u00cf\b\17\1"+
		"\2\u00cc\u00cd\7\26\2\2\u00cd\u00cf\b\17\1\2\u00ce\u00c8\3\2\2\2\u00ce"+
		"\u00ca\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\35\3\2\2\2\r(\62;AIYu\u0094\u00ab"+
		"\u00c5\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}