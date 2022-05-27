package assembly.instructions;

//3AC to push a value on the stack

public class PopFloat extends Instruction {
    
    public PopFloat(String src) {
        super();
        this.src1 = src;
    }

    public String toString() {
        return "POPFLOAT " + src1;
    }

    @Override
    public boolean is3AC() {
        return true;
    }
}