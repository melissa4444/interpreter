package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;
    private final String byteCodename="LABEL";

    @Override
    public void init(String param) {
        this.label=param;
    }

    @Override
    public void execute(VirtualMachine vm) {
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
        args.get(0);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setAddress(int address) {

    }


}
