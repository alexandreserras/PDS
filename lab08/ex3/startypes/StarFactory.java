package startypes;
import java.util.HashMap;
import java.awt.Color;
public class StarFactory {
    private Color c;
    private int size;
    private String des;
    public StarFactory(Color c,int size, String dec ){
        this.c=c;
        this.size=size;
        this.des=des;
    }

    public Color getC() {
        return this.c;
    }

   

    public int getSize() {
        return this.size;
    }

    

    public String getDes() {
        return this.des;
    }

   
   

}
