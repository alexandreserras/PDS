package lab09.ex2;

public class PizzaChef extends Chef{
    @Override
    public void responsavel(String pedido){
        if (canHandle(pedido.toLowerCase(), "pizza")){
            System.out.println("PizzaChef: Starting to cook " +pedido+". Out in 7 minutes!");
        }
        else{
            System.out.println("PizzaChef: I can't cook that.");
            super.responsavel(pedido);
        }
    }
}
