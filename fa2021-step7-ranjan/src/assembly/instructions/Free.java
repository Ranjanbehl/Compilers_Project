package assembly.instructions;

public class Free extends Instruction {

    String src;

    /**
     * Models the magic instruction MALLOC
     */
    public Free(String src) {
        super();
        this.src = src;
        this.oc = OpCode.FREE;
    }

    /**
     * @return "HALT"
     */
    public String toString() {
        return String.valueOf(this.oc) + " " + src;
    }
}