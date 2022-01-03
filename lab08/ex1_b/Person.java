package ex1_b;

public class Person {
    private String name;
    private BankAccount bankAccount;
    
    public Person(String n) {
        name = n;
        bankAccount = new Proxy_BankAccount("PeDeMeia", 0);
    }
    
    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
    
    
    
}
