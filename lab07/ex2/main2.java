package lab07.ex2;

public class main2 {
    public static void main(String[] args) {
        System.out.println("Using no filters:");
        Text_interface reader = new TextReader("Teste.txt");
        System.out.println(reader.next()+"\n");

        System.out.println("Using NormalizationFilter:");
        reader = new NormalizationFilter(new TextReader("Teste.txt"));
        System.out.println(reader.next()+"\n");

        System.out.println("Using CapitalizationFilter:");
        reader = new CapitalizationFilter(new TextReader("Teste.txt"));
        System.out.println(reader.next()+"\n");

        System.out.println("Using TermFilter:");
        reader = new TermFilter(new TextReader("Teste.txt"));
        System.out.println(reader.next()+"\n");

        System.out.println("Using VowellFilter");
        reader = new VowellFilter(new TextReader("Teste.txt"));
        System.out.println(reader.next()+"\n");


        System.out.println("Using all filters:");
        reader = new VowellFilter(new NormalizationFilter(new CapitalizationFilter(new TermFilter(new TextReader("Teste.txt")))));
        System.out.println(reader.next());
    }
}
