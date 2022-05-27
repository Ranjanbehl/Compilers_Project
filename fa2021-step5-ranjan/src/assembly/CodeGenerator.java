package assembly;

import java.util.List;

import ast.visitor.AbstractASTVisitor;

import ast.*;
import assembly.instructions.*;
import compiler.Scope;
import compiler.Scope.SymbolTableEntry;

public class CodeGenerator extends AbstractASTVisitor<CodeObject> {

	int intRegCount;
	int floatRegCount;
	static final public String intTempPrefix = "$t"; 
	static final public String floatTempPrefix = "$f"; 
	
	int loopLabel;
	int elseLabel;
	int outLabel;

	static final public int numIntRegisters = 32;
	static final public int numFloatRegisters = 32;

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
	 * NOTE THAT THIS HAS CHANGED TO GENERATE 3AC INSTEAD
	 */
	@Override
	protected CodeObject postprocess(VarNode node) {
		
		Scope.SymbolTableEntry sym = node.getSymbol();
		
		CodeObject co = new CodeObject(sym);
		co.lval = true;
		co.type = node.getType();
		if (sym.isLocal()) {
			co.temp = "$l" + String.valueOf(sym.getAddress());
		} else {
			co.temp = "$g" + sym.getName();
		}


		return co;
	}

	/** Generate code for IntLiterals
	 * 
	 * NOTE THAT THIS HAS CHANGED TO GENERATE 3AC INSTEAD
	 */
	@Override
	protected CodeObject postprocess(IntLitNode node) {
		CodeObject co = new CodeObject();
		
		//Load an immediate into a register
		//The li and la instructions are the same, but it's helpful to distinguish
		//for readability purposes.
		//li tmp' value
		Instruction i = new Li(generateTemp(Scope.Type.INT), node.getVal());

		co.code.add(i); //add this instruction to the code object
		co.lval = false; //co holds an rval -- data
		co.temp = i.getDest(); //temp is in destination of li
		co.type = node.getType();

		return co;
	}

