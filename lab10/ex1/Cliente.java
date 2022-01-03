package lab10.ex1;

public class Cliente extends Observer{
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void licitar_Produto(Produto p, int preco){
        if (p.getState() == Estados.LEILAO)
            p.register(preco, this);
        else
            System.out.println("Produto não está para leilão");
    }

    @Override
    public void update(String message) {
        System.out.println("[Cliente "+ this.nome+"]: "+message);        
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "Cliente";
    }


    @Override
    public String toString() {
        return this.nome;
    }



}
