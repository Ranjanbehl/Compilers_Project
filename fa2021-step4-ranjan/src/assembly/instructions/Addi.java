package assembly.instructions;

/**
 * Class corresponding to RISC-V ADDI instruction
 * 
 * Models: addi dest src1 imm #dest = src1 + imm
 * 
 * Uses the <code>toString</code> method of {@link Instruction3O} to emit code
 */
public class Addi extends Instruction3O {

    /**
     * Initializes an ADDI instruction that will print: ADDI dest src1 src2
     * 
     * @param src1 source operand 1
     * @param imm source operand 2
     * @param dest destination operand
     */
    public Addi(String src1, String imm, String dest) {
        super(src1, imm, dest);
        this.oc = OpCode.ADDI;
    }
    
}