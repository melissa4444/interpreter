package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;


public class ReadCode extends ByteCode {
    private int inputvalue;
    private boolean inputInvalid=true;
    private final String byteCodename="READ";

    @Override
    public void init(String param) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner input = new Scanner(System.in);
        System.out.println("input int:  ");
        while (inputInvalid){
            if (input.hasNextInt()){
                inputvalue=input.nextInt();
                if (inputvalue<0){
                    System.out.println("Incorrect");
                }else {
                    vm.push(inputvalue);
                    inputInvalid = false;
                }
                }else{
                    System.out.println("Incorrect");
                    input.next();
                }
            }
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
