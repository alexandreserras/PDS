package lab07.ex1;


public class main1 {
    public static void main(String[] args) {
        Jobs j = new Employee("António");
        TeamLeader tl = new TeamLeader(new Employee("Ana"));
        TeamMember tm = new TeamMember(new Employee("João"));
        Manager m = new Manager(tl);

        Manager m1 = new Manager(new TeamLeader(new TeamMember(new Employee("Patrão"))));
        
        Jobs [] j1 = {j, tl, tm, m, m1}; 

        for (Jobs i: j1){
            i.work();
            if (i instanceof TeamLeader){
                ((TeamLeader) i).plan();
            }
            if (i instanceof TeamMember){
                ((TeamMember) i).colaborate();
            }
            if (i instanceof Manager){
                ((Manager) i).manage();
            }
        }
    }
}
