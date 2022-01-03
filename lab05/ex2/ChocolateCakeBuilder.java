package ex2;
public class ChocolateCakeBuilder extends CakeBuilderAbs{

    @Override
    public void addCreamLayer(){
        cake.setMidLayerCream(Cream.VANILLA);
    }
    @Override
    public void addTopLayer(){
        cake.setTopLayerCream(Cream.WHIPPED_CREAM);
    }
    @Override
    public void addTopping(){
        
        cake.setTopping(Topping.FRUIT);
    }
    public  void addCakeLayer(){
        cake.setCakeLayer(" Soft chocolate");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
    
   
    
}
