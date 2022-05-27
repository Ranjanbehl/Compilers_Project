package ast;

import compiler.Scope;

import ast.visitor.ASTVisitor;
import compiler.Compiler;

public class MallocNode extends AbstractCallNode {

    ExpressionNode arg;
    String funcName;
    Scope.FunctionSymbolTableEntry ste;

    public MallocNode(ExpressionNode arg) {
        this.ste = (Scope.FunctionSymbolTableEntry) Compiler.symbolTable.getFunctionSymbol(funcName);
        this.arg = arg;
        this.type = new Scope.Type(Scope.InnerType.INFER); //set this to infer
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