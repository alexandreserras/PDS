package ex1;

public class Van implements Vehicle{
    
    private int passageiros, volume;
    private boolean chairWheels;
    
    public int getMaxVolume(){return 1000;}
    public int getMaxPassangers(){return 4;}
    


    protected Van() {
    }

}
