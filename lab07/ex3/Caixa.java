package lab07.ex3;
import java.util.ArrayList;
import java.util.List;


public class Caixa  extends AlimeInter{
    private double peso;
    private double pesoTotal;
    private String nome;
    private List<AlimeInter> box;

    public Caixa(String nome,double peso) {
        this.peso = peso;
        this.pesoTotal = peso;
        this.nome = nome;
        this.box=new ArrayList<>();
    }

    public double getPeso() {
        return this.peso;
    }

  

    public double getPesoTotal() {
        return this.pesoTotal;
    }

   

    public String getNome() {
        return this.nome;
    }

   
    public List<AlimeInter> getBox() {
        return this.box;
    }



    public void add (AlimeInter al){
        this.box.add(al);
        this.pesoTotal+=al.getPesoTotal();
    }

    public double totalCaixa(){
        this.pesoTotal=this.peso;
        for (AlimeInter i : this.box){
            this.pesoTotal+=i.getPesoTotal();
        }
        return this.pesoTotal;
    }
    public void draw(){
        System.out.println(indent+"* Caixa '"+this.getNome()+ "' [ Weight:"+this.getPeso()+ "; Total:"+this.totalCaixa()+ " ]");
        indent.append("   ");
        for (AlimeInter i : this.box){
            i.draw();
        }
        indent.setLength(indent.length()-3);
    }


}
