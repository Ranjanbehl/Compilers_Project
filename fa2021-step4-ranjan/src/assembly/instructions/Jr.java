package assembly.instructions;

/**
 * Class corresponding to RISC-V JR instruction
 * 
 * Models: jr label #jump to label, store pc+4 in return register
 */
public class Jr extends Instruction {

    /**
     * Initializes a jr instruction that will print: JR label
     * 
     * @param label label to jump to
     */
    public Jr(String label) {
        super();
        this.label = label;
        this.oc = OpCode.JR;
    }

    @Override
    public String toString() {
        return OpCode.JR + " " + label;
    }
}