package assembly.instructions;

/**
 * Class for Branch if Equal
 * 
 * Models beq src1 src2 label #jump to label if src1 == src2
 */
public class Beq extends InstructionBranch {

    /**
     * Initializes a BEQ instruction that will print BEQ src1, src2, label
     * 
     * @param dest Destination register
     */
    public Beq(String src1, String src2, String label) {
        super(src1, src2, label);
        this.oc = OpCode.BEQ;
    }
}