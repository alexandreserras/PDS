package lab07.ex1;

public class TeamMember extends Emp_decorator{
    TeamMember( Jobs j)  {super(j);}
    
    @Override
    public void work(){
        j.work();
        System.out.println("[TEAMMEMBER] trabalha.");
    }

    public void colaborate() {
        System.out.println("[TEAMMEMBER] colabora.");
    }
}
