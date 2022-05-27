// Generated from /Users/ranjanbehl/Documents/Fall2021/ECE573/Project/fa2021-step4-ranjan/MicroC.g4 by ANTLR 4.8


package compiler;

import java.util.List;
import java.util.LinkedList;
import ast.*;
import compiler.Scope.*;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, IDENTIFIER=27, INT_LITERAL=28, FLOAT_LITERAL=29, STR_LITERAL=30, 
		COMMENT=31, WS=32;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_var_decls = 2, RULE_id = 3, RULE_var_decl = 4, 
		RULE_str_decl = 5, RULE_base_type = 6, RULE_func_decl = 7, RULE_functions = 8, 
		RULE_function = 9, RULE_params = 10, RULE_params_rest = 11, RULE_param = 12, 
		RULE_statements = 13, RULE_statement = 14, RULE_base_stmt = 15, RULE_read_stmt = 16, 
		RULE_print_stmt = 17, RULE_return_stmt = 18, RULE_assign_stmt = 19, RULE_if_stmt = 20, 
		RULE_else_stmt = 21, RULE_while_stmt = 22, RULE_primary = 23, RULE_unaryminus_expr = 24, 
		RULE_call_expr = 25, RULE_arg_list = 26, RULE_args_rest = 27, RULE_expr = 28, 
		RULE_term = 29, RULE_cond = 30, RULE_cmpop = 31, RULE_mulop = 32, RULE_addop = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "var_decls", "id", "var_decl", "str_decl", "base_type", 
			"func_decl", "functions", "function", "params", "params_rest", "param", 
			"statements", "statement", "base_stmt", "read_stmt", "print_stmt", "return_stmt", 
			"assign_stmt", "if_stmt", "else_stmt", "while_stmt", "primary", "unaryminus_expr", 
			"call_expr", "arg_list", "args_rest", "expr", "term", "cond", "cmpop", 
			"mulop", "addop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'string'", "'='", "'int'", "'float'", "'('", "')'", "'{'", 
			"'}'", "','", "'read'", "'print'", "'return'", "'if'", "'else'", "'while'", 
			"'-'", "'<'", "'<='", "'>='", "'=='", "'!='", "'>'", "'*'", "'/'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IDENTIFIER", "INT_LITERAL", "FLOAT_LITERAL", "STR_LITERAL", 
			"COMMENT", "WS"
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

	@Override
	public String getGrammarFileName() { return "MicroC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	     private SymbolTable st; //Symbol table for the program
	     private ASTNode ast; //AST for the program

	     public void setSymbolTable(SymbolTable st) {
	          this.st = st;
	     }

	     public SymbolTable getSymbolTable() {
	          return st;
	     }

	     public ASTNode getAST() {
	          return ast;
	     }

	     private void addParams(List<Scope.Type> types, List<String> names) {
	          /* Add parameters in reverse order so everything matches correctly */
	          for (int i = types.size() - 1; i >= 0; --i) {
	               st.addArgument(types.get(i), names.get(i));
	          }
	     }


	public MicroCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public FunctionsContext functions;
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			decls();
			setState(69);
			((ProgramContext)_localctx).functions = functions();
			ast = ((ProgramContext)_localctx).functions.node;
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

	public static class DeclsContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public Str_declContext str_decl() {
			return getRuleContext(Str_declContext.class,0);
		}
		public Func_declContext func_decl() {
			return getRuleContext(Func_declContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				var_decl();
				setState(73);
				decls();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				str_decl();
				setState(76);
				decls();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				func_decl();
				setState(79);
				decls();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
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

	public static class Var_declsContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public Var_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decls; }
	}

	public final Var_declsContext var_decls() throws RecognitionException {
		Var_declsContext _localctx = new Var_declsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decls);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				var_decl();
				setState(85);
				var_decls();
				}
				break;
			case T__8:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__15:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(IDENTIFIER);
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

	public static class Var_declContext extends ParserRuleContext {
		public Base_typeContext base_type;
		public IdContext id;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((Var_declContext)_localctx).base_type = base_type();
			setState(93);
			((Var_declContext)_localctx).id = id();
			setState(94);
			match(T__0);
			st.addVariable(((Var_declContext)_localctx).base_type.t, (((Var_declContext)_localctx).id!=null?_input.getText(((Var_declContext)_localctx).id.start,((Var_declContext)_localctx).id.stop):null));
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

	public static class Str_declContext extends ParserRuleContext {
		public IdContext id;
		public Token val;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode STR_LITERAL() { return getToken(MicroCParser.STR_LITERAL, 0); }
		public Str_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_decl; }
	}

	public final Str_declContext str_decl() throws RecognitionException {
		Str_declContext _localctx = new Str_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_str_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__1);
			setState(98);
			((Str_declContext)_localctx).id = id();
			setState(99);
			match(T__2);
			setState(100);
			((Str_declContext)_localctx).val = match(STR_LITERAL);
			setState(101);
			match(T__0);
			st.addVariable(Scope.Type.STRING, (((Str_declContext)_localctx).id!=null?_input.getText(((Str_declContext)_localctx).id.start,((Str_declContext)_localctx).id.stop):null), (((Str_declContext)_localctx).val!=null?((Str_declContext)_localctx).val.getText():null));
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

	public static class Base_typeContext extends ParserRuleContext {
		public Scope.Type t;
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_base_type);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(T__3);
				((Base_typeContext)_localctx).t =  Scope.Type.INT;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(T__4);
				((Base_typeContext)_localctx).t =  Scope.Type.FLOAT;
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

	public static class Func_declContext extends ParserRuleContext {
		public Base_typeContext base_type;
		public IdContext id;
		public ParamsContext params;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_func_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((Func_declContext)_localctx).base_type = base_type();
			setState(111);
			((Func_declContext)_localctx).id = id();
			setState(112);
			match(T__5);
			setState(113);
			((Func_declContext)_localctx).params = params();
			setState(114);
			match(T__6);
			setState(115);
			match(T__0);
			st.addFunction(((Func_declContext)_localctx).base_type.t, (((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null), ((Func_declContext)_localctx).params.types);
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

	public static class FunctionsContext extends ParserRuleContext {
		public FunctionListNode node;
		public FunctionContext function;
		public FunctionsContext functions;
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functions);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				((FunctionsContext)_localctx).function = function();
				setState(119);
				((FunctionsContext)_localctx).functions = functions();
				((FunctionsContext)_localctx).node =  new FunctionListNode(((FunctionsContext)_localctx).function.node, ((FunctionsContext)_localctx).functions.node);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				((FunctionsContext)_localctx).node =  new FunctionListNode();
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

	public static class FunctionContext extends ParserRuleContext {
		public FunctionNode node;
		public Base_typeContext base_type;
		public IdContext id;
		public ParamsContext params;
		public StatementsContext statements;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((FunctionContext)_localctx).base_type = base_type();
			setState(126);
			((FunctionContext)_localctx).id = id();
			setState(127);
			match(T__5);
			setState(128);
			((FunctionContext)_localctx).params = params();
			setState(129);
			match(T__6);

			           /* Add FunctionSymbolTable entry to global scope */
			          FunctionSymbolTableEntry ste = (FunctionSymbolTableEntry) st.getSymbolTableEntry((((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null));
			          if ((ste == null) || !ste.isDefined()) {
			               st.addFunction(((FunctionContext)_localctx).base_type.t, (((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null), ((FunctionContext)_localctx).params.types);          
			               ste = (FunctionSymbolTableEntry) st.getSymbolTableEntry((((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null));
			               ste.setDefined(true);
			          } else {
			               throw new Error("Function already defined");
			          }
			           st.pushScope((((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null));
			           addParams(((FunctionContext)_localctx).params.types, ((FunctionContext)_localctx).params.names);
			      
			setState(131);
			match(T__7);
			setState(132);
			var_decls();
			setState(133);
			((FunctionContext)_localctx).statements = statements();
			setState(134);
			match(T__8);

			          /* Create FunctionNode */
			          LocalScope funcScope = (LocalScope) st.currentScope();
			          ((FunctionContext)_localctx).node =  new FunctionNode(((FunctionContext)_localctx).statements.node, (((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null), funcScope);

			          /* Done with this scope, so pop the scope */
			          st.popScope();
			     
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

	public static class ParamsContext extends ParserRuleContext {
		public LinkedList<String> names;
		public LinkedList<Scope.Type> types;
		public ParamContext param;
		public Params_restContext params_rest;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Params_restContext params_rest() {
			return getRuleContext(Params_restContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				((ParamsContext)_localctx).param = param();
				setState(138);
				((ParamsContext)_localctx).params_rest = params_rest();

				               ((ParamsContext)_localctx).names =  new LinkedList<String>();
				               ((ParamsContext)_localctx).types =  new LinkedList<Scope.Type>();
				               _localctx.names.add(((ParamsContext)_localctx).param.name); _localctx.names.addAll(((ParamsContext)_localctx).params_rest.names);
				               _localctx.types.add(((ParamsContext)_localctx).param.type); _localctx.types.addAll(((ParamsContext)_localctx).params_rest.types);
				          
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				((ParamsContext)_localctx).names =  new LinkedList<String>(); ((ParamsContext)_localctx).types =  new LinkedList<Scope.Type>();
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

	public static class Params_restContext extends ParserRuleContext {
		public LinkedList<String> names;
		public LinkedList<Scope.Type> types;
		public ParamContext param;
		public Params_restContext params_rest;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Params_restContext params_rest() {
			return getRuleContext(Params_restContext.class,0);
		}
		public Params_restContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params_rest; }
	}

	public final Params_restContext params_rest() throws RecognitionException {
		Params_restContext _localctx = new Params_restContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_params_rest);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__9);
				setState(145);
				((Params_restContext)_localctx).param = param();
				setState(146);
				((Params_restContext)_localctx).params_rest = params_rest();

				               ((Params_restContext)_localctx).names =  new LinkedList<String>();
				               ((Params_restContext)_localctx).types =  new LinkedList<Scope.Type>();
				               _localctx.names.add(((Params_restContext)_localctx).param.name); _localctx.names.addAll(((Params_restContext)_localctx).params_rest.names);
				               _localctx.types.add(((Params_restContext)_localctx).param.type); _localctx.types.addAll(((Params_restContext)_localctx).params_rest.types);
				          
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				((Params_restContext)_localctx).names =  new LinkedList<String>(); ((Params_restContext)_localctx).types =  new LinkedList<Scope.Type>();
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

	public static class ParamContext extends ParserRuleContext {
		public String name;
		public Scope.Type type;
		public Base_typeContext base_type;
		public IdContext id;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			((ParamContext)_localctx).base_type = base_type();
			setState(153);
			((ParamContext)_localctx).id = id();
			((ParamContext)_localctx).name =  (((ParamContext)_localctx).id!=null?_input.getText(((ParamContext)_localctx).id.start,((ParamContext)_localctx).id.stop):null); ((ParamContext)_localctx).type =  ((ParamContext)_localctx).base_type.t;
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementListNode node;
		public StatementContext statement;
		public StatementsContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statements);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__15:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				((StatementsContext)_localctx).statement = statement();
				setState(157);
				((StatementsContext)_localctx).s = statements();
				((StatementsContext)_localctx).node =  new StatementListNode(((StatementsContext)_localctx).statement.node, ((StatementsContext)_localctx).s.node);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((StatementsContext)_localctx).node =  new StatementListNode();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementNode node;
		public Base_stmtContext base_stmt;
		public If_stmtContext if_stmt;
		public While_stmtContext while_stmt;
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				((StatementContext)_localctx).base_stmt = base_stmt();
				setState(164);
				match(T__0);
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).base_stmt.node;
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				((StatementContext)_localctx).if_stmt = if_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).if_stmt.node;
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				((StatementContext)_localctx).while_stmt = while_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).while_stmt.node;
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

	public static class Base_stmtContext extends ParserRuleContext {
		public StatementNode node;
		public Assign_stmtContext assign_stmt;
		public Read_stmtContext read_stmt;
		public Print_stmtContext print_stmt;
		public Return_stmtContext return_stmt;
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Base_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_stmt; }
	}

	public final Base_stmtContext base_stmt() throws RecognitionException {
		Base_stmtContext _localctx = new Base_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_base_stmt);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				((Base_stmtContext)_localctx).assign_stmt = assign_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).assign_stmt.node;
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				((Base_stmtContext)_localctx).read_stmt = read_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).read_stmt.node;
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				((Base_stmtContext)_localctx).print_stmt = print_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).print_stmt.node;
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				((Base_stmtContext)_localctx).return_stmt = return_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).return_stmt.node;
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

	public static class Read_stmtContext extends ParserRuleContext {
		public ReadNode node;
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__10);
			setState(190);
			match(T__5);
			setState(191);
			((Read_stmtContext)_localctx).id = id();
			setState(192);
			match(T__6);
			((Read_stmtContext)_localctx).node =  new ReadNode(new VarNode((((Read_stmtContext)_localctx).id!=null?_input.getText(((Read_stmtContext)_localctx).id.start,((Read_stmtContext)_localctx).id.stop):null)));
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

	public static class Print_stmtContext extends ParserRuleContext {
		public WriteNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(T__11);
			setState(196);
			match(T__5);
			setState(197);
			((Print_stmtContext)_localctx).expr = expr(0);
			setState(198);
			match(T__6);
			((Print_stmtContext)_localctx).node =  new WriteNode(((Print_stmtContext)_localctx).expr.node);
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

	public static class Return_stmtContext extends ParserRuleContext {
		public ReturnNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__12);
			setState(202);
			((Return_stmtContext)_localctx).expr = expr(0);
			((Return_stmtContext)_localctx).node =  new ReturnNode(((Return_stmtContext)_localctx).expr.node, st.getFunctionSymbol(st.currentScope().getName()));
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public AssignNode node;
		public IdContext id;
		public ExprContext expr;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			((Assign_stmtContext)_localctx).id = id();
			setState(206);
			match(T__2);
			setState(207);
			((Assign_stmtContext)_localctx).expr = expr(0);
			((Assign_stmtContext)_localctx).node =  new AssignNode(new VarNode((((Assign_stmtContext)_localctx).id!=null?_input.getText(((Assign_stmtContext)_localctx).id.start,((Assign_stmtContext)_localctx).id.stop):null)), ((Assign_stmtContext)_localctx).expr.node);
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

	public static class If_stmtContext extends ParserRuleContext {
		public IfStatementNode node;
		public CondContext cond;
		public StatementsContext statements;
		public Else_stmtContext else_stmt;
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Else_stmtContext else_stmt() {
			return getRuleContext(Else_stmtContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__13);
			setState(211);
			match(T__5);
			setState(212);
			((If_stmtContext)_localctx).cond = cond();
			setState(213);
			match(T__6);
			setState(214);
			match(T__7);
			setState(215);
			((If_stmtContext)_localctx).statements = statements();
			setState(216);
			match(T__8);
			setState(217);
			((If_stmtContext)_localctx).else_stmt = else_stmt();
			((If_stmtContext)_localctx).node =  new IfStatementNode(((If_stmtContext)_localctx).cond.node,((If_stmtContext)_localctx).statements.node,((If_stmtContext)_localctx).else_stmt.node);
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

	public static class Else_stmtContext extends ParserRuleContext {
		public StatementListNode node;
		public StatementsContext statements;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Else_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_stmt; }
	}

	public final Else_stmtContext else_stmt() throws RecognitionException {
		Else_stmtContext _localctx = new Else_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_else_stmt);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				match(T__14);
				setState(221);
				match(T__7);
				setState(222);
				((Else_stmtContext)_localctx).statements = statements();
				setState(223);
				match(T__8);
				((Else_stmtContext)_localctx).node =  ((Else_stmtContext)_localctx).statements.node;
				}
				break;
			case T__8:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__15:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				((Else_stmtContext)_localctx).node =  new StatementListNode();
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

	public static class While_stmtContext extends ParserRuleContext {
		public WhileNode node;
		public CondContext cond;
		public StatementsContext statements;
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__15);
			setState(230);
			match(T__5);
			setState(231);
			((While_stmtContext)_localctx).cond = cond();
			setState(232);
			match(T__6);
			setState(233);
			match(T__7);
			setState(234);
			((While_stmtContext)_localctx).statements = statements();
			setState(235);
			match(T__8);
			((While_stmtContext)_localctx).node =  new WhileNode(((While_stmtContext)_localctx).cond.node,((While_stmtContext)_localctx).statements.node);
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

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionNode node;
		public IdContext id;
		public ExprContext expr;
		public Unaryminus_exprContext unaryminus_expr;
		public Call_exprContext call_expr;
		public Token il;
		public Token fl;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unaryminus_exprContext unaryminus_expr() {
			return getRuleContext(Unaryminus_exprContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(MicroCParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(MicroCParser.FLOAT_LITERAL, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_primary);
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				((PrimaryContext)_localctx).id = id();
				((PrimaryContext)_localctx).node =  new VarNode((((PrimaryContext)_localctx).id!=null?_input.getText(((PrimaryContext)_localctx).id.start,((PrimaryContext)_localctx).id.stop):null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				match(T__5);
				setState(242);
				((PrimaryContext)_localctx).expr = expr(0);
				setState(243);
				match(T__6);
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).expr.node;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				((PrimaryContext)_localctx).unaryminus_expr = unaryminus_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).unaryminus_expr.node;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				((PrimaryContext)_localctx).call_expr = call_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).call_expr.node;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				((PrimaryContext)_localctx).il = match(INT_LITERAL);
				((PrimaryContext)_localctx).node =  new IntLitNode((((PrimaryContext)_localctx).il!=null?((PrimaryContext)_localctx).il.getText():null));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(254);
				((PrimaryContext)_localctx).fl = match(FLOAT_LITERAL);
				((PrimaryContext)_localctx).node =  new FloatLitNode((((PrimaryContext)_localctx).fl!=null?((PrimaryContext)_localctx).fl.getText():null));
				}
				break;
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

	public static class Unaryminus_exprContext extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unaryminus_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryminus_expr; }
	}

	public final Unaryminus_exprContext unaryminus_expr() throws RecognitionException {
		Unaryminus_exprContext _localctx = new Unaryminus_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unaryminus_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__16);
			setState(259);
			((Unaryminus_exprContext)_localctx).expr = expr(0);
			((Unaryminus_exprContext)_localctx).node =  new UnaryOpNode(((Unaryminus_exprContext)_localctx).expr.node,"-");
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

	public static class Call_exprContext extends ParserRuleContext {
		public CallNode node;
		public IdContext id;
		public Arg_listContext arg_list;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_call_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			((Call_exprContext)_localctx).id = id();
			setState(263);
			match(T__5);
			setState(264);
			((Call_exprContext)_localctx).arg_list = arg_list();
			setState(265);
			match(T__6);
			((Call_exprContext)_localctx).node =  new CallNode((((Call_exprContext)_localctx).id!=null?_input.getText(((Call_exprContext)_localctx).id.start,((Call_exprContext)_localctx).id.stop):null), ((Call_exprContext)_localctx).arg_list.args);
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

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExpressionNode> args;
		public ExprContext expr;
		public Args_restContext args_rest;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Args_restContext args_rest() {
			return getRuleContext(Args_restContext.class,0);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arg_list);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__16:
			case IDENTIFIER:
			case INT_LITERAL:
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				((Arg_listContext)_localctx).expr = expr(0);
				setState(269);
				((Arg_listContext)_localctx).args_rest = args_rest();
				((Arg_listContext)_localctx).args =  new LinkedList<ExpressionNode>(); _localctx.args.add(((Arg_listContext)_localctx).expr.node); _localctx.args.addAll(((Arg_listContext)_localctx).args_rest.args);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				((Arg_listContext)_localctx).args =  new LinkedList<ExpressionNode>();
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

	public static class Args_restContext extends ParserRuleContext {
		public List<ExpressionNode> args;
		public ExprContext expr;
		public Args_restContext args_rest;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Args_restContext args_rest() {
			return getRuleContext(Args_restContext.class,0);
		}
		public Args_restContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args_rest; }
	}

	public final Args_restContext args_rest() throws RecognitionException {
		Args_restContext _localctx = new Args_restContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_args_rest);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				match(T__9);
				setState(276);
				((Args_restContext)_localctx).expr = expr(0);
				setState(277);
				((Args_restContext)_localctx).args_rest = args_rest();
				((Args_restContext)_localctx).args =  new LinkedList<ExpressionNode>(); _localctx.args.add(((Args_restContext)_localctx).expr.node); _localctx.args.addAll(((Args_restContext)_localctx).args_rest.args);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				((Args_restContext)_localctx).args =  new LinkedList<ExpressionNode>();
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

	public static class ExprContext extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext e1;
		public TermContext term;
		public AddopContext addop;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(284);
			((ExprContext)_localctx).term = term(0);
			((ExprContext)_localctx).node =  ((ExprContext)_localctx).term.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(287);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(288);
					((ExprContext)_localctx).addop = addop();
					setState(289);
					((ExprContext)_localctx).term = term(0);
					((ExprContext)_localctx).node =  new BinaryOpNode(((ExprContext)_localctx).e1.node,((ExprContext)_localctx).term.node,(((ExprContext)_localctx).addop!=null?_input.getText(((ExprContext)_localctx).addop.start,((ExprContext)_localctx).addop.stop):null));
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ExpressionNode node;
		public TermContext t1;
		public PrimaryContext primary;
		public MulopContext mulop;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(298);
			((TermContext)_localctx).primary = primary();
			((TermContext)_localctx).node =  ((TermContext)_localctx).primary.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(301);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(302);
					((TermContext)_localctx).mulop = mulop();
					setState(303);
					((TermContext)_localctx).primary = primary();
					((TermContext)_localctx).node =  new BinaryOpNode(((TermContext)_localctx).t1.node,((TermContext)_localctx).primary.node,(((TermContext)_localctx).mulop!=null?_input.getText(((TermContext)_localctx).mulop.start,((TermContext)_localctx).mulop.stop):null));
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CondNode node;
		public ExprContext e1;
		public CmpopContext cmpop;
		public ExprContext e2;
		public CmpopContext cmpop() {
			return getRuleContext(CmpopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			((CondContext)_localctx).e1 = expr(0);
			setState(312);
			((CondContext)_localctx).cmpop = cmpop();
			setState(313);
			((CondContext)_localctx).e2 = expr(0);
			((CondContext)_localctx).node =  new CondNode(((CondContext)_localctx).e1.node,((CondContext)_localctx).e2.node,(((CondContext)_localctx).cmpop!=null?_input.getText(((CondContext)_localctx).cmpop.start,((CondContext)_localctx).cmpop.stop):null));
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

	public static class CmpopContext extends ParserRuleContext {
		public CmpopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpop; }
	}

	public final CmpopContext cmpop() throws RecognitionException {
		CmpopContext _localctx = new CmpopContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_cmpop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class MulopContext extends ParserRuleContext {
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !(_la==T__23 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class AddopContext extends ParserRuleContext {
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__25) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 29:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0145\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3U\n\3\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bo\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n~\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u0091\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0099\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u00a4\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00b0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00be\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00e6\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0103\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u0114\n\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u011c\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\7\36\u0127\n\36\f\36\16\36\u012a\13\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\7\37\u0135\n\37\f\37\16\37\u0138\13\37\3 \3 \3 \3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3#\2\4:<$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BD\2\5\3\2\24\31\3\2\32\33\4\2\23\23\34\34\2"+
		"\u013a\2F\3\2\2\2\4T\3\2\2\2\6Z\3\2\2\2\b\\\3\2\2\2\n^\3\2\2\2\fc\3\2"+
		"\2\2\16n\3\2\2\2\20p\3\2\2\2\22}\3\2\2\2\24\177\3\2\2\2\26\u0090\3\2\2"+
		"\2\30\u0098\3\2\2\2\32\u009a\3\2\2\2\34\u00a3\3\2\2\2\36\u00af\3\2\2\2"+
		" \u00bd\3\2\2\2\"\u00bf\3\2\2\2$\u00c5\3\2\2\2&\u00cb\3\2\2\2(\u00cf\3"+
		"\2\2\2*\u00d4\3\2\2\2,\u00e5\3\2\2\2.\u00e7\3\2\2\2\60\u0102\3\2\2\2\62"+
		"\u0104\3\2\2\2\64\u0108\3\2\2\2\66\u0113\3\2\2\28\u011b\3\2\2\2:\u011d"+
		"\3\2\2\2<\u012b\3\2\2\2>\u0139\3\2\2\2@\u013e\3\2\2\2B\u0140\3\2\2\2D"+
		"\u0142\3\2\2\2FG\5\4\3\2GH\5\22\n\2HI\b\2\1\2I\3\3\2\2\2JK\5\n\6\2KL\5"+
		"\4\3\2LU\3\2\2\2MN\5\f\7\2NO\5\4\3\2OU\3\2\2\2PQ\5\20\t\2QR\5\4\3\2RU"+
		"\3\2\2\2SU\3\2\2\2TJ\3\2\2\2TM\3\2\2\2TP\3\2\2\2TS\3\2\2\2U\5\3\2\2\2"+
		"VW\5\n\6\2WX\5\6\4\2X[\3\2\2\2Y[\3\2\2\2ZV\3\2\2\2ZY\3\2\2\2[\7\3\2\2"+
		"\2\\]\7\35\2\2]\t\3\2\2\2^_\5\16\b\2_`\5\b\5\2`a\7\3\2\2ab\b\6\1\2b\13"+
		"\3\2\2\2cd\7\4\2\2de\5\b\5\2ef\7\5\2\2fg\7 \2\2gh\7\3\2\2hi\b\7\1\2i\r"+
		"\3\2\2\2jk\7\6\2\2ko\b\b\1\2lm\7\7\2\2mo\b\b\1\2nj\3\2\2\2nl\3\2\2\2o"+
		"\17\3\2\2\2pq\5\16\b\2qr\5\b\5\2rs\7\b\2\2st\5\26\f\2tu\7\t\2\2uv\7\3"+
		"\2\2vw\b\t\1\2w\21\3\2\2\2xy\5\24\13\2yz\5\22\n\2z{\b\n\1\2{~\3\2\2\2"+
		"|~\b\n\1\2}x\3\2\2\2}|\3\2\2\2~\23\3\2\2\2\177\u0080\5\16\b\2\u0080\u0081"+
		"\5\b\5\2\u0081\u0082\7\b\2\2\u0082\u0083\5\26\f\2\u0083\u0084\7\t\2\2"+
		"\u0084\u0085\b\13\1\2\u0085\u0086\7\n\2\2\u0086\u0087\5\6\4\2\u0087\u0088"+
		"\5\34\17\2\u0088\u0089\7\13\2\2\u0089\u008a\b\13\1\2\u008a\25\3\2\2\2"+
		"\u008b\u008c\5\32\16\2\u008c\u008d\5\30\r\2\u008d\u008e\b\f\1\2\u008e"+
		"\u0091\3\2\2\2\u008f\u0091\b\f\1\2\u0090\u008b\3\2\2\2\u0090\u008f\3\2"+
		"\2\2\u0091\27\3\2\2\2\u0092\u0093\7\f\2\2\u0093\u0094\5\32\16\2\u0094"+
		"\u0095\5\30\r\2\u0095\u0096\b\r\1\2\u0096\u0099\3\2\2\2\u0097\u0099\b"+
		"\r\1\2\u0098\u0092\3\2\2\2\u0098\u0097\3\2\2\2\u0099\31\3\2\2\2\u009a"+
		"\u009b\5\16\b\2\u009b\u009c\5\b\5\2\u009c\u009d\b\16\1\2\u009d\33\3\2"+
		"\2\2\u009e\u009f\5\36\20\2\u009f\u00a0\5\34\17\2\u00a0\u00a1\b\17\1\2"+
		"\u00a1\u00a4\3\2\2\2\u00a2\u00a4\b\17\1\2\u00a3\u009e\3\2\2\2\u00a3\u00a2"+
		"\3\2\2\2\u00a4\35\3\2\2\2\u00a5\u00a6\5 \21\2\u00a6\u00a7\7\3\2\2\u00a7"+
		"\u00a8\b\20\1\2\u00a8\u00b0\3\2\2\2\u00a9\u00aa\5*\26\2\u00aa\u00ab\b"+
		"\20\1\2\u00ab\u00b0\3\2\2\2\u00ac\u00ad\5.\30\2\u00ad\u00ae\b\20\1\2\u00ae"+
		"\u00b0\3\2\2\2\u00af\u00a5\3\2\2\2\u00af\u00a9\3\2\2\2\u00af\u00ac\3\2"+
		"\2\2\u00b0\37\3\2\2\2\u00b1\u00b2\5(\25\2\u00b2\u00b3\b\21\1\2\u00b3\u00be"+
		"\3\2\2\2\u00b4\u00b5\5\"\22\2\u00b5\u00b6\b\21\1\2\u00b6\u00be\3\2\2\2"+
		"\u00b7\u00b8\5$\23\2\u00b8\u00b9\b\21\1\2\u00b9\u00be\3\2\2\2\u00ba\u00bb"+
		"\5&\24\2\u00bb\u00bc\b\21\1\2\u00bc\u00be\3\2\2\2\u00bd\u00b1\3\2\2\2"+
		"\u00bd\u00b4\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd\u00ba\3\2\2\2\u00be!\3"+
		"\2\2\2\u00bf\u00c0\7\r\2\2\u00c0\u00c1\7\b\2\2\u00c1\u00c2\5\b\5\2\u00c2"+
		"\u00c3\7\t\2\2\u00c3\u00c4\b\22\1\2\u00c4#\3\2\2\2\u00c5\u00c6\7\16\2"+
		"\2\u00c6\u00c7\7\b\2\2\u00c7\u00c8\5:\36\2\u00c8\u00c9\7\t\2\2\u00c9\u00ca"+
		"\b\23\1\2\u00ca%\3\2\2\2\u00cb\u00cc\7\17\2\2\u00cc\u00cd\5:\36\2\u00cd"+
		"\u00ce\b\24\1\2\u00ce\'\3\2\2\2\u00cf\u00d0\5\b\5\2\u00d0\u00d1\7\5\2"+
		"\2\u00d1\u00d2\5:\36\2\u00d2\u00d3\b\25\1\2\u00d3)\3\2\2\2\u00d4\u00d5"+
		"\7\20\2\2\u00d5\u00d6\7\b\2\2\u00d6\u00d7\5> \2\u00d7\u00d8\7\t\2\2\u00d8"+
		"\u00d9\7\n\2\2\u00d9\u00da\5\34\17\2\u00da\u00db\7\13\2\2\u00db\u00dc"+
		"\5,\27\2\u00dc\u00dd\b\26\1\2\u00dd+\3\2\2\2\u00de\u00df\7\21\2\2\u00df"+
		"\u00e0\7\n\2\2\u00e0\u00e1\5\34\17\2\u00e1\u00e2\7\13\2\2\u00e2\u00e3"+
		"\b\27\1\2\u00e3\u00e6\3\2\2\2\u00e4\u00e6\b\27\1\2\u00e5\u00de\3\2\2\2"+
		"\u00e5\u00e4\3\2\2\2\u00e6-\3\2\2\2\u00e7\u00e8\7\22\2\2\u00e8\u00e9\7"+
		"\b\2\2\u00e9\u00ea\5> \2\u00ea\u00eb\7\t\2\2\u00eb\u00ec\7\n\2\2\u00ec"+
		"\u00ed\5\34\17\2\u00ed\u00ee\7\13\2\2\u00ee\u00ef\b\30\1\2\u00ef/\3\2"+
		"\2\2\u00f0\u00f1\5\b\5\2\u00f1\u00f2\b\31\1\2\u00f2\u0103\3\2\2\2\u00f3"+
		"\u00f4\7\b\2\2\u00f4\u00f5\5:\36\2\u00f5\u00f6\7\t\2\2\u00f6\u00f7\b\31"+
		"\1\2\u00f7\u0103\3\2\2\2\u00f8\u00f9\5\62\32\2\u00f9\u00fa\b\31\1\2\u00fa"+
		"\u0103\3\2\2\2\u00fb\u00fc\5\64\33\2\u00fc\u00fd\b\31\1\2\u00fd\u0103"+
		"\3\2\2\2\u00fe\u00ff\7\36\2\2\u00ff\u0103\b\31\1\2\u0100\u0101\7\37\2"+
		"\2\u0101\u0103\b\31\1\2\u0102\u00f0\3\2\2\2\u0102\u00f3\3\2\2\2\u0102"+
		"\u00f8\3\2\2\2\u0102\u00fb\3\2\2\2\u0102\u00fe\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0103\61\3\2\2\2\u0104\u0105\7\23\2\2\u0105\u0106\5:\36\2\u0106\u0107"+
		"\b\32\1\2\u0107\63\3\2\2\2\u0108\u0109\5\b\5\2\u0109\u010a\7\b\2\2\u010a"+
		"\u010b\5\66\34\2\u010b\u010c\7\t\2\2\u010c\u010d\b\33\1\2\u010d\65\3\2"+
		"\2\2\u010e\u010f\5:\36\2\u010f\u0110\58\35\2\u0110\u0111\b\34\1\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0114\b\34\1\2\u0113\u010e\3\2\2\2\u0113\u0112\3"+
		"\2\2\2\u0114\67\3\2\2\2\u0115\u0116\7\f\2\2\u0116\u0117\5:\36\2\u0117"+
		"\u0118\58\35\2\u0118\u0119\b\35\1\2\u0119\u011c\3\2\2\2\u011a\u011c\b"+
		"\35\1\2\u011b\u0115\3\2\2\2\u011b\u011a\3\2\2\2\u011c9\3\2\2\2\u011d\u011e"+
		"\b\36\1\2\u011e\u011f\5<\37\2\u011f\u0120\b\36\1\2\u0120\u0128\3\2\2\2"+
		"\u0121\u0122\f\3\2\2\u0122\u0123\5D#\2\u0123\u0124\5<\37\2\u0124\u0125"+
		"\b\36\1\2\u0125\u0127\3\2\2\2\u0126\u0121\3\2\2\2\u0127\u012a\3\2\2\2"+
		"\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129;\3\2\2\2\u012a\u0128\3"+
		"\2\2\2\u012b\u012c\b\37\1\2\u012c\u012d\5\60\31\2\u012d\u012e\b\37\1\2"+
		"\u012e\u0136\3\2\2\2\u012f\u0130\f\3\2\2\u0130\u0131\5B\"\2\u0131\u0132"+
		"\5\60\31\2\u0132\u0133\b\37\1\2\u0133\u0135\3\2\2\2\u0134\u012f\3\2\2"+
		"\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137="+
		"\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\5:\36\2\u013a\u013b\5@!\2\u013b"+
		"\u013c\5:\36\2\u013c\u013d\b \1\2\u013d?\3\2\2\2\u013e\u013f\t\2\2\2\u013f"+
		"A\3\2\2\2\u0140\u0141\t\3\2\2\u0141C\3\2\2\2\u0142\u0143\t\4\2\2\u0143"+
		"E\3\2\2\2\21TZn}\u0090\u0098\u00a3\u00af\u00bd\u00e5\u0102\u0113\u011b"+
		"\u0128\u0136";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}