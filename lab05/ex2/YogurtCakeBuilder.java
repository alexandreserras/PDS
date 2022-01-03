package ex2;
public class YogurtCakeBuilder extends CakeBuilderAbs {
    public  void addCreamLayer(){
        cake.setMidLayerCream(Cream.VANILLA);
    }
    public  void addTopLayer(){
        cake.setTopLayerCream(Cream.RED_BERRIES);
    }
    public  void addTopping(){
        cake.setTopping(Topping.CHOCOLATE);
    }

    public  void addCakeLayer(){
        cake.setCakeLayer(" Yogurt ");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
   
}
