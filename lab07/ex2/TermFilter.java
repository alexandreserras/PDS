package lab07.ex2;

public class TermFilter extends Text_abstract{
    protected String [] paragraph;
    protected int contador, sizePara;
    
    TermFilter(Text_interface t) {
        super(t);
        paragraph = t.next().split(" ");
        sizePara=paragraph.length;
        contador=0;
    }


    @Override
    public boolean hasNext() {
        if (contador != -1) 
            return true;
        return false;
    }



    @Override
    public String next(){
        if (contador==sizePara && super.hasNext()){
            paragraph = t.next().split(" ");
            sizePara=paragraph.length;
            contador=0;
        }
        else if (contador==sizePara && !super.hasNext()){
            contador=-1;
        }
        return paragraph[contador++];
    }
}
