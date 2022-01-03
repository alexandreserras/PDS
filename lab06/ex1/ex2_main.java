package lab06.ex1;

public class ex2_main {
    public static void main(String[] args) {
        Database d1 = new Database();
        Dbase_Adapt d = new Dbase_Adapt(d1);

        Employee e1 = new Employee("José", 000001, 1750);
        Employee e2 = new Employee("Maria", 123456, 2000);

        d.insere(e1);
        d.insere(e2);

        d.printEmpregados();

        if (d.isEmpregado(e1.getEmpNum())){
            d.remove(e1.getEmpNum());
        }
        d.printEmpregados();


    }
}
