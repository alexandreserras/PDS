package lab09.ex2;

public class SushiChef extends Chef{
    @Override
    public void responsavel(String pedido){
        if (canHandle(pedido.toLowerCase(), "sushi")){
            System.out.println("SushiChef: Starting to cook " +pedido+". Out in 14 minutes!");
        }
        else{
            System.out.println("SushiChef: I can't cook that.");
            super.responsavel(pedido);
        }
    }
}
