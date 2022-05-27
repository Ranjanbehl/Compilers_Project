package ast;

import compiler.Scope;

import java.util.List;

import ast.visitor.ASTVisitor;
import compiler.Compiler;

public class CallNode extends AbstractCallNode {

    List<ExpressionNode> args;
    String funcName;
    Scope.FunctionSymbolTableEntry ste;

    public CallNode(String funcName, List<ExpressionNode> args) {
        this.ste = (Scope.FunctionSymbolTableEntry) Compiler.symbolTable.getFunctionSymbol(funcName);
        this.funcName = funcName;
        this.args = args;
        this.type = ste.getReturnType();
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public List<ExpressionNode> getArgs() {
        return args;
    }

    public String getFuncName() {
        return funcName;
    }
    public Scope.FunctionSymbolTableEntry getSte(){
        return ste;
    }

}