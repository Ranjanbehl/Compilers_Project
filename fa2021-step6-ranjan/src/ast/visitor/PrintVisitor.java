package ast.visitor;

import java.util.List;

import ast.ASTNode;
import ast.AddrOfNode;
import ast.AssignNode;
import ast.BinaryOpNode;
import ast.CallNode;
import ast.WhileNode;
import ast.IfStatementNode;
import ast.IntLitNode;
import ast.MallocNode;
import ast.PtrDerefNode;
import ast.ReadNode;
import ast.StatementListNode;
import ast.VarNode;
import ast.WriteNode;
import ast.ReturnNode;
import ast.CondNode;
import ast.FunctionNode;
import ast.FloatLitNode;
import ast.FreeNode;

public class PrintVisitor extends AbstractASTVisitor<Void> {

	int depth;
	
	public PrintVisitor() {depth = 0;}
	
	@Override
	public Void run(ASTNode node) {
		depth = 0;
		return node.accept(this);
	}
	
	@Override
	protected void preprocess(VarNode node) {
		printTabs();
		System.out.println("VarNode: " + node.getId());
	}

	@Override
	protected void preprocess(IntLitNode node) {
		printTabs();
		System.out.println("IntLitNode: " + node.getVal());
	}

	@Override
	protected void preprocess(FloatLitNode node) {
		printTabs();
		System.out.println("FloatLitNode: " + node.getVal());
	}

	@Override
	protected void preprocess(BinaryOpNode node) {
		printTabs();
		System.out.println("BinaryOpNode: " + node.getOp());
		depth++;
	}
	
	@Override
	protected Void postprocess(BinaryOpNode node, Void left, Void right) {
		--depth;
		return null;
	}
	
	@Override
	protected void preprocess(AssignNode node) {
		printTabs();
		System.out.println("AssignNode:");
		depth++;
	}
	
	@Override
	protected Void postprocess(AssignNode node, Void left, Void right) {
		--depth;
		return null;
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
	protected Void postprocess(StatementListNode node, List<Void> statements) {
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
	protected Void postprocess(WriteNode node, Void writeExpr) {
		--depth;
		return null;
	}

	@Override
	protected Void postprocess(ReadNode node, Void var) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(ReturnNode node) {
		printTabs();
		System.out.println("Return: ");
		depth++;
	}

	@Override
	protected Void postprocess(ReturnNode node, Void retExpr) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(CondNode node) {
		printTabs();
		System.out.println("Cond: " + node.getOp());
		depth++;
	}
	
	@Override
	protected Void postprocess(CondNode node, Void left, Void right) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(IfStatementNode node) {
		printTabs();
		System.out.println("If ");
		depth++;
	}
	
	@Override
	protected Void postprocess(IfStatementNode node, Void cond, Void slist, Void epart) {
		--depth;
		return null;
	}
	
	@Override
	protected void preprocess(WhileNode node) {
		printTabs();
		System.out.println("While: ");
		depth++;
	}
	
	@Override
	protected Void postprocess(WhileNode node, Void cond, Void slist) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(FunctionNode node) {
		printTabs();
		System.out.println("Function " + node.getFuncName());
		depth++;
	}

	@Override
	protected Void postprocess(FunctionNode node, Void body) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(CallNode node) {
		printTabs();
		System.out.println("Function call " + node.getFuncName());
		depth++;
	}

	@Override
	protected Void postprocess(CallNode node, List<Void> args) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(PtrDerefNode node) {
		printTabs();
		System.out.println("PtrDeref: ");
		depth++;
	}

	@Override
	protected Void postprocess(PtrDerefNode node, Void expr) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(AddrOfNode node) {
		printTabs();
		System.out.println("AddrOf: ");
		depth++;
	}

	@Override
	protected Void postprocess(AddrOfNode node, Void expr) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(MallocNode node) {
		printTabs();
		System.out.println("Malloc: ");
		depth++;
	}

	@Override
	protected Void postprocess(MallocNode node, Void expr) {
		--depth;
		return null;
	}

	@Override
	protected void preprocess(FreeNode node) {
		printTabs();
		System.out.println("Malloc: ");
		depth++;
	}

	@Override
	protected Void postprocess(FreeNode node, Void expr) {
		--depth;
		return null;
	}

}
