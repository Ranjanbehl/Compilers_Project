package assembly;

import java.util.List;

import compiler.Scope.InnerType;
import compiler.Scope.SymbolTableEntry;
import ast.visitor.AbstractASTVisitor;

import ast.*;
import assembly.instructions.*;
import compiler.Scope;

public class CodeGenerator extends AbstractASTVisitor<CodeObject> {

	int intRegCount;
	int floatRegCount;
	static final public char intTempPrefix = 't';
	static final public char floatTempPrefix = 'f';
	
	int loopLabel;
	int elseLabel;
	int outLabel;

	String currFunc;
	
	public CodeGenerator() {
		loopLabel = 0;
		elseLabel = 0;
		outLabel = 0;
		intRegCount = 0;		
		floatRegCount = 0;
	}

	public int getIntRegCount() {
		return intRegCount;
	}

	public int getFloatRegCount() {
		return floatRegCount;
	}
	
	/**
	 * Generate code for Variables
	 * 
	 * Create a code object that just holds a variable
	 * 
	 * Important: add a pointer from the code object to the symbol table entry
	 *            so we know how to generate code for it later (we'll need to find
	 *            the address)
	 * 
	 * Mark the code object as holding a variable, and also as an lval
	 */
	@Override
	protected CodeObject postprocess(VarNode node) {
		
		Scope.SymbolTableEntry sym = node.getSymbol();
		
		CodeObject co = new CodeObject(sym);
		co.lval = true;
		co.type = node.getType();

		return co;
	}

	/** Generate code for IntLiterals
	 * 
	 * Use load immediate instruction to do this.
	 */
	@Override
	protected CodeObject postprocess(IntLitNode node) {
		CodeObject co = new CodeObject();
		
		//Load an immediate into a register
		//The li and la instructions are the same, but it's helpful to distinguish
		//for readability purposes.
		//li tmp' value
		Instruction i = new Li(generateTemp(Scope.InnerType.INT), node.getVal());

		co.code.add(i); //add this instruction to the code object
		co.lval = false; //co holds an rval -- data
		co.temp = i.getDest(); //temp is in destination of li
		co.type = node.getType();

		return co;
	}

	/** Generate code for FloatLiteras
	 * 
	 * Use load immediate instruction to do this.
	 */
	@Override
	protected CodeObject postprocess(FloatLitNode node) {
		CodeObject co = new CodeObject();
		
		//Load an immediate into a regisster
		//The li and la instructions are the same, but it's helpful to distinguish
		//for readability purposes.
		//li tmp' value
		Instruction i = new FImm(generateTemp(Scope.InnerType.FLOAT), node.getVal());

		co.code.add(i); //add this instruction to the code object
		co.lval = false; //co holds an rval -- data
		co.temp = i.getDest(); //temp is in destination of li
		co.type = node.getType();

		return co;
	}

	/**
	 * Generate code for binary operations.
	 * 
	 * Step 0: create new code object
	 * Step 1: add code from left child
	 * Step 1a: if left child is an lval, add a load to get the data
	 * Step 2: add code from right child
	 * Step 2a: if right child is an lval, add a load to get the data
	 * Step 3: generate binary operation using temps from left and right
	 * 
	 * Don't forget to update the temp and lval fields of the code object!
	 * 	   Hint: where is the result stored? Is this data or an address?
	 * 
	 */
	@Override
	protected CodeObject postprocess(BinaryOpNode node, CodeObject left, CodeObject right) {

		CodeObject co = new CodeObject();
		
		/* FILL IN FROM STEP 2 */
		if(left.lval){
			left = rvalify(left);
		}
		co.code.addAll(left.code);
		if(right.lval){
			right = rvalify(right);
		}
		co.code.addAll(right.code);
		InstructionList il = new InstructionList();
		String newTemp;
		newTemp = generateTemp(left.getType().type); 
		switch(node.getOp()) {
			case ADD: 	
				switch(left.getType().type){
					case PTR:	
					case INT: 
						//Code to generate binary INT ADD operation:
						Instruction addi = new Add(left.temp, right.temp, newTemp); 
						il.add(addi);
						break;
					case FLOAT:
						//Code to generate binary FLOAT ADD operation:
						Instruction addf = new FAdd(left.temp, right.temp, newTemp);
						il.add(addf);
						break;
					default:
						throw new Error("Must be an INT or FLOAT!");
					}
			break;
				case SUB:
					switch(left.getType().type){	
						case PTR:		
						case INT: 
						//Code to generate binary INT SUB operation:
						Instruction subi = new Sub(left.temp, right.temp, newTemp);
						il.add(subi);
						break;
					case FLOAT:
						//Code to generate binary FlOAT SUB operation:
						Instruction subf = new FSub(left.temp, right.temp, newTemp);
						il.add(subf);
						break;
					default:
						throw new Error("Must be an INT or FLOAT!");
					}
			break;
			case MUL:
					switch(left.getType().type){
					case PTR:
					case INT: 
						///Code to generate binary INT MUL operation:
						Instruction muli = new Mul(left.temp, right.temp, newTemp);
						il.add(muli);
						break;
					case FLOAT:
						//Code to generate binary FLOAT MUL operation:
						Instruction mulf = new FMul(left.temp, right.temp, newTemp);
						il.add(mulf);
						break;
					default:
						throw new Error("Must be an INT or FLOAT!");
					}
			break;
			case DIV:
				switch(left.getType().type){
					case PTR:
					case INT: 
					//Code to generate binary INT DIV operation:
					Instruction divi = new Div(left.temp, right.temp, newTemp);
					il.add(divi);
					break;
				case FLOAT:
					//Code to generate binary FLOAT DIV operation:
					Instruction divf = new FDiv(left.temp, right.temp, newTemp);
					il.add(divf);
					break;
				default:
					throw new Error("Must be an INT or FLOAT!");
				}
			break;
			default:
				throw new Error("Binary operation should only be ADD,SUB,MUL,and DIV!");
		}
		

		co.code.addAll(il);
		co.lval = false; 
		co.temp = newTemp; 
		//System.out.println("\nbinary" + left.getType());
		co.type = left.getType();	
		return co;
	}

