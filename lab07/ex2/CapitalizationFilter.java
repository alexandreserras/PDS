package lab07.ex2;

public class CapitalizationFilter extends Text_abstract{
    CapitalizationFilter(Text_interface t) {super(t);}


    @Override
    public String next(){
        String ret="";
        String texto = super.next();
        char primeiro = Character.toUpperCase(texto.charAt(0));
        ret+=primeiro;
        int tamanho = texto.length();
        ret+= texto.substring(1, tamanho-2).toLowerCase();
        char ultimo = Character.toUpperCase(texto.charAt(tamanho-1));
        ret+=ultimo;
        return ret;
    }
}
