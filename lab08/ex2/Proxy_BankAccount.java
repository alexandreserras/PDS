package ex2;

public class Proxy_BankAccount implements BankAccount{
    private String bank;
    private double balance;
    private BankAccountImpl ba;


    public Proxy_BankAccount(String bank, double balance) {
        this.ba = new BankAccountImpl(bank, balance);
    }
   


   public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if (Company.user == User.OWNER){
            if (amount > balance )
                return false;
            balance -= amount;
                return true;
        }
        return false;
    }

    public double balance(){
        if (Company.user == User.OWNER){
            return balance;
        }
        else{
            System.out.println("Não pode aceder à conta do cliente!");
            return Double.NaN;
        }
    }
    
}