	/**
	 * Generate code for unary operations.
	 * 
	 * Step 0: create new code object
	 * Step 1: add code from child expression
	 * Step 1a: if child is an lval, add a load to get the data
	 * Step 2: generate instruction to perform unary operation
	 * 
	 * Don't forget to update the temp and lval fields of the code object!
	 * 	   Hint: where is the result stored? Is this data or an address?
	 * 
	 */
	@Override
	protected CodeObject postprocess(UnaryOpNode node, CodeObject expr) {
		
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 2 */
		if(expr.lval){
		expr = rvalify(expr);
		 }
		co.code.addAll(expr.code);
		InstructionList il = new InstructionList();
		String newTemp;
		newTemp = generateTemp(expr.getType().type);
		switch(expr.getType().type) {
			case PTR:
			case INT: 
				//Code to generate negative INT:
				//neg tmp
				Instruction negi = new Neg(expr.temp, newTemp);
				il.add(negi);
				break;
			case FLOAT:
				//Code to generate negative FLOAT:
				// neg tmp
				Instruction negf = new FNeg(expr.temp, newTemp);
				il.add(negf);
				break;
			default:
				throw new Error("Must be an INT or FLOAT!");
		}
		co.code.addAll(il);

		co.lval = false; 
		co.temp = newTemp;  
		co.type = expr.getType();
		return co;
	}

	/**
	 * Generate code for assignment statements
	 * 
	 * Step 0: create new code object
	 * Step 1: if LHS is a variable, generate a load instruction to get the address into a register
	 * Step 1a: add code from LHS of assignment (make sure it results in an lval!)
	 * Step 2: add code from RHS of assignment
	 * Step 2a: if right child is an lval, add a load to get the data
	 * Step 3: generate store
	 * 
	 * Hint: it is going to be easiest to just generate a store with a 0 immediate
	 * offset, and the complete store address in a register:
	 * 
	 * sw rhs 0(lhs)
	 */
	@Override
	protected CodeObject postprocess(AssignNode node, CodeObject left,
			CodeObject right) {
		
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 2 */
		assert(left.lval == true); //left hand side had better hold an address

		//Step 1a
		if(left.isVar())	{
			InstructionList lcoIl = generateAddrFromVariable(left); // used to be codeobject!
			left.temp = lcoIl.getLast().getDest(); 
			co.code.addAll(lcoIl);
		}

		co.code.addAll(left.code); //how do I make sure it results in an lval?
		if(right.lval){
			right = rvalify(right);
		}
		co.code.addAll(right.code);

		InstructionList il = new InstructionList();		
		switch(left.getType().type){	
			case FLOAT:
					Instruction swf = new Fsw(right.temp,left.temp, "0");
					il.add(swf);
					break;	
			default:
					//PTR and INT are both 4 bytes so can use the same instruction but think about float PTRs?
					co.code.add(new Label("testing line 356"));
					Instruction swi = new Sw(right.temp,left.temp, "0"); 
					il.add(swi);
					break;
		}
		co.code.addAll(il);
		co.lval = true;  
		co.temp = left.temp; 
		if(left.getType().type == Scope.InnerType.PTR){
			co.type = left.getType().getWrappedType();
		}
		else{
			co.type = left.getType();
		}
		return co;
	}

	/**
	 * Add together all the lists of instructions generated by the children
	 */
	@Override
	protected CodeObject postprocess(StatementListNode node,
			List<CodeObject> statements) {
		CodeObject co = new CodeObject();
		//add the code from each individual statement
		for (CodeObject subcode : statements) {
			co.code.addAll(subcode.code);
		}
		co.type = null; //set to null to trigger errors
		return co;
	}
	
