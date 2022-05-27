package ast;

import ast.visitor.ASTVisitor;
import compiler.LocalScope;

public class FunctionNode implements StatementNode {

    private StatementListNode funcBody;
    private String funcName;

    private LocalScope scope;
    
    public FunctionNode(StatementListNode funcBody, String funcName, LocalScope scope) {
        this.funcBody = funcBody;
        this.funcName = funcName;
        this.scope = scope;
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public StatementListNode getFuncBody() {
        return funcBody;
    }

    public void setFuncBody(StatementListNode funcBody) {
        this.funcBody = funcBody;
    }

    public String getFuncName() {
        return this.funcName;
    }

    public LocalScope getScope() {
        return scope;
    }
    
}