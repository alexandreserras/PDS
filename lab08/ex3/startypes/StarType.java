package startypes;
import java.awt.*;

public abstract class StarType {

    private StarFactory st;
    private int x;
    private int y;

    public StarType(StarFactory st, int x, int y) {
        this.st=st;
        this.x = x;
        this.y = y;
    }

    
    public void draw(Graphics g) {
        //System.out.println(x + " " + y + " " + color);
        
        g.setColor(this.st.getC());
        g.fillOval(x, y , this.st.getSize(), this.st.getSize());
    }





    
    

    
}