	/**
	 * Generate code for read
	 * 
	 * Step 0: create new code object
	 * Step 1: add code from VarNode (make sure it's an lval)
	 * Step 2: generate GetI instruction, storing into temp
	 * Step 3: generate store, to store temp in variable
	 */
	@Override
	protected CodeObject postprocess(ReadNode node, CodeObject var) {
		
		//Step 0
		CodeObject co = new CodeObject();

		//Generating code for read(id)
		assert(var.getSTE() != null); //var had better be a variable

		InstructionList il = new InstructionList();
		switch(node.getType().type) {
			case INT: 
				//Code to generate if INT:
				//geti tmp
				//if var is global: la tmp', <var>; sw tmp 0(tmp')
				//if var is local: sw tmp offset(fp)
				Instruction geti = new GetI(generateTemp(Scope.InnerType.INT));
				il.add(geti);
				InstructionList store = new InstructionList();
				if (var.getSTE().isLocal()) {
					co.code.add(new Label("testing line 419"));
					store.add(new Sw(geti.getDest(), "fp", String.valueOf(var.getSTE().addressToString())));
				} else {
					store.addAll(generateAddrFromVariable(var));
					co.code.add(new Label("testing line 422"));	
					store.add(new Sw(geti.getDest(), store.getLast().getDest(), "0"));
				}
				il.addAll(store);
				break;
			case FLOAT:
				//Code to generate if FLOAT:
				//getf tmp
				//if var is global: la tmp', <var>; fsw tmp 0(tmp')
				//if var is local: fsw tmp offset(fp)
				Instruction getf = new GetF(generateTemp(Scope.InnerType.FLOAT));
				il.add(getf);
				InstructionList fstore = new InstructionList();
				if (var.getSTE().isLocal()) {
					fstore.add(new Fsw(getf.getDest(), "fp", String.valueOf(var.getSTE().addressToString())));
				} else {
					fstore.addAll(generateAddrFromVariable(var));
					fstore.add(new Fsw(getf.getDest(), fstore.getLast().getDest(), "0"));
				}
				il.addAll(fstore);
				break;
			default:
				throw new Error("Shouldn't read into other variable");
		}
		
		co.code.addAll(il);

		co.lval = false; //doesn't matter
		co.temp = null; //set to null to trigger errors
		co.type = null; //set to null to trigger errors

		return co;
	}

	/**
	 * Generate code for print
	 * 
	 * Step 0: create new code object
	 * 
	 * If printing a string:
	 * Step 1: add code from expression to be printed (make sure it's an lval)
	 * Step 2: generate a PutS instruction printing the result of the expression
	 * 
	 * If printing an integer:
	 * Step 1: add code from the expression to be printed
	 * Step 1a: if it's an lval, generate a load to get the data
	 * Step 2: Generate PutI that prints the temporary holding the expression
	 */
	@Override
	protected CodeObject postprocess(WriteNode node, CodeObject expr) {
		CodeObject co = new CodeObject();

		//generating code for write(expr)

		//for strings, we expect a variable
		if (node.getWriteExpr().getType().type == Scope.InnerType.STRING) {
			//Step 1:
			assert(expr.getSTE() != null);
			
			System.out.println("; generating code to print " + expr.getSTE());

			//Get the address of the variable
			InstructionList addrCo = generateAddrFromVariable(expr);
			co.code.addAll(addrCo);

			//Step 2:
			Instruction write = new PutS(addrCo.getLast().getDest());
			co.code.add(write);
		} else {
			//Step 1a:
			//if expr is an lval, load from it
			if (expr.lval == true) {
				expr = rvalify(expr);
			}
			
			//Step 1:
			co.code.addAll(expr.code);

			//Step 2:
			//if type of writenode is int, use puti, if float, use putf
			Instruction write = null;
			switch(node.getWriteExpr().getType().type) {
			case STRING: throw new Error("Shouldn't have a STRING here");
			case INT: 
			case PTR: //should work the same way for pointers
				write = new PutI(expr.temp); break;
			case FLOAT: write = new PutF(expr.temp); break;
			default: throw new Error("WriteNode has a weird type");
			}

			co.code.add(write);
		}

		co.lval = false; //doesn't matter
		co.temp = null; //set to null to trigger errors
		co.type = null; //set to null to trigger errors

		return co;
	}

	/**
	 * FILL IN FROM STEP 3
	 * 
	 * Generating an instruction sequence for a conditional expression
	 * 
	 * Implement this however you like. One suggestion:
	 *
	 * Create the code for the left and right side of the conditional, but defer
	 * generating the branch until you process IfStatementNode or WhileNode (since you
	 * do not know the labels yet). Modify CodeObject so you can save the necessary
	 * information to generate the branch instruction in IfStatementNode or WhileNode
	 * 
	 * Alternate idea 1:
	 * 
	 * Don't do anything as part of CodeGenerator. Create a new visitor class
	 * that you invoke *within* your processing of IfStatementNode or WhileNode
	 * 
	 * Alternate idea 2:
	 * 
	 * Create the branch instruction in this function, then tweak it as necessary in
	 * IfStatementNode or WhileNode
	 * 
	 * Hint: you may need to preserve extra information in the returned CodeObject to
	 * make sure you know the type of branch code to generate (int vs float)
	 */
	@Override
	protected CodeObject postprocess(CondNode node, CodeObject left, CodeObject right) {
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 3*/
		if(left.lval){
			left = rvalify(left);
		}
		co.code.addAll(left.code);
		co.leftTemp = left.temp;
	
		if(right.lval){
			right = rvalify(right);
		}
		co.code.addAll(right.code);
		co.rightTemp = right.temp;
		co.op = node.getOp();
		co.type = left.getType(); 
		co.temp = left.temp;
		return co;
	}

