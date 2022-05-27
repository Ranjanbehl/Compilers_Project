package assembly.instructions;

/**
  * Class for Branch if less than
 * 
 * Models beq src1 src2 label #jump to label if src1 < src2
 */
public class Blt extends InstructionBranch {

    /**
     * Initializes a BEQ instruction that will print BLT src1, src2, label
     * 
     * @param dest Destination register
     */
    public Blt(String src1, String src2, String label) {
        super(src1, src2, label);
        this.oc = OpCode.BLT;
    }
}