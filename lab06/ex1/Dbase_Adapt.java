package lab06.ex1;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class Dbase_Adapt extends Registos{

    private Database d1;


    public Dbase_Adapt(Database d1) {
        super();
        this.d1 = d1;
    }
    

    public void insere(Employee e1){
        d1.addEmployee(e1);
    }

    public void remove(long emp_num){
        d1.deleteEmployee(emp_num);
    }

    public boolean isEmpregado(long codigo){
        for (Employee emp : d1.getAllEmployees()){
            if (emp.getEmpNum() == codigo){
                return true;
            }
        }
        return false;
    }

    public void printEmpregados() {
        for (Employee e1 : d1.getAllEmployees()){
            System.out.print(" Name: "+e1.getName()+ ", Number: " + e1.getEmpNum() + ", Salary: " + e1.getSalary());
        }
        System.out.println("");
    }

}