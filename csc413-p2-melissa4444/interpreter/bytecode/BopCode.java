package interpreter.bytecode;
import interpreter.*;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String operator;
    private int topOperator, secondOperator;

    private final String byteCodename = "BOP";



    @Override
    public void init(String param) {
        this.operator=param;
    }
    @Override
    public void execute(VirtualMachine vm){


        this.secondOperator=vm.pop();
        this.topOperator=vm.pop();


        if (this.operator.equals("+")){
            vm.push((secondOperator+topOperator));
        }
        else if(this.operator.equals("-")){
            vm.push((secondOperator-topOperator));
        }
        else if(this.operator.equals("/")){
            vm.push((secondOperator/topOperator));
        }
        else if(this.operator.equals("*")){
            vm.push((secondOperator*topOperator));
        }
        else if(this.operator.equals("==")){
            if (secondOperator==topOperator)
                vm.push(1);
                else
                    vm.push(0);

        }
        else if (this.operator.equals("!=")){
            if (secondOperator==topOperator)
                vm.push(0);
            else
                vm.push(1);
        }
        else if (this.operator.equals("<=")){
            if (secondOperator<=topOperator)
                vm.push(1);
            else
                vm.push(0);
        }
        else if (this.operator.equals("<")){
            if (secondOperator<topOperator)
                vm.push(1);
            else
                vm.push(0);
        }
        else if (this.operator.equals(">=")){
            if (secondOperator>=topOperator)
                vm.push(1);
            else
                vm.push(0);
        }
        else if (this.operator.equals(">")){
            if (secondOperator>topOperator)
                vm.push(1);
            else
                vm.push(0);
        }
        else if (operator.equals("|")){
            if ((secondOperator !=0) || (topOperator !=0))
                vm.push(1);
            else
                vm.push(0);
        }
        else if (this.operator.equals("&")){
            if ((secondOperator != 0 ) && (topOperator !=0))
                vm.push(1);
            else
                vm.push(0);
        }
        vm.push(0);

        if (vm.getDump()){
            System.out.println("\n"+byteCodename()+" "+operator);
        }

    }




    @Override
    public String byteCodename()
    {
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