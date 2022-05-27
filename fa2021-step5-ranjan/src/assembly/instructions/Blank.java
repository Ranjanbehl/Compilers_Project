package assembly.instructions;

/**
 * Dummy instruction that just prints a blank space
 */
public class Blank extends Instruction {

    String comment;

    public Blank() {
        comment = "";
    }

    public Blank(String c) {
        this.comment = c;
    }

    /**
     * @return ""
     */
    public String toString() {
        return ";" + comment;
    }
}