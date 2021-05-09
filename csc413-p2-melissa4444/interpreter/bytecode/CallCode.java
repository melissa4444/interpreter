package interpreter.bytecode;

import interpreter.*;

import java.util.ArrayList;


public class CallCode extends ByteCode {

    private String label;
    private int line;
    private final String byteCodename="CALL";

    private int address;

    @Override
    public void execute(VirtualMachine vm){
        vm.pushReturnAddrs(vm.getPc());
        vm.setPc((this.line)-1);
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
    public void init(String param){
        this.label=param;
    }

    @Override
    public String getLabel(){
        return label;
    }

    @Override
    public void setAddress(int address) {
        this.address=address;
    }









}