	/**
	 * FILL IN FROM STEP 3
	 * 
	 * Step 0: Create code object
	 * 
	 * Step 1: generate labels
	 * 
	 * Step 2: add code from conditional expression
	 * 
	 * Step 3: create branch statement (if not created as part of step 2)
	 * 			don't forget to generate correct branch based on type
	 * 
	 * Step 4: generate code
	 * 		<cond code>
	 *		<flipped branch> elseLabel
	 *		<then code>
	 *		j outLabel
	 *		elseLabel:
	 *		<else code>
	 *		outLabel:
	 *
	 * Step 5 insert code into code object in appropriate order.
	 */
	@Override
	protected CodeObject postprocess(IfStatementNode node, CodeObject cond, CodeObject tlist, CodeObject elist) {
		//Step 0:
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 3*/
		//Step 1 generate labels
		String oLabel = generateOutLabel();
		String eLabel = generateElseLabel();
		//step 2 add code from conditional expression
		co.code.addAll(cond.code);
		// step 3 create branch statement
		InstructionList il = new InstructionList();
		Instruction else_label = new Label(eLabel);
		String intTemp = generateTemp(Scope.InnerType.INT);
		switch (cond.getType().type){
			case FLOAT:
			switch (cond.getOp()){
				case EQ:
					Instruction feq = new Feq(cond.getLeft(),cond.getRight(),intTemp);
					il.add(feq);
					Instruction bne = new Bne(intTemp,"x0",else_label.label);
					il.add(bne);
					break;
				case NE:
					Instruction fneq = new Feq(cond.getLeft(),cond.getLeft(),intTemp); 
					il.add(fneq);
					Instruction beq = new Beq(intTemp,"x0",else_label.label);
					il.add(beq);
					break;	
				case LT:
					Instruction fge = new Fle(cond.getRight(),cond.getLeft(),intTemp);
					il.add(fge);
					Instruction bne0 = new Bne(intTemp,"x0",else_label.label);
					il.add(bne0);
					break;
				case LE:
					Instruction fgt = new Flt(cond.getRight(),cond.getLeft(),intTemp);
					il.add(fgt);
					Instruction bne1 = new Bne(intTemp,"x0",else_label.label);
					il.add(bne1);
					break;
				case GT:
					Instruction fle = new Fle(cond.getLeft(),cond.getRight(),intTemp);
					il.add(fle);
					Instruction bne2 = new Bne(intTemp,"x0",else_label.label);
					il.add(bne2);
					break;
				case GE:
					Instruction flt = new Flt(cond.getLeft(),cond.getRight(),intTemp);
					il.add(flt);
					Instruction bne3 = new Bne(intTemp,"x0",else_label.label);
					il.add(bne3);
					break;
				default:
					throw new Error("Branch must be of the type: EQ,NE,LT,LE,GT,GE");
			}
			break;
			case INT:
			switch (cond.getOp()){
				case EQ:
					Instruction bne = new Bne(cond.getLeft(),cond.getRight(),else_label.label);
					il.add(bne);
					break;
				case NE:
					Instruction beq = new Beq(cond.getLeft(),cond.getRight(),else_label.label);
					il.add(beq);
					break;	
				case LT:
					Instruction bge = new Bge(cond.getLeft(),cond.getRight(),else_label.label);
					il.add(bge);
					break;
				case LE:
					Instruction bgt = new Bgt(cond.getLeft(),cond.getRight(),else_label.label);
					il.add(bgt);
					break;
				case GT:
					Instruction ble = new Ble(cond.getLeft(),cond.getRight(),else_label.label);
					il.add(ble);
					break;
				case GE:
					Instruction blt = new Blt(cond.getLeft(),cond.getRight(),else_label.label);
					il.add(blt);
					break;
				default:
					throw new Error("Branch must be of the type: EQ,NE,LT,LE,GT,GE");
			}
			break;
			default:
				throw new Error("Cond must be of type Int or Float!");
		}
		// step 4 generate code
		co.code.addAll(il);
		co.code.addAll(tlist.code);
		Instruction out_label = new Label(oLabel);
		Instruction jump = new J(out_label.label);
		co.code.add(jump);
		co.code.add(else_label);
		co.code.addAll(elist.code);
		co.code.add(out_label);
		co.temp = cond.leftTemp;
		return co;
	}

