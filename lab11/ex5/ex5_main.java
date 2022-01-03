package lab11.ex5;

import java.io.IOException;

public class ex5_main {
    public static void main(String[] args) throws IOException {
        //dados
        boolean recursive;
        

        //verificação de input
        if (args.length>2){
            System.out.println("[Error] Invalid paramethers");
            System.exit(1);
        }
        if (args.length==2){
            recursive = true;
        }
        else {
            recursive=false;
        }
        Visitor v = new Visitor(recursive, args[args.length-1]);
        System.out.println("Total: "+v.total_memory()+" kbytes");
    }
}
