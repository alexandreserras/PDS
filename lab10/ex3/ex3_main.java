package lab10.ex3;
public class ex3_main {
    public static void main(String[] args) {
            Mediator m = new Tradutor();
            Lingua pt= new Lingua_Portuguesa(m);
            Lingua fr = new Lingua_Francesa(m);
            Lingua pt2= new Lingua_Portuguesa(m);
            pt.enviarMensagem("Olá eu sou o Alexandre ");
            System.out.println("[FR]"+fr.receberMensagem());      
            fr.enviarMensagem("Au_revoir je suis le João");
            System.out.println("[PT] "+ pt.receberMensagem());
            pt2.enviarMensagem("Olá eu sou o Reis e tenho 19 anos");

            System.out.println("[PT] "+pt.receberMensagem());
            System.out.println("[FR] "+fr.receberMensagem());

    }
}
