package ast;

import ast.visitor.ASTVisitor;
import compiler.Scope;

/**
 * A node for unary expressions (negation)
 * 
 * This has one child: the {@link ExpressionNode} being operated on
 */
public class PtrDerefNode extends ExpressionNode {
	
	private ExpressionNode expr;
	
	public PtrDerefNode(ExpressionNode expr) {
		this.setExpr(expr);
		//Fix the type up. If the type of expr is * T, the type of this is T
		assert(expr.getType().type == Scope.InnerType.PTR);
		this.setType(expr.getType().getWrappedType());
	}

	@Override
	public <R> R accept(ASTVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public ASTNode getExpr() {
		return expr;
	}

	private void setExpr(ExpressionNode right) {
		this.expr = right;
	}
}
