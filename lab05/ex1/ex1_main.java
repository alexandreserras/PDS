package ex1;
public class ex1_main {
    public static void main(String[] args) {
        int [] luggage;
        Vehicle v;

        v = VehicleFactory.getVehicle(1);

        // Get vehicle for 1 passenger with two items of luggage
        luggage = new int[]{100, 140}; // two bags with a total volume of 240
        v = VehicleFactory.getVehicle(1, luggage);
        // Get vehicle for 3 passengers with two items of luggage
        luggage = new int[]{50, 200, 240}; // three bags with a total volume of 490
        v = VehicleFactory.getVehicle(3, luggage);
        // Get vehicle for 2 passengers and wheelchair
        v = VehicleFactory.getVehicle(2, true);
        // you should add other examples here
        luggage = new int[]{50, 200};
        v= VehicleFactory.getVehicle(2,luggage);

        luggage = new int[]{50, 200,500};
        v= VehicleFactory.getVehicle(4,luggage,false);

        luggage = new int[]{50, 200,500};
        v= VehicleFactory.getVehicle(4,luggage,true);


        luggage = new int[]{50, 200,500,200};
        v= VehicleFactory.getVehicle(1,luggage);




    }
    
}
