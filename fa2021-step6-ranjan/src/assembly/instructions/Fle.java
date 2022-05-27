package assembly.instructions;

/**
 * Class corresponding to RISC-V FLE.S instruction
 * 
 * Models: fle.s dest src1 src2 #dest = (src1 <= src2) ? 1 : 0
 * 
 * Uses the <code>toString</code> method of {@link Instruction3O} to emit code
 */
public class Fle extends Instruction3O {

    /**
     * Initializes an FLE instruction that will print: FLE.S dest src1 src2
     * 
     * @param src1 source operand 1
     * @param src2 source operand 2
     * @param dest destination operand
     */
    public Fle(String src1, String src2, String dest) {
        super(src1, src2, dest);
        this.oc = OpCode.FLE;
    }
    
}