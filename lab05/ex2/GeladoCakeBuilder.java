package ex2;
public class GeladoCakeBuilder extends CakeBuilderAbs {
    public  void addCreamLayer(){
        cake.setMidLayerCream(Cream.LARANJA);
    }
    public  void addTopLayer(){
        cake.setTopLayerCream(Cream.RED_BERRIES);
    }
    public  void addTopping(){
        cake.setTopping(Topping.LEITE_COCO);
    }
    public  void addCakeLayer(){
        cake.setCakeLayer(" Icecream ");
        cake.setNumCakeLayers(1+cake.getNumCakeLayers());
    }
}
