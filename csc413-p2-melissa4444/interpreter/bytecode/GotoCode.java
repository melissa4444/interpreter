package interpreter.bytecode;
import interpreter.*;

import java.util.ArrayList;


public class GotoCode extends ByteCode {
    private String labelToGo;
    private int lineToGo;

    private final String byteCodename="GOTO";

    @Override
    public void init(String param) {
        this.labelToGo=param;

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPc((this.lineToGo)-1);
        if (vm.getDump()){
            System.out.println("\n"+byteCodename+" "+ labelToGo);
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
