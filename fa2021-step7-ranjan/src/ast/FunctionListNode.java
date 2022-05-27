package ast;

import java.util.LinkedList;
import java.util.List;

import ast.visitor.ASTVisitor;

/**
 * Node for <code>statements</code>
 * 
 * This has a list of children, one for each statement
 */
public class FunctionListNode implements ASTNode {

	private List<FunctionNode> functions;
	
	/**
	 * An empty statement list node
	 */
	public FunctionListNode() {
		functions = new LinkedList<FunctionNode>();
	}
	
	/**
	 * A statement list node with one statement
	 * 
	 * @param f the statement
	 */
	public FunctionListNode(FunctionNode f) {
		functions = new LinkedList<FunctionNode>();
		functions.add(f);
	}
	
	/**
	 * A statement list node constructed of a statement followed by
	 * another statement list node.
	 * 
	 * @param f The first statement
	 * @param fl The rests of the statements
	 */
	public FunctionListNode(FunctionNode f, FunctionListNode fl) {
		functions = new LinkedList<FunctionNode>();
		functions.add(f);
		functions.addAll(fl.functions);
	}
	
	/**
	 * A statement list node constructed of a list of statements
	 * followed by a single statement.
	 * 
	 * @param fl The list of statements
	 * @param f The last statement
	 */
	public FunctionListNode(FunctionListNode fl, FunctionNode f) {
		functions = new LinkedList<FunctionNode>();
		functions.addAll(fl.functions);
		functions.add(f);
	}
	
	@Override
	public <R> R accept(ASTVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public List<FunctionNode> getFunctions() {return functions;}
	
}
