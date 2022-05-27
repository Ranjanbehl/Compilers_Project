package assembly.instructions;

/**
 * Superclass for all Instructions. Most fields do not have accessors
 * because they are only used in toString methods used to emit instructions.
 */
public abstract class Instruction {

	/*
	* list of possible op codess
	*/
	public enum OpCode {
        LI("LI"),
        LA("LA"),
		ADD("ADD"),
		SUB("SUB"),
		DIV("DIV"),
		MUL("MUL"),
		NEG("NEG"),
		MV("MV"),
		LW("LW"),
		SW("SW"),
		PUTS("PUTS"),
		PUTI("PUTI"),
		GETI("GETI"),
		HALT("HALT"),
		ADDI("ADDI"),
		/* BRANCH INSTRUCTIONS */
		BEQ("BEQ"),
		BGE("BGE"),
		BGT("BGT"),
		BLE("BLE"),
		BLT("BLT"),
		BNE("BNE"),
		J("J"),
		/* FLOAT INSTRUCTIONS */
		FADDS("FADD.S"),
		FSUBS("FSUB.S"),
		FDIVS("FDIV.S"),
		FMULS("FMUL.S"),
		FMVS("FMV.S"),
		FNEGS("FNEG.S"),
		FLW("FLW"),
		FSW("FSW"),
		GETF("GETF"),
		PUTF("PUTF"),
		FIMMS("FIMM.S"),
		FLT("FLT.S"),
		FLE("FLE.S"),
		FEQ("FEQ.S"),
		/* FUNCTION CALL AND RETURN */
		JR("JR"),
		RET("RET");


		private String opCodeName;
		private OpCode(String name) {
			this.opCodeName = name;
		}

		public String toString() {
			return this.opCodeName;
		}
	}
	
	public String src1; //holds src operand, if needed
	public String src2; //holds src operand, if needed
	public String dest; //holds destination operand, if needed
	public String label; //holds other value (immediate, label)
	OpCode oc; //op code
	//public String opCodeType; // add for step 5 partiting step to check for branch instructions// not worth it atm
	/** 
	 * Default constructor, not used except by implementing class
	 */
	protected Instruction() {
    }

    /**
	 * @return Returns destination of instruction. Useful for code generation
	 */
    public String getDest() {
        return this.dest;
	}
	
	public enum Operand {
		SRC1,
		SRC2,
		DEST
	};

	public OpCode getOC() {
		return oc;
	}

	public String getOperand(Operand o) {
		switch (o) {
			case SRC1: return src1;
			case SRC2: return src2;
			case DEST: return dest;
			default: throw new Error("Shouldn't get here");
		}
	}

	public String getLabel() {
		return label;
	}

	public boolean is3AC(Operand o) {
		switch (o) {
			case SRC1: return is3AC(src1);
			case SRC2: return is3AC(src2);
			case DEST: return is3AC(dest);
			default: throw new Error("Shouldn't get here");
		}
	}

	static public boolean is3AC(String s) {
		return ((s != null) && (s.charAt(0) == '$'));
	}

	public boolean is3AC() {
		return (is3AC(Operand.SRC1) ||
				is3AC(Operand.SRC2) ||
				is3AC(Operand.DEST));
	}
}