package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;


public class FalseBranchCode extends ByteCode{

    private String label;
    private int line;
    private int popValue;
    private final String byteCodename="FALSEBRANCH";

    @Override
    public void init(String param) {
        this.label=param;
    }

    @Override
    public void execute(VirtualMachine vm) {
        this.popValue=vm.pop();
        if (this.popValue==0){
            vm.setPc((this.line)-1);
        }
        if (vm.getDump()){
            System.out.println("\n"+byteCodename+" "+line);
        }
    }

    @Override
    public String byteCodename() {
        return byteCodename();
    }

    @Override
    public void init(ArrayList<String> args) {
        args.get(0);
    }


    @Override
    public String getLabel(){
        return null;
    }

    @Override
    public void setAddress(int address) {

    }



}
