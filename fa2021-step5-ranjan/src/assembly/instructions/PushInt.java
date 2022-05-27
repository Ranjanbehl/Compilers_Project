package assembly.instructions;

//3AC to push a value on the stack

public class PushInt extends Instruction {
    
    public PushInt(String src) {
        super();
        this.src1 = src;
    }

    public String toString() {
        return "PUSH " + src1;
    }

    @Override
    public boolean is3AC() {
        return true;
    }
}