package assembly.instructions;

/**
 * Superclass for branch instructions
 * 
 * Models: b<op> src1 src2 label #if (src1 op src2) goto label
 */
public abstract class InstructionBranch extends Instruction {
	
	protected InstructionBranch(String src1, String src2, String label) {
		super();

		this.src1 = src1;
		this.src2 = src2;
		this.label = label;
	}

	/**
	 * @return "op dest src1 src2"
	 */
	public String toString() {
		return this.oc + " " + this.src1 + ", " + this.src2 + ", " + this.label;
	}
}