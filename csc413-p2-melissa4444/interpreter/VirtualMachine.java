package interpreter;
import interpreter.bytecode.*;


import java.util.Stack;


public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private final Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpflag=false;


    VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc=0;
        runStack = new RunTimeStack();
        returnAddrs=new Stack();
        isRunning=true;


        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (dumpflag && !(code.byteCodename().equals("DUMP"))){
                runStack.dump();
            }
            pc++;
        }



    }

    public void setPc(int pc){
        this.pc=pc;
    }
    public int getPc(){
        return this.pc;
    }

    public void pushReturnAddrs(int address){
        //noinspection unchecked
        returnAddrs.push(address);

    }
    public int popReturnAddrs(){
        return (Integer)returnAddrs.pop();
    }
    public int peek(){
        return this.runStack.peek();
    }
    public int pop(){
        return runStack.pop();

    }

    public int load(int offset){
        return this.runStack.load(offset);
    }
    public void store(int offset){
        runStack.store(offset);
    }
    public void push(int val){
        runStack.push(val);
    }
    public void push(Integer val){
        runStack.push(val);
    }
    public void newFrameAt(int frameAddress){
        runStack.newFrameAt(frameAddress);
    }
    public void popFrame(){
        this.runStack.popFrame();
    }
    public int getStackSize(){
        return runStack.stackSize();
    }


    public void setDump(String dump) {
        this.dumpflag= dump.equals("ON");

    }
    public boolean getDump(){
        return this.dumpflag;
    }
    public void setRunFlag(){
        this.isRunning=false;
    }


}