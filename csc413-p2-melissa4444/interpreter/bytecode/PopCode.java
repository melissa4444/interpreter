package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;


public class PopCode extends ByteCode {

    private int popNumber;
    private String popParameter;
    private final String byteCodename="POP";
    @Override
    public void init(String param) {
        this.popParameter=param;
        this.popNumber=Integer.parseInt(popParameter);
    }

    @Override
    public void execute(VirtualMachine vm) {
        while(popNumber!=0){
            vm.pop();
            popNumber--;
        }
        if (vm.getDump()){
            System.out.println("\n"+byteCodename+" "+popParameter);
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
