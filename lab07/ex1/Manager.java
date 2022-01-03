package lab07.ex1;

public class Manager extends Emp_decorator{
    Manager( Jobs j)  {super(j);}

    @Override
    public void work(){
        j.work();
        System.out.println("[Manager] trabalha.");
    }

    public void manage(){
        System.out.println("[Manager] manage.");
    }
}

