package assembly.instructions;

/**
 * Class for Branch if greater than
 * 
 * Models beq src1 src2 label #jump to label if src1 > src2
 */
public class Bgt extends InstructionBranch {

    /**
     * Initializes a BEQ instruction that will print BGT src1, src2, label
     * 
     * @param dest Destination register
     */
    public Bgt(String src1, String src2, String label) {
        super(src1, src2, label);
        this.oc = OpCode.BGT;
    }
}