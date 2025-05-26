package Challenge1;

public class Account {
    private double balance;
    private final String owner;
    private double overdraftValue;
    private boolean overdraftActive;

    public Account(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
        setOverdraftValue();
    }

    void ConsultOwner(){System.out.println("Account owner: " + getOwner());}

    void ConsultBalance(){
        System.out.println("Current balance: $" + getBalance());
    }

    void ConsultOverdraftValue(){System.out.println("Current overdraft protection value: $" + getOverdraftValue());}

    void Deposit(double amount){
        balance = balance + amount;
        System.out.println("Successfully deposited $" + amount);
        ConsultBalance();
    }

    void Withdraw(double amount){
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Successfully withdrawn $" + amount);
            ConsultBalance();
        }else{
            System.out.println("Insufficient balance to withdraw.");
        }
    }

    void PayBill(double amount){
        balance = balance - amount;
        System.out.println("Successfully payed the $" + amount + "Bill.");
        ConsultBalance();
    }

    void ConsultOverdraftUse(){
        if (overdraftActive){
            System.out.println("This account is using an overdraft protection.");
        } else {
            System.out.println("This account is not using an overdraft protection.");
        }
    }

    void UseOverdraft(){
        balance = balance + overdraftValue;
        overdraftActive = true;
        System.out.println("Your $" + overdraftValue + " overdraft protection has been activated.");
        balance = balance - (overdraftValue *0.2);
        System.out.println("A 20% fee ($"+ overdraftValue *0.2+") was issued from your balance.");
        ConsultBalance();
    }

    private double getBalance() {
        return balance;
    }

    private String getOwner() {
        return owner;
    }

    private double getOverdraftValue() {
        return overdraftValue;
    }

    private void setOverdraftValue() {
        if (balance <= 500){
            this.overdraftValue = 50;
        } else if (balance > 500) {
            this.overdraftValue = balance*0.5;
        }
    }

    boolean isOverdraftActive() {
        return overdraftActive;
    }
}
