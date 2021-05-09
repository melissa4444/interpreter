package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.ArrayList;


public class LitCode extends ByteCode{
    private Integer value;
    private String args;
    private String[] parameter;
    private final String byteCodename="LITCODE";
    @Override
    public void init(String param) {
        args=param;
        parameter=param.split(" ", 2);
        this.value=Integer.parseInt(parameter[0]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(this.value);
        if (vm.getDump()){
            System.out.println("\n"+byteCodename+" "+args );
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
        return null;
    }

    @Override
    public void setAddress(int address) {

    }


}