		/**
	 * FILL IN FROM STEP 3
	 * 
	 * Step 0: Create code object
	 * 
	 * Step 1: generate labels
	 * 
	 * Step 2: add code from conditional expression
	 * 
	 * Step 3: create branch statement (if not created as part of step 2)
	 * 			don't forget to generate correct branch based on type
	 * 
	 * Step 4: generate code
	 * 		loopLabel:
	 *		<cond code>
	 *		<flipped branch> outLabel
	 *		<body code>
	 *		j loopLabel
	 *		outLabel:
	 *
	 * Step 5 insert code into code object in appropriate order.
	 */
	@Override
	protected CodeObject postprocess(WhileNode node, CodeObject cond, CodeObject slist) {
		//Step 0:
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 3*/
		//Step 1 generate labels
		String oLabel = generateOutLabel();
		String lLabel = generateLoopLabel();
		//step 2 add code from conditional expression
		Instruction loop_label = new Label(lLabel);
		co.code.add(loop_label); 	
		co.code.addAll(cond.code);
		// step 3 create branch statement	
		InstructionList il = new InstructionList();
		Instruction out_label = new Label(oLabel);
		String intTemp = generateTemp(Scope.InnerType.INT);
		switch (cond.getType().type){
			case FLOAT:
			switch (cond.getOp()){
				case EQ:
					Instruction feq = new Feq(cond.getLeft(),cond.getRight(),intTemp);
					il.add(feq);
					Instruction bne = new Bne(intTemp,"x0",out_label.label);
					il.add(bne);	
					break;
				case NE:
					Instruction fneq = new Feq(cond.getLeft(),cond.getLeft(),intTemp); 
					il.add(fneq);
					Instruction beq = new Beq(intTemp,"x0",out_label.label);
					il.add(beq);
					break;	
				case LT:
					Instruction fge = new Fle(cond.getRight(),cond.getLeft(),intTemp);
					il.add(fge);
					Instruction bne0 = new Bne(intTemp,"x0",out_label.label);
					il.add(bne0);
					break;
				case LE:
					Instruction fgt = new Flt(cond.getRight(),cond.getLeft(),intTemp);
					il.add(fgt);
					Instruction bne1 = new Ble(intTemp,"x0",out_label.label);
					il.add(bne1);
					break;
				case GT:
					Instruction fle = new Fle(cond.getLeft(),cond.getRight(),intTemp);
					il.add(fle);
					Instruction bne2 = new Bne(intTemp,"x0",out_label.label);
					il.add(bne2);
					break;
				case GE:
					Instruction flt = new Flt(cond.getLeft(),cond.getRight(),intTemp);
					il.add(flt);
					Instruction bne3 = new Bne(intTemp,"x0",out_label.label);
					il.add(bne3);
					break;
				default:
					throw new Error("Branch must be of the type: EQ,NE,LT,LE,GT,GE");
			}
			break;
			case INT:
			switch (cond.getOp()){
				case EQ:
					Instruction bne = new Bne(cond.getLeft(),cond.getRight(),out_label.label);
					il.add(bne);
					break;
				case NE:
					Instruction beq = new Beq(cond.getLeft(),cond.getRight(),out_label.label);
					il.add(beq);
					break;	
				case LT:
					Instruction bge = new Bge(cond.getLeft(),cond.getRight(),out_label.label);
					il.add(bge);
					break;
				case LE:
					Instruction bgt = new Bgt(cond.getLeft(),cond.getRight(),out_label.label);
					il.add(bgt);
					break;
				case GT:
					Instruction ble = new Ble(cond.getLeft(),cond.getRight(),out_label.label);
					il.add(ble);
					break;
				case GE:
					Instruction blt = new Blt(cond.getLeft(),cond.getRight(),out_label.label);
					il.add(blt);
					break;
				default:
					throw new Error("Branch must be of the type: EQ,NE,LT,LE,GT,GE");
			}
			break;
			default:
				throw new Error("Cond must be of type Int or Float!");
		}
		// step 4 generate code
		co.code.addAll(il);
		co.code.addAll(slist.code);
		Instruction jump = new J(loop_label.label);
		co.code.add(jump);
		co.code.add(out_label);
		co.temp = cond.leftTemp;
		return co;
	}

	/**
	 * FILL IN FOR STEP 4
	 * 
	 * Generating code for returns
	 * 
	 * Step 0: Generate new code object
	 * 
	 * Step 1: Add retExpr code to code object (rvalify if necessary)
	 * 
	 * Step 2: Store result of retExpr in appropriate place on stack (fp + 8)
	 * 
	 * Step 3: Jump to out label (use @link{generateFunctionOutLabel()})
	 */
	@Override
	protected CodeObject postprocess(ReturnNode node, CodeObject retExpr) {
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 4 */
		//STEP 6 null check for void functions
		if(retExpr == null){
			co.type = new Scope.Type(InnerType.VOID);
			co.code.add(new J(generateFunctionOutLabel()));	
			return co;
		}
		// Step 1 
		if(retExpr.lval){
			retExpr = rvalify(retExpr);
		}
		co.code.addAll(retExpr.code);
		// Step 2
		switch(retExpr.getType().type){
			case FLOAT:
				co.code.add(new Fsw(retExpr.code.getLast().getDest(), "fp", "8"));
				break;
			default:
				//INT and PTR are the same 
				co.code.add(new Sw(retExpr.code.getLast().getDest(), "fp", "8")); 
				break;
		}
		//step 3
		co.code.add(new J(generateFunctionOutLabel()));
		co.type = retExpr.getType();
		return co;
	}