	/** Generate code for FloatLiteras
	 * 
	 * NOTE THAT THIS HAS CHANGED TO GENERATE 3AC INSTEAD
	 */
	@Override
	protected CodeObject postprocess(FloatLitNode node) {
		CodeObject co = new CodeObject();
		
		//Load an immediate into a regisster
		//The li and la instructions are the same, but it's helpful to distinguish
		//for readability purposes.
		//li tmp' value
		Instruction i = new FImm(generateTemp(Scope.Type.FLOAT), node.getVal());

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
		/* MODIFY THIS TO GENERATE 3AC INSTEAD */
		// if(left.lval){
		// 	if(left.getType().equals(Scope.Type.INT)){
		// 		left.temp = intTempPrefix + String.valueOf(intRegCount);
		// 		intRegCount++;
		// 	}
		// 	else{
		// 		left.temp = floatTempPrefix + String.valueOf(floatRegCount);
		// 		floatRegCount++;
		// 	}		
		// }

		if(left.lval){
			left = rvalify(left);
		}
		co.code.addAll(left.code);
		if(right.lval){
			right = rvalify(right);
		}

		co.code.addAll(left.code);
		// if(right.lval){
		// 	if(right.getType().equals(Scope.Type.INT)){
		// 		right.temp = intTempPrefix + String.valueOf(intRegCount);
		// 		intRegCount++;
		// 	}
		// 	else{
		// 		right.temp = floatTempPrefix + String.valueOf(floatRegCount);
		// 		floatRegCount++;
		// 	}		
			
		// }
		co.code.addAll(right.code);
		InstructionList il = new InstructionList();
		String newTemp = generateTemp(left.getType()); 	
		switch(node.getOp()) {
			case ADD: 
			switch(left.getType()){
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
			switch(left.getType()){			
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
			switch(left.getType()){
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
			switch(left.getType()){
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
		co.type = left.getType();	
		return co;
	}

	/**
	 * Generate code for unary operations.
	 * 
	 * Step 0: create new code object
	 * Step 1: add code from child expression
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

		/* MODIFY THIS TO GENERATE 3AC INSTEAD */
		// if(expr.lval){
		// 	if(expr.getType().equals(Scope.Type.INT)){
		// 		expr.temp = intTempPrefix + String.valueOf(intRegCount);
		// 		intRegCount++;
		// 	}
		// 	else{
		// 		expr.temp = floatTempPrefix + String.valueOf(floatRegCount);
		// 		floatRegCount++;
		// 	}		
		// 	 }
			if(expr.lval){
			expr = rvalify(expr);
			 }
			co.code.addAll(expr.code);
			InstructionList il = new InstructionList();
			String newTemp = generateTemp(expr.getType()); 
			switch(expr.getType()) {
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

		/* MODIFY THIS TO GENERATE 3AC INSTEAD */

		assert(left.lval == true); //left hand side had better hold an address

		//Step 1a
		if(left.isVar() && left.getSTE().isLocal()){
			InstructionList lcoIl = generateAddrFromVariable(left); // used to be codeobject!
			left.temp = lcoIl.getLast().getDest(); 
			//co.code.add(new Label("before sw remove"));
			lcoIl.remove(lcoIl.getLast()); // remvoing extra addi instruction
			co.code.addAll(lcoIl);
			//co.code.add(new Label("test sw Remove"));
		}

		else if(left.isVar() && !left.getSTE().isLocal())	{
			//co.code.add(new Label("testing global - assignNode"));
			InstructionList lcoIl = generateAddrFromVariable(left); // used to be codeobject!
			left.temp = lcoIl.getLast().getDest(); 
			co.code.addAll(lcoIl);
		}

		co.code.addAll(left.code); 
		if(right.lval){
			if(right.getType().equals(Scope.Type.INT)){
				right.temp = intTempPrefix + String.valueOf(intRegCount);
				intRegCount++;
			}
			else{
				right.temp = floatTempPrefix + String.valueOf(floatRegCount);
				floatRegCount++;
			}		
		}
		co.code.addAll(right.code);

		InstructionList il = new InstructionList();	
		switch(left.getType()){
			case INT:
				if(left.isVar() && left.getSTE().isLocal()){
					//co.code.add(new Label("testing line 324"));
					Instruction storei = new Sw(right.temp, "fp", left.getSTE().addressToString());//new Lw(newTemp,"fp", lco.getSTE().addressToString());
					il.add(storei);
					break;
				}	
				else{
					//co.code.add(new Label("testing line 330"));
					Instruction swi = new Sw(right.temp,left.temp, "0"); //Am I missing a instruction?
					il.add(swi);
					break;
				}
			case FLOAT:
				if(left.isVar() && left.getSTE().isLocal()){
					//co.code.add(new Label("testing line 337"));
					Instruction storef = new Fsw(right.temp, "fp", left.getSTE().addressToString());//new Lw(newTemp,"fp", lco.getSTE().addressToString());
					il.add(storef);
					break;
				}
				else{
					//co.code.add(new Label("testing line 343"));
					Instruction swf = new Fsw(right.temp,left.temp, "0");
					il.add(swf);
					break;
				}	
			default:
				throw new Error("Must be an INT or FLOAT or STRING or VOID!");
		}
		co.code.addAll(il);
		co.lval = true;  
		co.temp = left.temp; 
		co.type = left.getType();
		
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
	 * 
	 * NOTE THAT THIS HAS CHANGED TO GENERATE 3AC INSTEAD
	 */
	@Override
	protected CodeObject postprocess(ReadNode node, CodeObject var) {
		
		//Step 0
		CodeObject co = new CodeObject();

		//Generating code for read(id)
		assert(var.getSTE() != null); //var had better be a variable

		InstructionList il = new InstructionList();
		switch(node.getType()) {
			case INT: 
				//Code to generate if INT:
				//geti var.tmp
				Instruction geti = new GetI(var.temp);
				il.add(geti);
				//the following is from step 4
				InstructionList store = new InstructionList();
				if (var.getSTE().isLocal()) {
					store.add(new Sw(geti.getDest(), "fp", String.valueOf(var.getSTE().addressToString())));
				} else {
					store.addAll(generateAddrFromVariable(var));		
					store.add(new Sw(geti.getDest(), store.getLast().getDest(), "0")); 
				}
				il.addAll(store);
				//
				break;
			case FLOAT:
				//Code to generate if FLOAT:
				//getf var.tmp
				Instruction getf = new GetF(var.temp);
				il.add(getf);
				 //the following is from step 4
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
	 * 
	 * NOTE THAT THIS HAS CHANGED TO GENERATE 3AC INSTEAD
	 */
	@Override
	protected CodeObject postprocess(WriteNode node, CodeObject expr) {
		CodeObject co = new CodeObject();

		//generating code for write(expr)

		//for strings, we expect a variable
		if (node.getWriteExpr().getType() == Scope.Type.STRING) {
			//Step 1:
			assert(expr.getSTE() != null);

			//Step 2:
			Instruction write = new PutS(expr.temp);
			co.code.add(write);
		} else {			
			//Step 1:
			co.code.addAll(expr.code);

			//Step 2:
			//if type of writenode is int, use puti, if float, use putf
			Instruction write = null;
			switch(node.getWriteExpr().getType()) {
			case STRING: throw new Error("Shouldn't have a STRING here");
			case INT: write = new PutI(expr.temp); break;
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

		/* MODIFY THIS TO GENERATE 3AC */
		// if(left.lval){
		// 	if(left.getType().equals(Scope.Type.INT)){
		// 		left.temp = intTempPrefix + String.valueOf(intRegCount);
		// 		intRegCount++;
		// 	}
		// 	else{
		// 		left.temp = floatTempPrefix + String.valueOf(floatRegCount);
		// 		floatRegCount++;
		// 	}		
		// }
		if(left.lval){
			left = rvalify(left);
		}
		co.code.addAll(left.code);
		co.leftTemp = left.temp;
	
		// if(right.lval){
		// 	if(right.getType().equals(Scope.Type.INT)){
		// 		right.temp = intTempPrefix + String.valueOf(intRegCount);
		// 		intRegCount++;
		// 	}
		// 	else{
		// 		right.temp = floatTempPrefix + String.valueOf(floatRegCount);
		// 		floatRegCount++;
		// 	}		
		// }
		if(right.lval){
			right = rvalify(right);
		}
		co.code.addAll(right.code);
		co.rightTemp = right.temp;
		co.op = node.getOp();
		co.type = left.getType(); 

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
	 * 
	 */
	@Override
	protected CodeObject postprocess(IfStatementNode node, CodeObject cond, CodeObject tlist, CodeObject elist) {
		//Step 0:
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 3*/

		/* MODIFY THIS TO GENERATE 3AC */
		//Step 1 generate labels
		String oLabel = generateOutLabel();
		String eLabel = generateElseLabel();
		//step 2 add code from conditional expression
		co.code.addAll(cond.code);
		// step 3 create branch statement
		InstructionList il = new InstructionList();
		Instruction else_label = new Label(eLabel);
		//String floatTemp = generateTemp(Scope.Type.FLOAT);
		String intTemp = generateTemp(Scope.Type.INT);
		switch (cond.getType()){
			case FLOAT:
			switch (cond.getOp()){
				case EQ:
					Instruction feq = new Feq(cond.getLeft(),cond.getRight(),intTemp);
					il.add(feq);
					Instruction bne = new Bne(intTemp,"x0",else_label.label);
					il.add(bne);
					//Instruction bgt = new Bgt(intTemp,"x0",else_label.label);
					//il.add(bgt);
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

		/* MODIFY THIS TO GENERATE 3AC */
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
		//String floatTemp = generateTemp(Scope.Type.FLOAT);
		String intTemp = generateTemp(Scope.Type.INT);
		switch (cond.getType()){
			case FLOAT:
			switch (cond.getOp()){
				case EQ:
					Instruction feq = new Feq(cond.getLeft(),cond.getRight(),intTemp);
					il.add(feq);
					Instruction bne = new Bne(intTemp,"x0",out_label.label);
					il.add(bne);
					//Instruction bgt = new Bgt(intTemp,"x0",out_label.label); ///this is giving me a extra reg?
					//il.add(bgt);
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

		/* FILL IN FROM STEP 4*/

		/* MODIFY THIS TO GENERATE 3AC */
		// Step 1 
		// if(retExpr.lval){
		// 	if(retExpr.getType().equals(Scope.Type.INT)){
		// 		retExpr.temp = intTempPrefix + String.valueOf(intRegCount);
		// 		intRegCount++;
		// 	}
		// 	else{
		// 		retExpr.temp = floatTempPrefix + String.valueOf(floatRegCount);
		// 		floatRegCount++;
		// 	}		
		// }
		if(retExpr.lval){
			retExpr = rvalify(retExpr);
		}
		co.code.addAll(retExpr.code);
		// Step 2
		switch(retExpr.getType()){
			case INT:
				//co.code.add(new Label("testing line 839"));
				co.code.add(new Sw(retExpr.code.getLast().getDest(), "fp", "8")); 
				//co.code.add(new Label("testing line 841"));
				break;
			case FLOAT:
				//co.code.add(new Label("testing line 843"));
				co.code.add(new Fsw(retExpr.code.getLast().getDest(), "fp", "8"));
				break;
			default:
				break;
		}
		//step 3
		co.code.add(new J(generateFunctionOutLabel()));

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

		/** ADD REGISTER ALLOCATION HERE
		 * 
		 * You may find it useful to do this in the following way:
		 * 
		 * 1. Write a register allocator class that is initialized with the number of int/fp registers to use, the code from
		 * 		`body`, and the function scope from `node` (the function scope gives you access to local/global variables)
		 * 2. Within the register allocator class, do the following
		 * 		a. Split the code in body into basic blocks
		 * 		b. (573 version) Perform liveness analysis on each basic block (assume globals and locals are live)
		 * 		b. (468/595 version) Assume all locals/globals/temporaries are live all the time
		 * 		c. Perform register allocation on each basic block using the algorithms presented in class,
		 * 			converting 3AC into assembly code with macro expansion
		 * 			i. Add code to track the state of the registers for each basic block (what is assigned to the register, whether it's dirty)
		 * 			ii. As you perform register allocation within a basic block, spill registers to memory as necessary. Use any
		 * 				heuristic you want to determine which registers to allocate and which to spill
		 * 			iii. If you need to spill a temporary to memory, you'll find it easiest to add the temporary as a new "local" variable
		 * 				to the local scope (you can just use the temporary name as the variable name); that will automatically allocate a spot
		 * 				in the activation record for it.
		 * 			iv. At the end of each basic block, save all dirty/live registers that hold globals/locals back to the stack
		 * 3. Once register allocation is done, track:
		 * 		a. How big the local scope is after spilling temporaries -- this affects allocating the stack frame
		 * 		b. How many total registers you used -- this affects the register save/restore code
		 * 4. Now generate code for your function as before, but using the updated information for register save/restore and frame allocation
		 */
		//RegisterAllocator regAllocator = new RegisterAllocator(getIntRegCount(),getFloatRegCount(),body,node.getScope());
		 /* FILL IN FROM STEP 4*/
		/* step 1 */
		co.code.add(new Label(generateFunctionLabel(node.getFuncName())));
		/* step 2  - look at lecture 6.6 */
		//co.code.add(new Label("testing line 896"));
		co.code.add(new Sw("fp", "sp", "0")); 
		co.code.add(new Mv("sp", "fp"));
		co.code.add(new Addi("sp", "-4", "sp")); 
		/* step 3 */

		co.code.add(new Addi("sp", String.valueOf(-4 * node.getScope().getNumLocals()), "sp")); // 4 * number of local variables, checked the testcases no string/pointers to consider!
		/* step 4 */
		for(int intRegNum = 0; intRegNum < intRegCount; intRegNum++){
			//co.code.add(new Label("testing line 905"));
			co.code.add(new Sw("t" + String.valueOf(intRegNum + 1), "sp", "0"));
			co.code.add(new Addi("sp", "-4", "sp"));
		}	
		for(int floatRegNum = 0; floatRegNum < floatRegCount; floatRegNum++){
			//co.code.add(new Label("testing line 913"));	
			co.code.add(new Fsw("f" + String.valueOf(floatRegNum + 1), "sp", "0"));
			co.code.add(new Addi("sp", "-4", "sp"));
		}	
		/*step 5*/
		//co.code.add(new Label("body"));
		co.code.addAll(body.getCode());
		//co.code.add(new Label("afterbody"));
		/*step 6*/
		// step 6a - return label
		co.code.add(new Label(generateFunctionOutLabel())); 
		//step 6b - pop registers  - refactor this code later!
		for(int floatRegNum = floatRegCount - 1; floatRegNum >= 0; floatRegNum--){
			//co.code.add(new Label("testing line 930"));
			co.code.add(new Addi("sp", "4", "sp"));
			co.code.add(new Flw("f" + String.valueOf(floatRegNum + 1), "sp", "0"));
		}
		for(int intRegNum = intRegCount - 1; intRegNum >= 0; intRegNum--){
			//co.code.add(new Label("testing line 925"));
			co.code.add(new Addi("sp", "4", "sp"));
			co.code.add(new Lw("t" + String.valueOf(intRegNum + 1), "sp", "0"));
		}	
		// step 6c - deallocate stack frame
		co.code.add(new Mv("fp", "sp"));	
		// step 6d - reset fp to old location
		co.code.add(new Lw("fp", "fp", "0"));
		// step 6e - return from function 
		co.code.add(new Ret());
	
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
	 */
	@Override
	protected CodeObject postprocess(CallNode node, List<CodeObject> args) {
		
		//STEP 0
		CodeObject co = new CodeObject();

		/* FILL IN FROM STEP 4*/

		/* MODIFY THIS TO GENERATE 3AC */
		//Step 1a
		CodeObject tmp = new CodeObject();
		for(int arg = 0; arg < args.size(); arg++){
			tmp = args.get(arg);
			if(tmp.lval){
				tmp = rvalify(tmp);
			}
			co.code.addAll(tmp.getCode());
			switch(tmp.getType()){
				case INT:
				//co.code.add(new Label("testing line 1007"));
					co.code.add(new Sw(tmp.temp,"sp", "0"));
					break;
				case FLOAT:
					co.code.add((new Fsw(tmp.temp, "sp", "0")));
					break;
				default:
					break;
			}
			//step 1b
			co.code.add(new Addi("sp", "-4", "sp")); //only need to worry about int and float so -4 works
		}
		//step 2 -- only need to worry about int and float so -4 works
		co.code.add(new Addi("sp", "-4", "sp"));	
		//step 3
		//co.code.add(new Label("testing line 1023"));
		co.code.add(new Sw("ra","sp", "0"));
		co.code.add(new Addi("sp", "-4", "sp"));
		//step 4
		co.code.add(new Jr(generateFunctionLabel(node.getFuncName())));
		//step 5
		co.code.add(new Addi("sp", "4", "sp")); //ummm
		co.code.add(new Lw("ra", "sp", "0")); // would this work? 
		co.code.add(new Addi("sp", "4", "sp")); 
		//step 6
		//co.code.add(new Label("testing line 1039"));
		String temp = generateTemp(node.getType()); //double check this
		switch(node.getType()){
			case INT:
				//co.code.add(new Label("testing line 1041"));
				co.code.add(new Lw(temp, "sp", "0")); // would this work?
				//co.code.add(new Addi("sp", "4", "sp"));
				break;
			case FLOAT:	
				//co.code.add(new Label("testing line 1046"));
				co.code.add(new Flw(temp, "sp", "0")); 
				//co.code.add(new Addi("sp", "4", "sp"));
				break;
			default:
				throw new Error("Return value must be of type Int,Float,String, or Void!");	
		}	
		//step 7
		for(int arg = 0; arg < args.size(); arg++){
			tmp = args.get(arg);
			switch(tmp.getType()){
				case INT:
					co.code.add(new Addi("sp", "4", "sp"));
					break;
				case FLOAT:
					co.code.add(new Addi("sp", "4", "sp"));
					break;
				default:
					throw new Error("Arguments must be of type Int,Float,String, or Void!");	
			}	
		}	
		co.temp = temp; 
		return co;
	}	
	
	/**
	 * Generate a fresh temporary
	 * 
	 * @return new temporary register name
	 */
	protected String generateTemp(Scope.Type t) {
		if(intRegCount == 0 || intRegCount == 1 || intRegCount == 7){
			intRegCount++;
		}
		if(floatRegCount == 0 || floatRegCount == 1 || floatRegCount == 7){
			floatRegCount++;
		}
		switch(t) {
			case INT: return intTempPrefix + String.valueOf(++intRegCount);
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

		/* THIS WON'T BE NECESSARY IF YOU'RE GENERATING 3AC */

		/* DON'T FORGET TO ADD CODE TO GENERATE LOADS FOR LOCAL VARIABLES */
		if(lco.isVar() && lco.getSTE().isLocal()){
			InstructionList lcoIl = generateAddrFromVariable(lco); // used to be codeobject!
			lco.temp = lcoIl.getLast().getDest(); 
			//co.code.add(new Label("before test REmove"));
			lcoIl.remove(lcoIl.getLast()); // remvoing extra addi instruction
			co.code.addAll(lcoIl);
			//co.code.add(new Label("testRemove"));
		}
		else if(lco.isVar() && !lco.getSTE().isLocal())	{
			//co.code.add(new Label("testing global"));
			InstructionList lcoIl = generateAddrFromVariable(lco); // used to be codeobject!
			lco.temp = lcoIl.getLast().getDest(); 
			co.code.addAll(lcoIl);
		}
		co.code.addAll(lco.code);

		InstructionList il = new InstructionList();
		String newTemp = generateTemp(lco.getType());
		//co.code.add(new Label("testing line 1138"));
		switch(lco.getType()) {
			case INT: 
				//Code to generate INT load:
				if(lco.isVar() && lco.getSTE().isLocal()){
					Instruction loadi = new Lw(newTemp,"fp", lco.getSTE().addressToString());
					il.add(loadi);
					break;	
				}
				else{
					Instruction loadi = new Lw(newTemp,lco.temp, "0");
					il.add(loadi);
					break;
				}
			case FLOAT:
				//Code to generate FLOAT load:
				if(lco.isVar() && lco.getSTE().isLocal()){
					Instruction loadf = new Flw(newTemp,"fp", lco.getSTE().addressToString());
					il.add(loadf);	
					break;
				}
				else{
					Instruction loadf = new Flw(newTemp,lco.temp, "0");
					il.add(loadf);	
					break;
				}
			default:
				throw new Error("Shouldn't read into other variable");
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
			compAddr = new Addi("fp", address, generateTemp(Scope.Type.INT));
		} else {
			//If global, address in symbol table is the right location
			//la tmp' addr //Register type needs to be an int
			compAddr = new La(generateTemp(Scope.Type.INT), address);
		}
		il.add(compAddr); //add instruction to code object

		return il;
	}

}
