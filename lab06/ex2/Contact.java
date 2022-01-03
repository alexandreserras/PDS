package lab06.ex2;

public class Contact {
    private String name;
    private int number;


    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return
            getName() + "\t" + getNumber() + "\n";
    }
    
    
}
