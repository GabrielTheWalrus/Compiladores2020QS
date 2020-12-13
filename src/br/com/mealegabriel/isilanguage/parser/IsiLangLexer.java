// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.mealegabriel.isilanguage.parser;

	
	import br.com.mealegabriel.isilanguage.datastructures.*;
	import br.com.mealegabriel.isilanguage.exceptions.*;
	import br.com.mealegabriel.isilanguage.ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, Op_rel=13, OP=14, ATTR=15, AP=16, AS=17, 
		ID=18, TEXTO=19, FP=20, DOT=21, WS=22, NUM=23, AC=24, FC=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "Op_rel", "OP", "ATTR", "AP", "AS", "ID", "TEXTO", 
		"FP", "DOT", "WS", "NUM", "AC", "FC"
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


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00c1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008d\n\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\5\23\u0099\n\23\3\23\7\23\u009c\n\23\f\23\16"+
		"\23\u009f\13\23\3\24\3\24\6\24\u00a3\n\24\r\24\16\24\u00a4\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\6\30\u00b2\n\30\r\30\16\30"+
		"\u00b3\3\30\3\30\6\30\u00b8\n\30\r\30\16\30\u00b9\5\30\u00bc\n\30\3\31"+
		"\3\31\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\3\2\t\4\2>>@@\5\2,-//\61\61\4\2C\\c|\5\2\62;C\\c|\6\2\"\"\62;C\\c|\5"+
		"\2\13\f\17\17\"\"\3\2\62;\2\u00c9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2"+
		"\2\2\5>\3\2\2\2\7G\3\2\2\2\tO\3\2\2\2\13Q\3\2\2\2\rX\3\2\2\2\17^\3\2\2"+
		"\2\21c\3\2\2\2\23k\3\2\2\2\25n\3\2\2\2\27t\3\2\2\2\31z\3\2\2\2\33\u008c"+
		"\3\2\2\2\35\u008e\3\2\2\2\37\u0090\3\2\2\2!\u0093\3\2\2\2#\u0095\3\2\2"+
		"\2%\u0098\3\2\2\2\'\u00a0\3\2\2\2)\u00a8\3\2\2\2+\u00aa\3\2\2\2-\u00ac"+
		"\3\2\2\2/\u00b1\3\2\2\2\61\u00bd\3\2\2\2\63\u00bf\3\2\2\2\65\66\7r\2\2"+
		"\66\67\7t\2\2\678\7q\2\289\7i\2\29:\7t\2\2:;\7c\2\2;<\7o\2\2<=\7c\2\2"+
		"=\4\3\2\2\2>?\7h\2\2?@\7k\2\2@A\7o\2\2AB\7r\2\2BC\7t\2\2CD\7q\2\2DE\7"+
		"i\2\2EF\7\60\2\2F\6\3\2\2\2GH\7f\2\2HI\7g\2\2IJ\7e\2\2JK\7n\2\2KL\7c\2"+
		"\2LM\7t\2\2MN\7g\2\2N\b\3\2\2\2OP\7.\2\2P\n\3\2\2\2QR\7p\2\2RS\7w\2\2"+
		"ST\7o\2\2TU\7g\2\2UV\7t\2\2VW\7q\2\2W\f\3\2\2\2XY\7v\2\2YZ\7g\2\2Z[\7"+
		"z\2\2[\\\7v\2\2\\]\7q\2\2]\16\3\2\2\2^_\7n\2\2_`\7g\2\2`a\7k\2\2ab\7c"+
		"\2\2b\20\3\2\2\2cd\7g\2\2de\7u\2\2ef\7e\2\2fg\7t\2\2gh\7g\2\2hi\7x\2\2"+
		"ij\7c\2\2j\22\3\2\2\2kl\7u\2\2lm\7g\2\2m\24\3\2\2\2no\7g\2\2op\7p\2\2"+
		"pq\7v\2\2qr\7c\2\2rs\7q\2\2s\26\3\2\2\2tu\7u\2\2uv\7g\2\2vw\7p\2\2wx\7"+
		"c\2\2xy\7q\2\2y\30\3\2\2\2z{\7g\2\2{|\7p\2\2|}\7s\2\2}~\7w\2\2~\177\7"+
		"c\2\2\177\u0080\7p\2\2\u0080\u0081\7v\2\2\u0081\u0082\7q\2\2\u0082\32"+
		"\3\2\2\2\u0083\u008d\t\2\2\2\u0084\u0085\7>\2\2\u0085\u008d\7?\2\2\u0086"+
		"\u0087\7@\2\2\u0087\u008d\7?\2\2\u0088\u0089\7#\2\2\u0089\u008d\7?\2\2"+
		"\u008a\u008b\7?\2\2\u008b\u008d\7?\2\2\u008c\u0083\3\2\2\2\u008c\u0084"+
		"\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0088\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\34\3\2\2\2\u008e\u008f\t\3\2\2\u008f\36\3\2\2\2\u0090\u0091\7<\2\2\u0091"+
		"\u0092\7?\2\2\u0092 \3\2\2\2\u0093\u0094\7*\2\2\u0094\"\3\2\2\2\u0095"+
		"\u0096\7$\2\2\u0096$\3\2\2\2\u0097\u0099\t\4\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009d\3\2\2\2\u009a\u009c\t\5\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e&\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u00a0\u00a2\7$\2\2\u00a1\u00a3\t\6\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a7\7$\2\2\u00a7(\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9*\3\2\2"+
		"\2\u00aa\u00ab\7\60\2\2\u00ab,\3\2\2\2\u00ac\u00ad\t\7\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00af\b\27\2\2\u00af.\3\2\2\2\u00b0\u00b2\t\b\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00bb\3\2\2\2\u00b5\u00b7\7\60\2\2\u00b6\u00b8\t\b\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b5\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\60\3\2\2\2\u00bd\u00be\7}\2\2\u00be\62\3\2\2\2\u00bf\u00c0\7\177\2\2"+
		"\u00c0\64\3\2\2\2\f\2\u008c\u0098\u009b\u009d\u00a2\u00a4\u00b3\u00b9"+
		"\u00bb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}