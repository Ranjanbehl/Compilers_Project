package ast.visitor;

import java.util.Collection;
import java.util.List;

import ast.ASTNode;
import ast.AssignNode;
import ast.BinaryOpNode;
import ast.CallNode;
import ast.WhileNode;
import ast.IfStatementNode;
import ast.IntLitNode;
import ast.ReadNode;
import ast.StatementListNode;
import ast.TypedASTNode;
import ast.VarNode;
import ast.WriteNode;
import compiler.LocalScope;
import compiler.Scope;
import compiler.Scope.FunctionSymbolTableEntry;
import compiler.Scope.SymbolTableEntry;
import compiler.Scope.Type;
import ast.ReturnNode;
import ast.CondNode;
import ast.ExpressionNode;
import ast.FunctionNode;
import ast.FloatLitNode;

public class TypeCheckVisitor extends AbstractASTVisitor<Scope.Type> {

	int depth;
	public TypeCheckVisitor() {depth = 0;}
	
	@Override
	public Type run(ASTNode node) {
		depth = 0;
		return node.accept(this);
	}
	
	@Override
	protected void preprocess(VarNode node) {
		printTabs();
		System.out.println("VarNode: " + node.getId());
	}

	@Override
	protected Type postprocess(VarNode node){
		return node.getType();
	}

	@Override
	protected void preprocess(IntLitNode node) {
		printTabs();
		System.out.println("IntLitNode: " + node.getVal());
	}

	@Override
	protected Type postprocess(IntLitNode node){
		return Type.INT;
	}

	@Override
	protected void preprocess(FloatLitNode node) {
		printTabs();
		System.out.println("FloatLitNode: " + node.getVal());
	}
	@Override
	protected  Type postprocess(FloatLitNode node){
		return Type.FLOAT;
	}

	@Override
	protected void preprocess(BinaryOpNode node) {
		printTabs();
		System.out.println("BinaryOpNode: " + node.getOp());
		depth++;
	}
	
	@Override
	protected Type postprocess(BinaryOpNode node, Type left, Type right) {
		--depth;  
        //   if(!(((ExpressionNode) node.getLeft()).getType()).equals(((ExpressionNode) node.getRight()).getType())){
        //       System.err.println("TYPE ERROR"); //print err to stderr
        //       System.exit(7);
        //  }
		if(!left.equals(right)){
			System.err.println("TYPE ERROR"); //print err to stderr
            System.exit(7);
		}
		return left;
	}
	
	@Override
	protected void preprocess(AssignNode node) {
		printTabs();
		System.out.println("AssignNode:");
		depth++;
	}
	
	@Override
	protected Type postprocess(AssignNode node, Type left, Type right) {
		--depth;
    //     if(!node.getLeft().getType().equals(node.getRight().getType())){
    //         System.err.println("TYPE ERROR"); //print err to stderr
    //         System.exit(7); 
    //    }
		if(!left.equals(right)){
			System.err.println("TYPE ERROR"); //print err to stderr
            System.exit(7); 	
		}
		
		return left;
		
		//return null;
	}
	
	private void printTabs() {
		for (int i = 0; i < depth; i++) {
			System.out.print("\t");
		}
	}

	@Override
	protected void preprocess(StatementListNode node) {
		printTabs();
		System.out.println("Statement list:");
		depth++;
	}

	@Override
	protected Type postprocess(StatementListNode node, List<Type> statements) {
		--depth;
		return null;
	}
	
	@Override
	protected void preprocess(ReadNode node) {
		printTabs();
		System.out.println("Read: ");
		depth++;
	}

	@Override
	protected void preprocess(WriteNode node) {
		printTabs();
		System.out.println("Write: ");
		depth++;
	}

	@Override
	protected Type postprocess(WriteNode node, Type writeExpr) {
		--depth;
		return writeExpr;
	}

	@Override
	protected Type postprocess(ReadNode node, Type var) {
		--depth;
		return var;
	}

	@Override
	protected void preprocess(ReturnNode node) {
		printTabs();
		System.out.println("Return: ");
		depth++;
	}

	@Override
	protected Type postprocess(ReturnNode node, Type retExpr) {
		--depth;
    //    if(!node.getFuncSymbol().getReturnType().equals(node.getRetExpr().getType())){
    //         System.err.println("TYPE ERROR"); //print err to stderr
    //         System.exit(7);  
    //    }
		if(!node.getFuncSymbol().getType().equals(retExpr)){
			System.err.println("TYPE ERROR"); //print err to stderr
            System.exit(7);	
		}
		return retExpr;
	}

	@Override
	protected void preprocess(CondNode node) {
		printTabs();
		System.out.println("Cond: " + node.getOp());
		depth++;
	}
	
	@Override
	protected Type postprocess(CondNode node, Type left, Type right) {
		--depth;
    //     if(!node.getLeft().getType().equals(node.getRight().getType())){
    //         System.err.println("TYPE ERROR"); //print err to stderr
    //         System.exit(7); 
    //    }
		if(!left.equals(right)){
			System.err.println("TYPE ERROR"); //print err to stderr
            System.exit(7);	
		}
		return left;
	}

	@Override
	protected void preprocess(IfStatementNode node) {
		printTabs();
		System.out.println("If ");
		depth++;
	}
	
	@Override
	protected Type postprocess(IfStatementNode node, Type cond, Type slist, Type epart) {
		--depth;
		return cond;
	}
	
	@Override
	protected void preprocess(WhileNode node) {
		printTabs();
		System.out.println("While: ");
		depth++;
	}
	
	@Override
	protected Type postprocess(WhileNode node, Type cond, Type slist) {
		--depth;
		return cond;
	}

	@Override
	protected void preprocess(FunctionNode node) {
		printTabs();
		System.out.println("Function " + node.getFuncName());
		depth++;
	}

	@Override
	protected Type postprocess(FunctionNode node, Type body) {
		--depth;
		return body;
	}

	@Override
	protected void preprocess(CallNode node) {
		printTabs();
		System.out.println("Function call " + node.getFuncName());
		depth++;
	}

	@Override
	protected Type postprocess(CallNode node, List<Type> args) {
		--depth;
        //  for(ExpressionNode arg : node.getArgs()){
        //      if(!arg.getType().equals(node.getType())){
        //          System.err.println("TYPE ERROR"); //print err to stderr
        //          System.exit(7);  
        //      }
        //  }
		List<Type> tmpList = node.getSte().getArgTypes();
		for(int i = 0; i < args.size(); i++){
			if(!tmpList.get(i).equals(args.get(i))){
				System.err.println("TYPE ERROR in call"); //print err to stderr
                System.exit(7); 	
			}
		}
		return node.getType();
	}

}