package lab06.ex1;
import java.util.*;



public class Database {
    private Vector<Employee> employees; // Stores the employees
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
    // Code to add employee
        
        if (!employees.contains(employee)){
            employees.add(employee);
            return true;
        }
        return false;
        
        
    }

    public void deleteEmployee(long emp_num) {
    // Code to delete employee
        for (Employee emp : employees){
            if (emp.getEmpNum() == emp_num){
                employees.remove(emp);
            }
        }
    }

    public Employee[] getAllEmployees() {
    // Code to retrieve collection
        Employee [] ret_emp = new Employee [employees.size()];
        for (int i = 0; i< employees.size(); i++){
            ret_emp[i] = employees.get(i);
        }
        return ret_emp;
    }
}
