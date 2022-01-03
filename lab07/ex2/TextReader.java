package lab07.ex2;
import java.util.Scanner;
import java.io.*;



public class TextReader implements Text_interface{
    private File text;
    private Scanner sc;

    public TextReader(String text_file){
        try {
            this.text = new File(text_file);
            this.sc = new Scanner(this.text);
        } catch (Exception e) {
            System.err.println("[ERROR]: Can't open file");
            System.exit(1);
        }
    }

    public boolean hasNext(){
        return sc.hasNext();
    }

    public String next(){
        return sc.nextLine();
    }
        


}
