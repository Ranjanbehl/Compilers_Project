package assembly.instructions;

/**
 * Class corresponding to RISC-V FEQ.S instruction
 * 
 * Models: feq.s dest src1 src2 #dest = (src1 == src2) ? 1 : 0
 * 
 * Uses the <code>toString</code> method of {@link Instruction3O} to emit code
 */
public class Feq extends Instruction3O {

    /**
     * Initializes an FEQ instruction that will print: FEQ.S dest src1 src2
     * 
     * @param src1 source operand 1
     * @param src2 source operand 2
     * @param dest destination operand
     */
    public Feq(String src1, String src2, String dest) {
        super(src1, src2, dest);
        this.oc = OpCode.FEQ;
    }
    
}