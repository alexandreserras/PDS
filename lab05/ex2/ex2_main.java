package ex2;
public class ex2_main {
    public static void main(String[]main){
        CakeMaster cakeMaster = new CakeMaster();
        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        // 1 cake layer
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.SQUARE, 2, "Well done");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake); // squared, 2 layers
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilder gelado = new GeladoCakeBuilder();
        cakeMaster.setCakeBuilder(gelado);
        cakeMaster.createCake(Shape.RECTANGLE,4, " Está frio");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
    }
 
}
