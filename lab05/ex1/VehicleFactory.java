package ex1;

public class VehicleFactory {
    private int passageiros;
    private int [] carga;
    private boolean chairWheels;

    public static Vehicle getVehicle(int passageiros, int carga [], boolean chairWheels){
        int cargaTotal=0;
        for (int i: carga){
            cargaTotal+=i;
        }
        if (cargaTotal==0 && passageiros==1 && !chairWheels){
            System.out.println("Vehicle for " +passageiros+" passengers: use a Scooter");
            return new Scooter();
        }
        else if (passageiros==1 && cargaTotal<=250 && !chairWheels){
            System.out.println("Vehicle for " +passageiros+" passengers with "+ carga.length+" items of luggage : use a Micro");
            return new Micro();
        }
        else if(passageiros <= 3 && cargaTotal <=250 && !chairWheels){
            System.out.println("Vehicle for " +passageiros+" passengers with "+ carga.length+" items of luggage : use a City");
            return new City();
        }
        else if (passageiros<=4 && cargaTotal <=600 && ! chairWheels) {
            System.out.println("Vehicle for " +passageiros+" passengers with "+ carga.length+" items of luggage : use a Family");
            return new Family();
        }
        else if (passageiros<=4 && cargaTotal <=1000) {
            if (chairWheels && cargaTotal>0)  
                System.out.println("Vehicle for " +passageiros+" passengers with "+ carga.length+ " items of luggage and wheelchair: use a Van");
            else if (chairWheels)
                System.out.println("Vehicle for " +passageiros+" passengers and wheelchair: use a Van");
            else
                System.out.println("Vehicle for " +passageiros+" passengers with "+ carga.length+" items of luggage : use a Van");
            
            return new Van();
        }
        else{
            System.out.println("[ERROR]: Invalid parameters");
            return null;
        }

    }

    public static Vehicle getVehicle(int passageiros){
        return getVehicle(passageiros,new int[]{0},false);
    }

    public static Vehicle getVehicle(int passageiros, int [] carga){
        return getVehicle(passageiros, carga,false);
    }

    public static Vehicle getVehicle(int passageiros, boolean chairWheels){
        return getVehicle(passageiros, new int[]{0},chairWheels);
    }

}
