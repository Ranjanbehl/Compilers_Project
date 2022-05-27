package compiler;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import compiler.Scope.FunctionSymbolTableEntry;

public class SymbolTable {
	
	private Scope globalScope;
	private Stack<Scope> scopeStack;
	private LinkedList<String> errors;

	public SymbolTable() {
		this(0x10000000, 0x20000000);
	}

	public SymbolTable(int stringBase, int globalBase) {
		setGlobalScope(new GlobalScope(stringBase, globalBase));

		scopeStack = new Stack<Scope>();
		scopeStack.push(getGlobalScope());

		errors = new LinkedList<String>();
	}
	
	public Scope currentScope() {
		return scopeStack.peek();
	}
	
	public void addVariable(Scope.Type type, String name, String value) {
		assert(type == Scope.Type.STRING);
		Scope.ErrorType e = currentScope().addSymbol(type, name, value);
	    processError(name, e);
	}

	public void addVariable(Scope.Type type, String name) {
		assert (type != Scope.Type.STRING);
		Scope.ErrorType e = currentScope().addSymbol(type, name);
		if (e != Scope.ErrorType.NONE) {
			System.out.println("Found " + e + " adding " + type + " " + name);
		}
	    processError(name, e);
	}

	public void addArgument(Scope.Type type, String name) {
		assert(currentScope() instanceof LocalScope);

		LocalScope ls = (LocalScope) currentScope();
		Scope.ErrorType e = ls.addArgument(type, name);
		processError(name, e);
	}

	public void addFunction(Scope.Type returnType, String name, List<Scope.Type> argTypes) {
		assert(currentScope() instanceof GlobalScope);
		GlobalScope gs = (GlobalScope) currentScope();
		Scope.ErrorType e = gs.addFunctionSymbol(returnType, name, argTypes);
		processError(name, e);
	}

	public Scope.SymbolTableEntry getSymbolTableEntry(String name) {
		return currentScope().getSymbolTableEntry(name);
	}

	public Scope.FunctionSymbolTableEntry getFunctionSymbol(String name) {
		Scope.SymbolTableEntry ste = globalScope.getSymbolTableEntry(name);

		assert(ste != null);
		assert(ste instanceof FunctionSymbolTableEntry);

		return (Scope.FunctionSymbolTableEntry) ste;
	}
	
	public void pushScope(String name) {
		Scope s = currentScope().addSubScope(name);
		scopeStack.push(s);
	}
	
	public void popScope() {
		scopeStack.pop();
	}
	
	public void processError(String name, Scope.ErrorType e) {
		switch(e) {
			case NONE : return;
			case REDEC : return;
			case SHADOW :
				errors.add("SHADOW WARNING " + name);
				break;
			case ERROR :
				errors.add("DECLARATION ERROR " + name);
				printErrors();
				System.exit(1);
				break;
		}
	}
	
	public void printErrors() {
		for (String error : errors) {
			System.out.println(error);
		}
	}
	
	public void printTable() {
		getGlobalScope().printTable();
	}
	
	public Scope getGlobalScope() {
		return globalScope;
	}

	public void setGlobalScope(Scope globalScope) {
		this.globalScope = globalScope;
	}

	public static void main(String args[]) {
		SymbolTable st =  new SymbolTable();

		st.addVariable(Scope.Type.INT, "x");
		st.addVariable(Scope.Type.INT, "y");
		st.addVariable(Scope.Type.STRING, "z", "Hello");
		st.addVariable(Scope.Type.STRING, "w", "World");

		st.printTable();
	}

}
