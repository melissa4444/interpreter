package interpreter.bytecode;

import interpreter.*;

import java.util.ArrayList;

public abstract class ByteCode {
    public abstract void init(String args);
    public abstract void execute(VirtualMachine vm);
    public abstract String byteCodename();
    public abstract void init(ArrayList<String> args);
    public abstract String getLabel();
    public abstract void setAddress(int address);
}