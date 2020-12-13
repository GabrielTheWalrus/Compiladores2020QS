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
		T__9=10, T__10=11, T__11=12, Op_rel=13, OP=14, ATTR=15, AP=16, AS=17, 
		ID=18, TEXTO=19, FP=20, DOT=21, WS=22, NUM=23, AC=24, FC=25;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_declaravar = 2, RULE_bloco = 3, 
		RULE_tipo = 4, RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, 
		RULE_cmdif = 8, RULE_cmdwhile = 9, RULE_cmdexpr = 10, RULE_expr = 11, 
		RULE_termo = 12;
	public static final String[] ruleNames = {
		"prog", "declara", "declaravar", "bloco", "tipo", "cmd", "cmdleitura", 
		"cmdescrita", "cmdif", "cmdwhile", "cmdexpr", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'declare'", "','", "'numero'", "'texto'", 
		"'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", null, 
		null, "':='", "'('", "'\"'", null, null, "')'", "'.'", null, null, "'{'", 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "Op_rel", "OP", "ATTR", "AP", "AS", "ID", "TEXTO", "FP", "DOT", 
		"WS", "NUM", "AC", "FC"
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
		
		private void insertSymbol(String varName){
		
			_varName = varName;
			_varValue = null;
			symbol = new IsiVariable(_varName, _tipo, _varValue);
			
			if(!symbolTable.exists(_varName)) 
				symbolTable.add(symbol); 
			else
				throw new IsiSemanticExceptions("Symbol " + _varName + " já declarado.");
			
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
			setState(26);
			match(T__0);
			setState(27);
			declara();
			setState(28);
			bloco();
			setState(29);
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
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				match(T__2);
				setState(33);
				declaravar();
				}
				}
				setState(36); 
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
			setState(38);
			tipo();
			setState(39);
			match(ID);

							
							insertSymbol(_input.LT(-1).getText());
						
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(41);
				match(T__3);
				setState(42);
				match(ID);

										insertSymbol(_input.LT(-1).getText());
							        
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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
			 	    
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				cmd();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << ID))) != 0) );
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__4);
				 _tipo = IsiVariable.NUMBER; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
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
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				cmdleitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				cmdescrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				cmdif();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				cmdwhile();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				cmdexpr();
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
			setState(70);
			match(T__6);
			setState(71);
			match(AP);
			setState(72);
			match(ID);

			                    
			                    verificaID(_input.LT(-1).getText());
			                    _readID = _input.LT(-1).getText();
							
			setState(74);
			match(FP);
			setState(75);
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
			setState(78);
			match(T__7);
			setState(79);
			match(AP);
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(80);
				match(ID);

				                    
				                    verificaID(_input.LT(-1).getText());
				                    _writeID = _input.LT(-1).getText();
								
				}
				break;
			case TEXTO:
				{
				setState(82);
				match(TEXTO);

								_writeID = _input.LT(-1).getText();
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(86);
			match(FP);
			setState(87);
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
			setState(90);
			match(T__8);
			setState(91);
			match(AP);
			setState(92);
			expr();
			 _exprIf = _input.LT(-1).getText(); 
			setState(94);
			match(Op_rel);
			 _exprIf += _input.LT(-1).getText(); 
			setState(96);
			expr();
			 _exprIf += _input.LT(-1).getText(); 
			setState(98);
			match(FP);
			setState(99);
			match(T__9);
			setState(100);
			match(AC);
			 curThread = new ArrayList<AbstractCommand>(); 
			                  	stack.push(curThread);
			                  
			setState(102);
			cmd();
			setState(103);
			match(FC);

			                  	listaTrue = stack.pop();
			                  
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(105);
				match(T__10);
				setState(106);
				match(AC);
				  curThread = new ArrayList<AbstractCommand>(); 
				                  	stack.push(curThread);
				                 
				setState(108);
				cmd();
				setState(109);
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
			setState(114);
			match(T__11);
			setState(115);
			match(AP);
			setState(116);
			expr();
			 _exprWhile = _input.LT(-1).getText(); 
			setState(118);
			match(Op_rel);
			 _exprWhile += _input.LT(-1).getText(); 
			setState(120);
			expr();
			 _exprWhile += _input.LT(-1).getText(); 
			setState(122);
			match(FP);
			setState(123);
			match(AC);
			 	curThread = new ArrayList<AbstractCommand>(); 
			                  			stack.push(curThread);
			                  		
			setState(125);
			cmd();
			setState(126);
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
		enterRule(_localctx, 20, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(ID);

			                    
			                    verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();
							
			setState(131);
			match(ATTR);
			 _exprContent = ""; 
			setState(133);
			expr();
			setState(134);
			match(DOT);
			 
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
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			termo();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(138);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(140);
				termo();
				}
				}
				setState(145);
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
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(ID);

				                    
				                    verificaID(_input.LT(-1).getText());
				                    _exprContent += _input.LT(-1).getText();
								
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(NUM);
				 _exprContent += _input.LT(-1).getText(); 
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u009d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\6\3%\n"+
		"\3\r\3\16\3&\3\4\3\4\3\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\4\3\4"+
		"\3\5\3\5\6\58\n\5\r\5\16\59\3\6\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\5\7G\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\tW\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ns\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0090\n\r\f\r\16\r\u0093\13\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\5\16\u009b\n\16\3\16\2\2\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\2\2\u009c\2\34\3\2\2\2\4$\3\2\2\2\6(\3\2\2\2\b\65"+
		"\3\2\2\2\n?\3\2\2\2\fF\3\2\2\2\16H\3\2\2\2\20P\3\2\2\2\22\\\3\2\2\2\24"+
		"t\3\2\2\2\26\u0083\3\2\2\2\30\u008b\3\2\2\2\32\u009a\3\2\2\2\34\35\7\3"+
		"\2\2\35\36\5\4\3\2\36\37\5\b\5\2\37 \7\4\2\2 !\b\2\1\2!\3\3\2\2\2\"#\7"+
		"\5\2\2#%\5\6\4\2$\"\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\5\3\2\2\2"+
		"()\5\n\6\2)*\7\24\2\2*\60\b\4\1\2+,\7\6\2\2,-\7\24\2\2-/\b\4\1\2.+\3\2"+
		"\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2"+
		"\63\64\7\27\2\2\64\7\3\2\2\2\65\67\b\5\1\2\668\5\f\7\2\67\66\3\2\2\28"+
		"9\3\2\2\29\67\3\2\2\29:\3\2\2\2:\t\3\2\2\2;<\7\7\2\2<@\b\6\1\2=>\7\b\2"+
		"\2>@\b\6\1\2?;\3\2\2\2?=\3\2\2\2@\13\3\2\2\2AG\5\16\b\2BG\5\20\t\2CG\5"+
		"\22\n\2DG\5\24\13\2EG\5\26\f\2FA\3\2\2\2FB\3\2\2\2FC\3\2\2\2FD\3\2\2\2"+
		"FE\3\2\2\2G\r\3\2\2\2HI\7\t\2\2IJ\7\22\2\2JK\7\24\2\2KL\b\b\1\2LM\7\26"+
		"\2\2MN\7\27\2\2NO\b\b\1\2O\17\3\2\2\2PQ\7\n\2\2QV\7\22\2\2RS\7\24\2\2"+
		"SW\b\t\1\2TU\7\25\2\2UW\b\t\1\2VR\3\2\2\2VT\3\2\2\2WX\3\2\2\2XY\7\26\2"+
		"\2YZ\7\27\2\2Z[\b\t\1\2[\21\3\2\2\2\\]\7\13\2\2]^\7\22\2\2^_\5\30\r\2"+
		"_`\b\n\1\2`a\7\17\2\2ab\b\n\1\2bc\5\30\r\2cd\b\n\1\2de\7\26\2\2ef\7\f"+
		"\2\2fg\7\32\2\2gh\b\n\1\2hi\5\f\7\2ij\7\33\2\2jr\b\n\1\2kl\7\r\2\2lm\7"+
		"\32\2\2mn\b\n\1\2no\5\f\7\2op\7\33\2\2pq\b\n\1\2qs\3\2\2\2rk\3\2\2\2r"+
		"s\3\2\2\2s\23\3\2\2\2tu\7\16\2\2uv\7\22\2\2vw\5\30\r\2wx\b\13\1\2xy\7"+
		"\17\2\2yz\b\13\1\2z{\5\30\r\2{|\b\13\1\2|}\7\26\2\2}~\7\32\2\2~\177\b"+
		"\13\1\2\177\u0080\5\f\7\2\u0080\u0081\7\33\2\2\u0081\u0082\b\13\1\2\u0082"+
		"\25\3\2\2\2\u0083\u0084\7\24\2\2\u0084\u0085\b\f\1\2\u0085\u0086\7\21"+
		"\2\2\u0086\u0087\b\f\1\2\u0087\u0088\5\30\r\2\u0088\u0089\7\27\2\2\u0089"+
		"\u008a\b\f\1\2\u008a\27\3\2\2\2\u008b\u0091\5\32\16\2\u008c\u008d\7\20"+
		"\2\2\u008d\u008e\b\r\1\2\u008e\u0090\5\32\16\2\u008f\u008c\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\31\3\2\2"+
		"\2\u0093\u0091\3\2\2\2\u0094\u0095\7\24\2\2\u0095\u009b\b\16\1\2\u0096"+
		"\u0097\7\31\2\2\u0097\u009b\b\16\1\2\u0098\u0099\7\25\2\2\u0099\u009b"+
		"\b\16\1\2\u009a\u0094\3\2\2\2\u009a\u0096\3\2\2\2\u009a\u0098\3\2\2\2"+
		"\u009b\33\3\2\2\2\13&\609?FVr\u0091\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}