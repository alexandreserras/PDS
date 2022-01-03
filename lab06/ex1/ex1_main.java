package lab06.ex1;
import java.util.List;


public class ex1_main { //
        
    public static void main(String[] args) {
        Employee e1 = new Employee("José", 000001, 1750);
        Employee e2 = new Employee("Maria", 123456, 2000);

        Database d1 = new Database();
        
        d1.addEmployee(e1);
        d1.addEmployee(e2);

        Employee array[] = d1.getAllEmployees();

        System.out.print("Before delete: ");
        for (Employee emp : array){
            System.out.print(" Name: "+emp.getName()+ ", Number: " + emp.getEmpNum() + ", Salary: " + emp.getSalary());
        }
        System.out.println("");

        d1.deleteEmployee(e1.getEmpNum());

        array = d1.getAllEmployees();

        System.out.print("After delete: ");
        for (Employee emp : array){
            System.out.print(" Name: "+emp.getName()+ ", Number: " + emp.getEmpNum() + ", Salary: " + emp.getSalary());
        }
        System.out.println("");


        /*------------------------------------------------------------------------------------------*/ 


        Empregado emp1 = new Empregado("Helena", "Alves", 12543, 3000);
        Empregado emp2 = new Empregado("Francisco", "Aveiro", 81236, 2500);
        
        Registos r1  = new Registos();

        r1.insere(emp1);
        r1.insere(emp2);

        List <Empregado> lista = r1.listaDeEmpregados();

        System.out.print("Before delete: ");
        for (Empregado emp : lista){
            System.out.print(" Name: " + emp.nome() + ", Surname " + emp.apelido() + ", code: " + emp.codigo() + ", Salary: " + emp.salario());
        }
        System.out.println("");


        if (r1.isEmpregado(emp1.codigo())){
            r1.remove(emp1.codigo());
        }
        System.out.println("After delete: ");


        lista = r1.listaDeEmpregados();

        for (Empregado emp : lista){
            System.out.print("Name: " + emp.nome() + ", Surname " + emp.apelido() + ", code: " + emp.codigo() + ", Salary: " + emp.salario());
        }
        System.out.println("");
    }
    
        


}
