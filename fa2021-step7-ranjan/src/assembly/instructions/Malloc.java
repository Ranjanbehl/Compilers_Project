package assembly.instructions;

public class Malloc extends Instruction {

    String src;
    String dst;

    /**
     * Models the magic instruction MALLOC
     */
    public Malloc(String src, String dst) {
        super();
        this.src = src;
        this.dst = dst;
        this.oc = OpCode.MALLOC;
    }

    /**
     * @return "HALT"
     */
    public String toString() {
        return String.valueOf(this.oc) + " " + dst + ", " + src;
    }
}