	@Override
	protected void preprocess(FunctionNode node) {
		// Generate function label information, used for other labels inside function
		currFunc = node.getFuncName();

		//reset register counts; each function uses new registers!
		intRegCount = 0;
		floatRegCount = 0;
	}

	/**
	 * FILL IN FOR STEP 4
	 * 
	 * Generate code for functions
	 * 
	 * Step 1: add the label for the beginning of the function
	 * 
	 * Step 2: manage frame  pointer
	 * 			a. Save old frame pointer
	 * 			b. Move frame pointer to point to base of activation record (current sp)
	 * 			c. Update stack pointer
	 * 
	 * Step 3: allocate new stack frame (use scope infromation from FunctionNode)
	 * 
	 * Step 4: save registers on stack (Can inspect intRegCount and floatRegCount to know what to save)
	 * 
	 * Step 5: add the code from the function body
	 * 
	 * Step 6: add post-processing code:
	 * 			a. Label for `return` statements inside function body to jump to
	 * 			b. Restore registers
	 * 			c. Deallocate stack frame (set stack pointer to frame pointer)
	 * 			d. Reset fp to old location
	 * 			e. Return from function
	 */
	@Override
	protected CodeObject postprocess(FunctionNode node, CodeObject body) {
		CodeObject co = new CodeObject();

		/* FILL IN */
		/* step 1 */
		co.code.add(new Label(generateFunctionLabel(node.getFuncName())));
		/* step 2  - look at lecture 6.6 */
		co.code.add(new Sw("fp", "sp", "0")); 
		co.code.add(new Mv("sp", "fp"));
		co.code.add(new Addi("sp", "-4", "sp")); 
		/* step 3 */

		co.code.add(new Addi("sp", String.valueOf(-4 * node.getScope().getNumLocals()), "sp")); // 4 * number of local variables, checked the testcases no string/pointers to consider!
		/* step 4 */
		for(int intRegNum = 0; intRegNum < intRegCount; intRegNum++){
			co.code.add(new Sw("t" + String.valueOf(intRegNum + 1), "sp", "0"));
			co.code.add(new Addi("sp", "-4", "sp"));
		}	
		for(int floatRegNum = 0; floatRegNum < floatRegCount; floatRegNum++){	
			co.code.add(new Fsw("f" + String.valueOf(floatRegNum + 1), "sp", "0"));
			co.code.add(new Addi("sp", "-4", "sp"));
		}	
		/*step 5*/
		co.code.addAll(body.getCode());
		/*step 6*/
		// step 6a - return label
		co.code.add(new Label(generateFunctionOutLabel())); 
		//step 6b - pop registers  - refactor this code later!
		for(int floatRegNum = floatRegCount - 1; floatRegNum >= 0; floatRegNum--){
			co.code.add(new Addi("sp", "4", "sp"));
			co.code.add(new Flw("f" + String.valueOf(floatRegNum + 1), "sp", "0"));
		}
		for(int intRegNum = intRegCount - 1; intRegNum >= 0; intRegNum--){
			co.code.add(new Addi("sp", "4", "sp"));
			co.code.add(new Lw("t" + String.valueOf(intRegNum + 1), "sp", "0"));
		}	
		// step 6c - deallocate stack frame
		co.code.add(new Mv("fp", "sp"));	
		// step 6d - reset fp to old location
		co.code.add(new Lw("fp", "fp", "0"));
		// step 6e - return from function 
		co.code.add(new Ret());
		co.temp = body.temp;
		return co;
	}

	/**
	 * Generate code for the list of functions. This is the "top level" code generation function
	 * 
	 * Step 1: Set fp to point to sp
	 * 
	 * Step 2: Insert a JR to main
	 * 
	 * Step 3: Insert a HALT
	 * 
	 * Step 4: Include all the code of the functions
	 */
	@Override
	protected CodeObject postprocess(FunctionListNode node, List<CodeObject> funcs) {
		CodeObject co = new CodeObject();

		co.code.add(new Mv("sp", "fp"));
		co.code.add(new Jr(generateFunctionLabel("main")));
		co.code.add(new Halt());
		co.code.add(new Blank());

		//add code for each of the functions
		for (CodeObject c : funcs) {
			co.code.addAll(c.code);
			co.code.add(new Blank());
		}

		return co;
	}

	/**
	* 
	* FILL IN FOR STEP 4
	* 
	* Generate code for a call expression
	 * 
	 * Step 1: For each argument:
	 * 
	 * 	Step 1a: insert code of argument (don't forget to rvalify!)
	 * 
	 * 	Step 1b: push result of argument onto stack 
	 * 
	 * Step 2: alloate space for return value
	 * 
	 * Step 3: push current return address onto stack
	 * 
	 * Step 4: jump to function
	 * 
	 * Step 5: pop return address back from stack
	 * 
	 * Step 6: pop return value into fresh temporary (destination of call expression)
	 * 
	 * Step 7: remove arguments from stack (move sp)
	 * 
	 * Add special handling for malloc and free(Ignore refer to post @413)
	 */

