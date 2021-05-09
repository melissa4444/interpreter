package interpreter;
import java.util.ArrayList;
import java.util.Stack;
/*  recordes and processes the stack of active frames. this class will contain two data structures
*   1. Stack FramePointer
*       a. this stack is used to record the beginning of each activation record(frame) when
*       calling functions
*   2.ArrayList<Integer>runStack
*       a. this ArrayList is used tp represent the runtime stack. It will be an ArrayList because
*           we will need to access all locations of th runtime stack.
*
* ADD
* public void dump()
*       void function used to dump the current state of the RuntimeStack. When printing the runtime stack make
*           sure to include divisions between frames. If a frame is empty. If a frame is empty, this must
*           be shown as well.
* public int peek()
*       returns the top of the stack without removing the item
* public int pop()
*       removes an item from teh top of the stack and returns it
* public void newFrameAt(int offset)
*       creates a new frame in the RuntimeStack class. the parameter offset is used to denote how many slots down
*       from the top of RuntimeStack for starting a new frame
* public void popFrame()
*       pop the top frame when we return from a function. before popping, the functions return value is at the top
*       of the stack, so we'll save the value, then pop the top frame and then push the return value back onto
*       the stack. It is assumed return values are at the top of the stack
* public int store(int offset)
*       used to store values into variables. Store will pop the top value of the stack and replace the value at
*       the given offset in the current frame. the value stores is returned.
* public int load(int offset)
*       used to load variables onto the RunTimeStack from a given offset within the current frame. This means
*       we will go to the offset in the current frame, copy the value and push it to the top of the stack. No
*       values should be removed with load
* public Integer push(Integer val)
*       used to load literal values onto the RuntimeStack. For example, LIT 5 or LIT 0 will call push with val
*       being 0
* */

public class RunTimeStack {

    private final ArrayList<Integer> runTimeStack;
    private final Stack<Integer> framePointer;
    private int popvalue;
    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.add(0);

    }
    public void dump(){
        int index;
        int startframe;
        int endframe;

        for (index=0; index<this.framePointer.size();index++){
            System.out.println("[");
            startframe=this.framePointer.get(index);
            if (index==this.framePointer.size()-1){
                if (this.stackSize()==0){
                    endframe=0;
                }else{
                    endframe=this.stackSize();
                }
            }else{
                endframe=(this.framePointer.get(index+1));
            }
            for (int i=startframe; i< endframe; i++){
                System.out.printf("%d",runTimeStack.get(i));
                if (i<endframe-1){
                    System.out.println(",");
                }
            }
            System.out.println("]");
        }
    }

    public int peek(){
        return this.runTimeStack.get(runTimeStack.size()-1);
    }//
    public int pop(){
        popvalue=0;
        if (! runTimeStack.isEmpty()){
            return runTimeStack.remove(runTimeStack.size()-1);
        }
        return popvalue;
    }
    public void newFrameAt(int offset){
       this.framePointer.push(offset);
    }//
    public void popFrame(){
       this.runTimeStack.subList(this.framePointer.peek(),(this.runTimeStack.size())).clear();
       this.framePointer.pop();
    }

   public void store(int offset){
        int storeValue = this.pop();
        runTimeStack.set(framePointer.peek()+offset, storeValue);

   }

   public int load(int offset){
     return this.runTimeStack.get(offset+this.framePointer.peek());
   }

   public void push(int i){
        this.runTimeStack.add(i);
   }


   public void push(Integer i){
        this.runTimeStack.add(i);
   }
   protected int stackSize(){
        return this.runTimeStack.size();
   }
}
