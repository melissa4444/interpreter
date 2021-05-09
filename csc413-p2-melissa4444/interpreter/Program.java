package interpreter;

import interpreter.bytecode.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Program {

      private ArrayList<ByteCode> program;



      private HashMap<String, Integer> label;

      public Program(){
          this.program=new ArrayList<>();
          this.label=new HashMap<>();
      }



    ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    private int getSize() {
        return this.program.size();
    }

    void addCode(ByteCode bc){
        this.program.add(bc);
    }

   /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
    *
    *
    */


    public void resolveAddrs(Program program) {

        for (ByteCode bc : this.program){
            if (bc instanceof FalseBranchCode || bc instanceof GotoCode || bc instanceof CallCode || bc instanceof ReturnCode){
                String label = bc.getLabel();

                for (int i=0; i< getSize(); i++)
                    if (this.program.get(i) instanceof LabelCode && this.program.get(i).getLabel().equals(label)) {
                        bc.setAddress(i - 1);
                        break;
                    }
            }
        }



    }



}