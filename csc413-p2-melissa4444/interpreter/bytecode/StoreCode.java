package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;


public class StoreCode extends ByteCode {
    private int offset;
    private String[] parameter;
    private final String byteCodename="STORE";
    @Override
    public void init(String param) {
        parameter=param.split(" ",2);
        this.offset=Integer.parseInt(parameter[0]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
        if (vm.getDump()){
            System.out.println("\n"+byteCodename+" "+parameter[0]+" "+parameter[1]);
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