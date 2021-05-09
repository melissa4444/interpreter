package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;


public class ArgsCode extends ByteCode{

    private int offset;
    private int address;

    private final String byteCodename ="ARGS";

    public void init (String param){
        this.offset =  Integer.parseInt(param);

    }
    public void execute (VirtualMachine vm){
        address = vm.getStackSize()-this.offset;
        vm.newFrameAt(address);


        if (vm.getDump()){
            System.out.println("\n"+ byteCodename() +" "+offset);
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