package ast;

import ast.visitor.ASTVisitor;
import compiler.Scope;

/**
 * Node associated with <code>return_stmt</code>
 * 
 * This has one child: the expression whose value is being returned
 */
public class ReturnNode implements StatementNode {
	
	private ExpressionNode retExpr;
	private Scope.FunctionSymbolTableEntry funcSymbol;

	public ReturnNode(ExpressionNode retExpr, Scope.FunctionSymbolTableEntry funcSymbol) {
		setRetExpr(retExpr);
		setFuncSymbol(funcSymbol);
	}
	
	@Override
	public <R> R accept(ASTVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public ExpressionNode getRetExpr() {
		return retExpr;
	}

	private void setRetExpr(ExpressionNode expr) {
		retExpr = expr;
	}

	public Scope.FunctionSymbolTableEntry getFuncSymbol() {
		return this.funcSymbol;
	}

	private void setFuncSymbol(Scope.FunctionSymbolTableEntry funcSymbol) {
		this.funcSymbol = funcSymbol;
	}

}