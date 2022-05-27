package ast;

import ast.visitor.ASTVisitor;
import compiler.Scope;

public class CastExprNode extends ExpressionNode{
    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }
    private ExpressionNode expr;
    public CastExprNode(Scope.Type type,ExpressionNode expr){
        this.type = type;
        this.expr = expr;
       // this.expr.type = new Scope.Type(this.type);
    }

    public TypedASTNode getNode(){
        return expr;
    }
}
