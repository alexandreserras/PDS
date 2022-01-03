package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private  List<Card> cards = new ArrayList<>();
    private Park p= new Park();
    private SocialSecurity ss = new SocialSecurity();
    private Insurance i = new Insurance();
    
    

    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getPerson().getBankAccount();
            ba.deposit(e.getSalary());
        }
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }

    public void admitEmployee(Person person, int i) {
        Employee e = new Employee(person, i);
        emps.add(e);
        this.createCard(e.getPerson().getName());
        this.i.regist(person);
        this.ss.regist(person);
        if (e.getSalary() > getAverageSalary()){
            System.out.println(e.getPerson().getName()+ " has acess to the park");
            p.allow(person);
        }
    }



    public void createCard(String name){

        cards.add(new Card(name));
    }

    public double getAverageSalary(){
        double sal=0;
        for(Employee e : emps){
            sal+=e.getSalary();
        }
        sal=sal/emps.size();
        return sal;
    }

}
