package lab07.ex1;

public class TeamLeader extends Emp_decorator{
    
    TeamLeader( Jobs j)  {super(j);}

    @Override
    public void work(){
        j.work();
        System.out.println("[TEAMLEADER] trabalha.");
    }

    public void plan(){
        System.out.println("[TEAMLEADER] planeia.");
    }
}
