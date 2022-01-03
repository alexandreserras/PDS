package lab10.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


class TimerLeilao extends TimerTask {
    private Produto prod;
    private int tempo;
    
    private Gestor gestor;
    private Timer timer;

    TimerLeilao ( Produto prod, int tempo, Gestor ob, Timer timer)
    {
        this.prod = prod;
        this.tempo = tempo;
        this.gestor = ob;
        this.timer = timer;
    }
    @Override
    public void run() {
        
        
            timer.cancel();
            gestor.endAuction(prod);
        
    }
}


public class Gestor extends Observer {
    private String nome;
    private Timer t;
    private List<Produto> produtos_stock, produtos_leilao, produtos_vendidos;
    


    public Gestor(String nome) {
        this.nome = nome;
        this.produtos_stock = new ArrayList<>();
        this.produtos_leilao = new ArrayList<>();
        this.produtos_vendidos = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        System.out.println("[GESTOR]: "+message);        
    }


    @Override
    public String getType() {
        return "Gestor";
    }

    public void comecar_leilao(int time, Produto p){
        this.t = new Timer();
        
        if ((p.getState()==Estados.STOCK)){
            p.setTempo(time);
            p.setState(Estados.LEILAO);
            if (!produtos_leilao.contains(p)){
                produtos_leilao.add(p);
            }
            if (produtos_stock.contains(p)){
                produtos_stock.remove(p);
            }
            p.addGestor(this);
            t.schedule(new TimerLeilao(p, time,this, t), time);
        }
        
        
        else{
            System.out.println("Produto não está para leilão");
        }
    }

    public void endAuction(Produto p){
        if (p.getPrecoFinal()==p.getPrecoInicial()){
            p.notifyObservers("Ninguem comprou o produto");
            p.setState(Estados.STOCK);
            if (!produtos_stock.contains(p)){
                produtos_stock.add(p);
            }
            if (produtos_leilao.contains(p)){
                produtos_leilao.remove(p);
            }
        }
        else{
            p.notifyObservers("Produto comprado por " +p.getVencedor()+" pelo preço de "+p.getPrecoFinal()+"€.");
            p.setState(Estados.VENDAS);
            if (!produtos_vendidos.contains(p)){
                produtos_vendidos.add(p);
            }
            if (produtos_leilao.contains(p)){
                produtos_leilao.remove(p);
            }
        }
    }

}
