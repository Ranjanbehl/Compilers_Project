// Generated from MicroC.g4 by ANTLR 4.9.2

 

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MicroCParser}.
 */
public interface MicroCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MicroCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(MicroCParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(MicroCParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#var_decls}.
	 * @param ctx the parse tree
	 */
	void enterVar_decls(MicroCParser.Var_declsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#var_decls}.
	 * @param ctx the parse tree
	 */
	void exitVar_decls(MicroCParser.Var_declsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MicroCParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MicroCParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(MicroCParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(MicroCParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#str_decl}.
	 * @param ctx the parse tree
	 */
	void enterStr_decl(MicroCParser.Str_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#str_decl}.
	 * @param ctx the parse tree
	 */
	void exitStr_decl(MicroCParser.Str_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#base_type}.
	 * @param ctx the parse tree
	 */
	void enterBase_type(MicroCParser.Base_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#base_type}.
	 * @param ctx the parse tree
	 */
	void exitBase_type(MicroCParser.Base_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(MicroCParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(MicroCParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MicroCParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MicroCParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MicroCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MicroCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(MicroCParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(MicroCParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(MicroCParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(MicroCParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint_stmt(MicroCParser.Print_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint_stmt(MicroCParser.Print_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(MicroCParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(MicroCParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(MicroCParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(MicroCParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(MicroCParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(MicroCParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#if_else_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_else_stmt(MicroCParser.If_else_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#if_else_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_else_stmt(MicroCParser.If_else_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#else_stmt}.
	 * @param ctx the parse tree
	 */
	void enterElse_stmt(MicroCParser.Else_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#else_stmt}.
	 * @param ctx the parse tree
	 */
	void exitElse_stmt(MicroCParser.Else_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(MicroCParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(MicroCParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MicroCParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MicroCParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#unaryminus_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryminus_expr(MicroCParser.Unaryminus_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#unaryminus_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryminus_expr(MicroCParser.Unaryminus_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MicroCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MicroCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MicroCParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MicroCParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(MicroCParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(MicroCParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#cmpop}.
	 * @param ctx the parse tree
	 */
	void enterCmpop(MicroCParser.CmpopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#cmpop}.
	 * @param ctx the parse tree
	 */
	void exitCmpop(MicroCParser.CmpopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(MicroCParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(MicroCParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroCParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(MicroCParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroCParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(MicroCParser.AddopContext ctx);
}