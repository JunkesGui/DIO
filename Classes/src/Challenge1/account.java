package Challenge1;

public class account {
    private double balance;
    private final String owner;
    private double overdraftValue;
    private boolean overdraftActive;

    public account(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
        setOverdraftValue();
    }

    void consultOwner(){System.out.println("Account owner: " + getOwner());}

    void consultBalance(){
        System.out.println("Current balance: $" + getBalance());
    }

    void consultOverdraftValue(){System.out.println("Current overdraft protection value: $" + getOverdraftValue());}

    void deposit(double amount){
        balance = balance + amount;
        System.out.println("Successfully deposited $" + amount);
        consultBalance();
    }

    void withdraw(double amount){
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Successfully withdrawn $" + amount);
            consultBalance();
        }else{
            System.out.println("Insufficient balance to withdraw.");
        }
    }

    void payBill(double amount){
        balance = balance - amount;
        System.out.println("Successfully payed the $" + amount + "Bill.");
        consultBalance();
    }

    void consultOverdraftUse(){
        if (overdraftActive){
            System.out.println("This account is using an overdraft protection.");
        } else {
            System.out.println("This account is not using an overdraft protection.");
        }
    }

    void useOverdraft(){
        balance = balance + overdraftValue;
        overdraftActive = true;
        System.out.println("Your $" + overdraftValue + " overdraft protection has been activated.");
        balance = balance - (overdraftValue *0.2);
        System.out.println("A 20% fee ($"+ overdraftValue *0.2+") was issued from your balance.");
        consultBalance();
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
