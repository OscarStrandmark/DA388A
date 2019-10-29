package generated;// Generated from C:/dev/git/DA388A/Ex2/grammar\EzLang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EzLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, ID=16, INT=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "ID", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'loop'", "'('", "'):'", "'end loop.'", "'print'", "'var'", 
			"'='", "'+'", "'-'", "'*'", "'equals'", "'!equals'", "'<<'", "'>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "INT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public EzLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EzLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24u\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\6\21"+
		"f\n\21\r\21\16\21g\3\22\6\22k\n\22\r\22\16\22l\3\23\6\23p\n\23\r\23\16"+
		"\23q\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\3\5\2\13\f\17\17\"\"\2w\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7.\3\2\2\2\t\60\3\2\2\2\13\63\3\2\2"+
		"\2\r=\3\2\2\2\17C\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2"+
		"\2\2\31O\3\2\2\2\33V\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!e\3\2\2\2#j\3\2\2"+
		"\2%o\3\2\2\2\'(\7\60\2\2(\4\3\2\2\2)*\7n\2\2*+\7q\2\2+,\7q\2\2,-\7r\2"+
		"\2-\6\3\2\2\2./\7*\2\2/\b\3\2\2\2\60\61\7+\2\2\61\62\7<\2\2\62\n\3\2\2"+
		"\2\63\64\7g\2\2\64\65\7p\2\2\65\66\7f\2\2\66\67\7\"\2\2\678\7n\2\289\7"+
		"q\2\29:\7q\2\2:;\7r\2\2;<\7\60\2\2<\f\3\2\2\2=>\7r\2\2>?\7t\2\2?@\7k\2"+
		"\2@A\7p\2\2AB\7v\2\2B\16\3\2\2\2CD\7x\2\2DE\7c\2\2EF\7t\2\2F\20\3\2\2"+
		"\2GH\7?\2\2H\22\3\2\2\2IJ\7-\2\2J\24\3\2\2\2KL\7/\2\2L\26\3\2\2\2MN\7"+
		",\2\2N\30\3\2\2\2OP\7g\2\2PQ\7s\2\2QR\7w\2\2RS\7c\2\2ST\7n\2\2TU\7u\2"+
		"\2U\32\3\2\2\2VW\7#\2\2WX\7g\2\2XY\7s\2\2YZ\7w\2\2Z[\7c\2\2[\\\7n\2\2"+
		"\\]\7u\2\2]\34\3\2\2\2^_\7>\2\2_`\7>\2\2`\36\3\2\2\2ab\7@\2\2bc\7@\2\2"+
		"c \3\2\2\2df\4c|\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\"\3\2\2\2"+
		"ik\4\62;\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m$\3\2\2\2np\t\2\2\2"+
		"on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b\23\2\2t&\3\2\2"+
		"\2\6\2glq\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}