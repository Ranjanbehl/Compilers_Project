package assembly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import assembly.instructions.Instruction;
import assembly.instructions.Instruction.OpCode;
import assembly.instructions.Instruction.Operand;
import compiler.LocalScope;

public class RegisterAllocator {

    public RegisterAllocator(int intRegCount, int floatRegCount, CodeObject body, LocalScope scope) {
        ArrayList<Instruction> statements = new ArrayList<>(body.getCode());
        List<Instruction> leaders = new ArrayList<>();
        List<OpCode> branchInstructions = new ArrayList<>(Arrays.asList(OpCode.BEQ,OpCode.BGE,OpCode.BGT
        ,OpCode.BLE,OpCode.BLT,OpCode.BNE,OpCode.J,OpCode.JR,OpCode.RET,OpCode.HALT));
        List<InstructionList> blocks = new ArrayList<>();
        leaders.add(statements.get(0)); //first statement always in the leaders list
        for(int i = 1; i < statements.size(); i++){
            Instruction potentialTarget = statements.get(i);
            if(branchInstructions.contains(potentialTarget.getOC())){
                leaders.add(potentialTarget);
            }
        }
        while(!leaders.isEmpty()){
            Instruction x = leaders.remove(0); // remove the earliest element 
            InstructionList block = new InstructionList();
            block.add(x);
            for(int i = statements.indexOf(x) + 1; i < statements.size() && !leaders.contains(statements.get(i)); i++){
                block.add(statements.get(i));
            }
            blocks.add(block); 
        }

        //Perform livness analysis for each basic block 
        // Lin = (Lout - K ) U G
        ArrayList<ArrayList<HashSet<String>>> funLiveList = new ArrayList<ArrayList<HashSet<String>>>();
        for(int i = 0; i < blocks.size(); i++){
            ArrayList<HashSet<String>> blockLiveList = new ArrayList<HashSet<String>>();
            HashSet<String> FirstliveSet = new HashSet<>(); //always empty? as nothing should be live after the last insttruction
            blockLiveList.add(FirstliveSet);
            for (int j = 1; j < blocks.get(i).size(); j++){
                HashSet<String> liveSet = new HashSet<>(blockLiveList.get(j - 1)); // add the pervious live set to current live set 
                InstructionList blockInsList = blocks.get(i);
                Instruction out = blockInsList.getLast();
                if(liveSet.contains(out.getOperand(Operand.SRC1))){
                    liveSet.remove(out.getOperand(Operand.SRC1)); // killed 
                }
                liveSet.add(out.getOperand(Operand.SRC2));
                liveSet.add(out.getOperand(Operand.DEST));
                blockLiveList.add(liveSet);
            }
            funLiveList.add(blockLiveList);
        }

        //perform register allocation 
        HashSet<String> freeIntRegSet = new HashSet<>();
        HashSet<String> freeFloatRegSet = new HashSet<>();
        String intTempPrefix = "$t";
	    String floatTempPrefix = "$f";
        for(int i = 0; i < intRegCount; i++){
            freeIntRegSet.add(intTempPrefix + String.valueOf(i));
        }
        for(int i = 0; i < floatRegCount; i++){
            freeFloatRegSet.add(floatTempPrefix + String.valueOf(i));
        }
        for(int i = 0; i < blocks.size(); i++){
            for(int j  = 0; j < blocks.get(i).size(); i++){
                String Rx = ensure(blocks.get(i).getLast().getOperand(Operand.SRC1)); // getLast() is wrong 
                String Ry = ensure(blocks.get(i).getLast().getOperand(Operand.SRC2));
                if(!funLiveList.get(i).get(j).contains(blocks.get(i).getLast().getOperand(Operand.SRC1))){
                   free(Rx);
                }
                if(!funLiveList.get(i).get(j).contains(blocks.get(i).getLast().getOperand(Operand.SRC2))){
                    free(Ry);
                 }
            }
        }
    }
    HashMap<String,String> registerMap = new HashMap<>();
    int RegCount = 0; // max is 64(32 for int and 32 for float)
    private String ensure(String opr) {
        if(registerMap.containsValue(opr)){
            return registerMap.entrySet().stream().filter(entry -> opr.equals(entry.getValue())).map(Map.Entry::getKey).findFirst().get();
        }
        String R = allocate(opr);
        return R;
        
    }
    private String allocate(String opr) {
        String R = "";
        if(registerMap.size() < 32){
            R = "R" + String.valueOf(RegCount); 
            RegCount++;
        }
        else{
            //chose R to free, this is where the liveness comes into play
        }
        registerMap.put("R" + String.valueOf(RegCount), opr);
        return R;
    }

    private void free(String r) {
        //if r is marked dirty and the variable is live generate store
        //mark r as free
       registerMap.put(r, "");
    }
}
