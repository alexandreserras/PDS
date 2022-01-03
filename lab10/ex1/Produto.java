package lab10.ex1;

import java.sql.Time;   
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id, tempo;
    private static int contador=0;
    private String descricao;
    private double precoInicial, precoFinal;
    private Estados state;
    private List<Observer> obs;
    private Observer vencedor;




    public Produto(String descricao, double preco) {
        this.descricao = descricao;
        this.precoInicial = preco;
        this.precoFinal = preco;
        this.id=contador++;
        this.state = Estados.STOCK;
        this.obs = new ArrayList<>();
        this.vencedor=null;
    }

    public void addGestor(Observer o){
        obs.add(o);
    }


    public Estados getState(){
        return this.state;
    }

    public void setState(Estados e){
        this.state=e;
    }

    public void setTempo(int e){
        this.tempo=e;
    }

    public void notifyObservers(String mensagem) {
        for (Observer o : obs){
            o.update(mensagem);
        }
    }

    public boolean register(int licitacao, Observer o){
        if (this.state==Estados.LEILAO){
            if (!obs.contains(o)){
                obs.add(o);
            }
            if (licitacao>this.precoFinal){
                this.precoFinal=licitacao;
                this.vencedor=o;
                this.notifyObservers("Product: "+this+". "+precoFinal +"€ bid, was made!");
                return true;
            }
            o.update("Invalid bit! Your bit is lower than than the actual bit");
            return false;
            
        }
        o.update("Invalid bit! This product is not in auction state");
        return false;
    }


    public int getId() {
        return this.id;
    }

    public int getTempo() {
        return this.tempo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPrecoInicial() {
        return this.precoInicial;
    }

    public double getPrecoFinal() {
        return this.precoFinal;
    }

    public List<Observer> getObs() {
        return this.obs;
    }

    public Observer getVencedor() {
        return this.vencedor;
    }


    @Override
    public String toString() {
        return " nome: " + getDescricao();
    }




    
}
