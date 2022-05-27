package assembly.instructions;

public class FMovi extends Instruction{
    /**
     * Initializes a Float mov to Int instruction that will print: FMOIV.s dest src
     * 
     * @param src source operand 1
     * @param dest destination operand
     */

    public FMovi(String src, String dest) {
        super();
        this.src1 = src;
        this.dest = dest;
        this.oc = OpCode.FMOVIS;
    }

    /**
     * @return "FMOIV.s dest src"
     */
    public String toString() {
        return this.oc + " " + this.dest + ", " + this.src1;
    }  
}
