package assembly.instructions;

/**
 * Class corresponding to RISC-V J instruction
 * 
 * Models: j label #goto label
 */
public class J extends Instruction {

    /**
     * Initializes a jump instruction that will print: J label
     * 
     * @param label label to jump to
     */
    public J(String label) {
        super();
        this.label = label;
        this.oc = OpCode.J;
    }

    @Override
    public String toString() {
        return OpCode.J + " " + label;
    }
}