package lab10.ex2;

public class NullEmployee extends Employee{


    public NullEmployee() {
        this.name=null;
    }
    
    
    @Override
    public String getName() {
        return name;
    }
    
    
}
