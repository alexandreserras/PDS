package lab07.ex1;

public class Employee implements Jobs{
    private String name;
    Employee(String n){this.name = n;}

    public void start(Date aDate){
        System.out.println("Começou");
    }

    public void terminate(Date aDate){
        System.out.println("Terminou");
    }

    public void work(){
        System.out.println(this.name +" trabalha.");
    }   

}