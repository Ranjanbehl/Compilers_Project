package ast;

import compiler.Scope;

import ast.visitor.ASTVisitor;
import compiler.Compiler;

public class FreeNode extends AbstractCallNode {

    ExpressionNode arg;
    String funcName;
    Scope.FunctionSymbolTableEntry ste;

    public FreeNode(ExpressionNode arg) {
        this.ste = (Scope.FunctionSymbolTableEntry) Compiler.symbolTable.getFunctionSymbol(funcName);
        this.arg = arg;
        this.type = new Scope.Type(Scope.InnerType.VOID); //set this to void
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public ExpressionNode getArg() {
        return arg;
    }

    public String getFuncName() {
        return funcName;
    }
    
}