	 /**
	  * FOR STEP 6: Make sure to handle VOID functions properly
	  */
	@Override
	protected CodeObject postprocess(CallNode node, List<CodeObject> args) {
		
		//STEP 0
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 4 */
		//Step 1a
		CodeObject tmp = new CodeObject();
		for(int arg = 0; arg < args.size(); arg++){
			tmp = args.get(arg);
			if(tmp.lval){
				tmp = rvalify(tmp);
			}
			co.code.addAll(tmp.getCode());
			switch(tmp.getType().type){
				case PTR:
				case INT:
					co.code.add(new Label("testing line 1041"));
					co.code.add(new Sw(tmp.temp,"sp", "0"));
					break;
				case FLOAT:
					co.code.add((new Fsw(tmp.temp, "sp", "0")));
					break;
				default:
					throw new Error("Error in callNode first loop");
			}
			//step 1b
			co.code.add(new Addi("sp", "-4", "sp")); //only need to worry about int and float so -4 works
		}
		//step 2 -- only need to worry about int and float so -4 works
		co.code.add(new Addi("sp", "-4", "sp"));	
		//step 3
		co.code.add(new Sw("ra","sp", "0"));
		co.code.add(new Addi("sp", "-4", "sp"));
		//step 4
		co.code.add(new Jr(generateFunctionLabel(node.getFuncName())));
		//step 5
		co.code.add(new Addi("sp", "4", "sp")); 
		co.code.add(new Lw("ra", "sp", "0")); 
		co.code.add(new Addi("sp", "4", "sp")); 
		//step 6
		String temp;
		if(node.getType().type != InnerType.VOID){
		temp = generateTemp(node.getType().type); //double check this
		switch(node.getType().type){
			case PTR:
			case INT:
				co.code.add(new Lw(temp, "sp", "0")); 	
				break;
			case FLOAT:	
				co.code.add(new Flw(temp, "sp", "0")); 
				break;
			default:
				throw new Error("Return value must be of type Int,Float,String, or Void!");	
			}
		co.temp = temp; 
		}	
		//step 7
		for(int arg = 0; arg < args.size(); arg++){
			tmp = args.get(arg);
			switch(tmp.getType().type){
				case PTR:
				case INT:
					co.code.add(new Addi("sp", "4", "sp"));
					break;
				case FLOAT:
					co.code.add(new Addi("sp", "4", "sp"));
					break;
				default:
					// System.out.println("\ncallNode case " + tmp.getType().type);
					throw new Error("Arguments must be of type Int,Float,String, or Void!");	
			}	
		}
		co.type = node.getType();
		return co;
	}	
	
	/**
	 * Generate code for * (expr)
	 * 
	 * Goal: convert the r-val coming from expr (a computed address) into an l-val (an address that can be loaded/stored)
	 * 
	 * Step 0: Create new code object
	 * 
	 * Step 1: Rvalify expr if needed
	 * 
	 * Step 2: Copy code from expr (including any rvalification) into new code object
	 * 
	 * Step 3: New code object has same temporary as old code, but now is marked as an l-val
	 * 
	 * Step 4: New code object has an "unwrapped" type: if type of expr is * T, type of temporary is T. Can get this from node
	 */
	@Override
	protected CodeObject postprocess(PtrDerefNode node, CodeObject expr) {
		CodeObject co = new CodeObject();

		/* FILL IN FOR STEP 6 */
		if(expr.lval){
			expr = rvalify(expr);
		}
		//step 2
		co.code.addAll(expr.getCode());
		//step 3
		co.temp = expr.temp;
		co.lval = true;
		//step 4		
		co.type = expr.getType().getWrappedType();	
		
		return co;
	}

	/**
	 * Generate code for a & (expr)
	 * 
	 * Goal: convert the lval coming from expr (an address) to an r-val (a piece of data that can be used)
	 * 
	 * Step 0: Create new code object
	 * 
	 * Step 1: If lval is a variable, generate code to put address into a register (e.g., generateAddressFromVar)
	 *			Otherwise just copy code from other code object
	 * 
	 * Step 2: New code object has same temporary as existing code, but is an r-val
	 * 
	 * Step 3: New code object has a "wrapped" type. If type of expr is T, type of temporary is *T. Can get this from node
	 */
	@Override
	protected CodeObject postprocess(AddrOfNode node, CodeObject expr) {
		CodeObject co = new CodeObject();
		if(expr.isVar()){
			InstructionList temp = generateAddrFromVariable(expr);
			//step 2
			co.temp = temp.getLast().getDest();
			co.code.addAll(temp);
		}
		else{
			co.temp = expr.temp;
			co.code.addAll(expr.getCode());		
		}
		//step 2
		co.lval = false;
		//step 3
		co.type = Scope.Type.pointerToType(expr.getType());
		return co;
	}

