package ast;

import ast.visitor.ASTVisitor;
import compiler.Scope;

/**
 * Integer literal node
 */
public class IntLitNode extends ExpressionNode {

	private String val;
	
	public IntLitNode(String val) {
		setVal(val);
		setType(new Scope.Type(Scope.InnerType.INT));
	}

	@Override
	public <R> R accept(ASTVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public String getVal() {
		return val;
	}

	private void setVal(String val) {
		this.val = val;
	}

}
