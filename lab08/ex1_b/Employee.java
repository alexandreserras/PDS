package ex1_b;

public class Employee {
    private double salary;

    
    private Person p;

    public Employee(Person p, double s) {
        this.p=p;
        this.salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public Person getPerson() {
        return this.p;
    }

   
}