	/**
	 * Generate code for malloc
	 * 
	 * Step 0: Create new code object
	 * 
	 * Step 1: Add code from expression (rvalify if needed)
	 * 
	 * Step 2: Create new MALLOC instruction
	 * 
	 * Step 3: Set code object type to INFER
	 */
	@Override
	protected CodeObject postprocess(MallocNode node, CodeObject expr) {
		CodeObject co = new CodeObject();

		/* FILL IN FOR STEP 6 */
		//step 1
		if(expr.lval){
			expr = rvalify(expr);
		}
		co.code.addAll(expr.getCode());
		//step 2
		String temp = generateTemp(expr.getType().type);
		Instruction tempInstruction = new Malloc(expr.code.getLast().getDest(),temp);
		co.code.add(tempInstruction);
		//step 3
		co.temp = temp; 
		co.type = new Scope.Type(InnerType.INFER);
		return co;
	}
	
	/**
	 * Generate code for free
	 * 
	 * Step 0: Create new code object
	 * 
	 * Step 1: Add code from expression (rvalify if needed)
	 * 
	 * Step 2: Create new FREE instruction
	 */
	@Override
	protected CodeObject postprocess(FreeNode node, CodeObject expr) {
		CodeObject co = new CodeObject();

		/* FILL IN FOR STEP 6 */
		//step 1
		if(expr.lval){
			expr = rvalify(expr);
		}
		co.code.addAll(expr.getCode());
		//step 2 
		Instruction temp = new Free(expr.temp);
		co.code.add(temp);	
		co.temp = expr.temp;
		return co;
	}

	/**
	 * Generate a fresh temporary
	 * 
	 * @return new temporary register name
	 */
	protected String generateTemp(Scope.InnerType t) {
		switch(t) {
			case INT: 
			case PTR: //works the same for pointers
				return intTempPrefix + String.valueOf(++intRegCount);
			case FLOAT: return floatTempPrefix + String.valueOf(++floatRegCount);
			default: throw new Error("Generating temp for bad type");
		}
	}

	protected String generateLoopLabel() {
		return "loop_" + String.valueOf(++loopLabel);
	}

	protected String generateElseLabel() {
		return  "else_" + String.valueOf(++elseLabel);
	}

	protected String generateOutLabel() {
		return "out_" +  String.valueOf(++outLabel);
	}

	protected String generateFunctionLabel() {
		return "func_" + currFunc;
	}

	protected String generateFunctionLabel(String func) {
		return "func_" + func;
	}

	protected String generateFunctionOutLabel() {
		return "func_ret_" + currFunc;
	}
	
	/**
	 * Take a code object that results in an lval, and create a new code
	 * object that adds a load to generate the rval.
	 * 
	 * @param lco The code object resulting in an address
	 * @return A code object with all the code of <code>lco</code> followed by a load
	 *         to generate an rval
	 */
	protected CodeObject rvalify(CodeObject lco) {
		
		assert (lco.lval == true);
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 2 */

		/* DON'T FORGET TO ADD CODE TO GENERATE LOADS FOR LOCAL VARIABLES */
		if(lco.isVar() )	{
			InstructionList lcoIl = generateAddrFromVariable(lco); // used to be codeobject!
			lco.temp = lcoIl.getLast().getDest(); 
			co.code.addAll(lcoIl);
		}

		co.code.addAll(lco.getCode());

		InstructionList il = new InstructionList();
		if(lco.getType() == null){
			throw new Error("lco.getType() is null");
		}
		String newTemp;
		newTemp = generateTemp(lco.getType().type); 
		switch(lco.getType().type) {
			case FLOAT:
				//Code to generate FLOAT load
					co.code.add(new Label("testing line 1446"));
					Instruction loadf = new Flw(newTemp,lco.temp, "0");
					il.add(loadf);	
					break;
			default:
				//Code to generate INT load
				//same for everything except float 
					Instruction loadi = new Lw(newTemp,lco.temp, "0");
					il.add(loadi);
					break;
		}
		co.code.addAll(il);
		co.lval = false; 
		co.temp = newTemp; 
		co.type = lco.getType();
		return co;
	}

	/**
	 * Generate an instruction sequence that holds the address of the variable in a code object
	 * 
	 * If it's a global variable, just get the address from the symbol table
	 * 
	 * If it's a local variable, compute the address relative to the frame pointer (fp)
	 * 
	 * @param lco The code object holding a variable
	 * @return a list of instructions that puts the address of the variable in a register
	 */
	private InstructionList generateAddrFromVariable(CodeObject lco) {

		InstructionList il = new InstructionList();

		//Step 1:
		SymbolTableEntry symbol = lco.getSTE();
		String address = symbol.addressToString();

		//Step 2:
		Instruction compAddr = null;
		if (symbol.isLocal()) {
			//If local, address is offset
			//need to load fp + offset
			//addi tmp' fp offset
			compAddr = new Addi("fp", address, generateTemp(Scope.InnerType.INT));
		} else {
			//If global, address in symbol table is the right location
			//la tmp' addr //Register type needs to be an int
			compAddr = new La(generateTemp(Scope.InnerType.INT), address);
		}
		il.add(compAddr); //add instruction to code object

		return il;
	}

}
