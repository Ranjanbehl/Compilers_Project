package assembly.instructions;

/**
  * Class for Branch if greater than or equal
 * 
 * Models beq src1 src2 label #jump to label if src1 >= src2
 */
public class Bge extends InstructionBranch {

    /**
     * Initializes a BEQ instruction that will print BGE src1, src2, label
     * 
     * @param dest Destination register
     */
    public Bge(String src1, String src2, String label) {
        super(src1, src2, label);
        this.oc = OpCode.BGE;
    }
}