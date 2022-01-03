package ex2;
public class SpongeCakeBuilder extends CakeBuilderAbs {
    public  void addCreamLayer(){
        cake.setMidLayerCream(Cream.RED_BERRIES);
    }
    public  void addTopLayer(){
        cake.setTopLayerCream(Cream.WHIPPED_CREAM);
    }
    public  void addTopping(){
        cake.setTopping(Topping.FRUIT);
    }
    public  void addCakeLayer(){
        cake.setCakeLayer(" Sponge ");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
   
  
}
