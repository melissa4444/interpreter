package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;


public class ReturnCode extends ByteCode{
        private int line;
        private String label;
        private int popValue;
        private final String byteCodename="RETURN";

    @Override
    public void init(String param) {
        this.label=param;
    }

    @Override
    public void execute(VirtualMachine vm) {
        popValue=vm.pop();
        vm.popFrame();
        vm.push(popValue);
        line=vm.popReturnAddrs();
        vm.setPc(line);
        if (vm.getDump()){
            System.out.println("\n"+byteCodename+" "+label);
        }
    }

    @Override
    public String byteCodename() {
        return byteCodename();
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int address) {

    }


}