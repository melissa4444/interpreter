package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;


public class WriteCode extends ByteCode{
    private final String byteCodename="WRITE";

    @Override
    public void init(String param) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("\n");
        System.out.println(vm.peek());
        if (vm.getDump()){
            System.out.println("\n"+byteCodename);
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
