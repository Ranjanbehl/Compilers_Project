package assembly.instructions;

/**
 * Label for jump targets
 */
public class Label extends Instruction {

    /**
     * Creates a label that prints "label:"
     */
    public Label(String label) {
        super();
        this.label = label;
    }

    /**
     * @return "<label>:"
     */
    public String toString() {
        return label + ":";
    }
}