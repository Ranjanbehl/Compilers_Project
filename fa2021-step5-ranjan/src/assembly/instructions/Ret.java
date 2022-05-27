package assembly.instructions;

/**
 * Class for return instruction
 * 
 * Models ret #jump to location in ra register
 */
public class Ret extends Instruction {

    /**
     * Models the magic instruction HALT
     */
    public Ret() {
        super();
        this.oc = OpCode.RET;
    }

    /**
     * @return "RET"
     */
    public String toString() {
        return String.valueOf(this.oc);
    }
}