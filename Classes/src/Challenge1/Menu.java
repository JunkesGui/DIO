package Challenge1;

import java.util.Scanner;

public class Menu {
    byte selection = 0;
    boolean isRegistered = false;
    Account account;
    Scanner sc = new Scanner(System.in);

    void Start() {
        while (selection != 4) {
            System.out.println("=====Welcome to the bank application=====");
            System.out.println("Select an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Consult info");
            System.out.println("3. Transactions");
            System.out.println("4. Exit");
            MoveSelection();

            switch (selection) {
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    if (!isRegistered) {System.out.println("You still dont have an account to consult.");
                    }else {
                        ConsultInfo();
                    }
                    break;
                case 3:
                    if (!isRegistered) {System.out.println("You still dont have an account to make transactions.");
                    }else {
                        TransactionsMenu();
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
                    break;
            }
        }
    }

    private void MoveSelection() {
        selection = sc.nextByte();
        sc.nextLine();
    }

    private void CreateAccount() {
        System.out.println("=====You selected Create an account=====");
        System.out.println("Insert the account holder name: ");
        String owner = sc.nextLine();
        System.out.println("Insert the amount to deposit: ");
        double firstDeposit = sc.nextDouble();
        this.account = new Account(firstDeposit, owner);
        isRegistered = true;
    }

    private void ConsultInfo() {
        System.out.println("=====Consulting your account info=====");
        System.out.println("1. Consult owner");
        System.out.println("2. Consult balance");
        System.out.println("3. Consult overdraft status");
        System.out.println("4. Exit");
        MoveSelection();
        switch (selection){
            case 1:
                account.ConsultOwner();
                break;
            case 2:
                account.ConsultBalance();
                break;
            case 3:
                account.ConsultOverdraftUse();
                if (!account.isOverdraftActive()){
                    account.ConsultOverdraftValue();
                }
                break;
            case 4:
                selection = 0;
                break;
        }
    }

    private void TransactionsMenu(){
        System.out.println("=====Transactions Menu=====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Pay Bill");
        System.out.println("4. Activate Overdraft Protection");
        System.out.println("5. Exit");
        MoveSelection();
        switch (selection){
            case 1:
                System.out.println("How much do you want to deposit?");
                double deposit = sc.nextDouble();
                account.Deposit(deposit);
                break;
            case 2:
                System.out.println("How much do you want to withdraw?");
                double withdraw = sc.nextDouble();
                account.Withdraw(withdraw);
                break;
            case 3:
                System.out.println("What is the bill value?");
                double billValue = sc.nextDouble();
                account.PayBill(billValue);
                break;
            case 4:
                selection = 0;
                account.UseOverdraft();
                break;
            case 5:
                selection = 0;
                break;
        }
    }
    }





