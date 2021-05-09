package interpreter.bytecode;
import interpreter.*;

import java.util.ArrayList;

public class DumpCode extends ByteCode{

    private String dump;
    private String byteCodename = "DUMP";



    @Override
    public void init(String param) {
        this.dump=param;

    }

    public void execute(VirtualMachine vm){
        vm.setDump(dump);
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
