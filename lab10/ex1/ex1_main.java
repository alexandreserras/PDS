package lab10.ex1;

public class ex1_main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Pastilhas", 0.99);
        Produto p2 = new Produto("Quadro", 13.99);
        Produto p3 = new Produto("Teclado", 15.99);
        Produto p4 = new Produto("Alcool Gel", 4.99);
        Produto p5 = new Produto("Capa telemóvel", 6.99);

        Gestor g = new Gestor("DG");

        Cliente c1 = new Cliente("Reis");
        Cliente c2 = new Cliente("Dx");
        Cliente c3 = new Cliente("Artur");


        g.comecar_leilao(3000, p1);
        c2.licitar_Produto(p1, 1);
        c1.licitar_Produto(p1, 2);
        c3.licitar_Produto(p2, 1);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c1.licitar_Produto(p1, 3);
        
        
    }
}
