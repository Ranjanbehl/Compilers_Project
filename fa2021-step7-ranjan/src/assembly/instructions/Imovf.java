package assembly.instructions;

public class Imovf extends Instruction{
/**
     * Initializes a MV instruction that will print: IMOVF.s dest src
     * 
     * @param src source operand 1
     * @param dest destination operand
     */

    public Imovf(String src, String dest) {
        super();
        this.src1 = src;
        this.dest = dest;
        this.oc = OpCode.IMOVFS;
    }

    /**
     * @return "IMOVF.s dest src"
     */
    public String toString() {
        return this.oc + " " + this.dest + ", " + this.src1;
    }
    
}
