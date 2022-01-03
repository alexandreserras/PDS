package ex2;

public class Card {
    private String name;
    private int ID;
    private static int counter=1;
    
    Card(String n) {
        this.name=n;
        this.ID = counter;
        counter++;
    }

    public String toString(){
        return "Name: " +this.name + " ID: " + this.ID;
    }


}
