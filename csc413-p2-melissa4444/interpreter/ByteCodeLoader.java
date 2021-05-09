
package interpreter;
import interpreter.bytecode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ByteCodeLoader {

    private BufferedReader byteSource;

    /*private Program program;
    private String[] token = new String[2];
    private int linenum = -1;*/
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        /*
            this constructor will create a new bytecode loader which contains a BufferedReader
            object. Uses the programFile string to initialize th eBufferReader. Reading from the
            file IS NOt allows from the constructor
        */

        this.byteSource = new BufferedReader(new FileReader(file));
        /*this.program = new Program();*/
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        /*
        * this function is responsible for loading all bytecodes into the program object. once all
        * bytecodes have been loaded and initialized, the function then will request that the
        * program example of a before and after has been given in the Program section.
        *
        */



        String nextIn;
        String classname;
        ArrayList<String> bcList;
        StringTokenizer token;
        Class c;
        ByteCode bc;
        Program program= new Program();

        try{
            while((nextIn=byteSource.readLine()) != null){
                bcList=new ArrayList<>();
                token=new StringTokenizer(nextIn);

                classname=CodeTable.getClassName(token.nextToken());
                c=Class.forName("interpreter.bytecode." +classname);
                bc=(ByteCode) c.getDeclaredConstructor().newInstance();

                while(token.hasMoreTokens())
                    bcList.add(token.nextToken());
                bc.init(bcList);
                program.addCode(bc);

            }

        }catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | IOException e){
            e.printStackTrace();
        }



        program.resolveAddrs(program);

        return program;
    }
}