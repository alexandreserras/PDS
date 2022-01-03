package lab07.ex3;

public class Doce extends AlimeInter{
    private double peso;
    private String nome;



    public Doce( String nome,double peso) {
        this.peso = peso;
        this.nome = nome;
    }


    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println(indent.toString()+" Doce '"+this.getNome()+ "' "+  " - Weight:"+this.getPesoTotal()+ " ");
    }

    @Override
    public double getPesoTotal() {
       return this.peso;
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}
