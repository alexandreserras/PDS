package lab07.ex2;

public class VowellFilter extends Text_abstract{
    VowellFilter(Text_interface t) {super(t);}

    public String next(){
        return super.next().replace("A","")
                .replace("a", "")
                .replace("E", "")
                .replace( "e", "")
                .replace( "I","")
                .replace("i", "")
                .replace("O","")
                .replace("o", "")
                .replace("U", "")
                .replace("u","");
    }
}
