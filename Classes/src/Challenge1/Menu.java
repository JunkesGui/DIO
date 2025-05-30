package Challenge1;

import java.util.Scanner;

public class Menu {
    byte selection = 0;
    boolean isRegistered = false;
    account account;
    Scanner sc = new Scanner(System.in);

    void run() {
        while (selection != 4) {
            System.out.println("=====Welcome to the bank application=====");
            System.out.println("Select an option:");
            System.out.println("1. Create an account");
            System.out.println("2. Consult info");
            System.out.println("3. Transactions");
            System.out.println("4. Exit");
            moveSelection();

            switch (selection) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (!isRegistered) {System.out.println("You still dont have an account to consult.");
                    }else {
                        consultInfo();
                    }
                    break;
                case 3:
                    if (!isRegistered) {System.out.println("You still dont have an account to make transactions.");
                    }else {
                        transactionsMenu();
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

    private void moveSelection() {
        selection = sc.nextByte();
        sc.nextLine();
    }

    private void createAccount() {
        System.out.println("=====You selected Create an account=====");
        System.out.println("Insert the account holder name: ");
        String owner = sc.nextLine();
        System.out.println("Insert the amount to deposit: ");
        double firstDeposit = sc.nextDouble();
        this.account = new account(firstDeposit, owner);
        isRegistered = true;
    }

    private void consultInfo() {
        System.out.println("=====Consulting your account info=====");
        System.out.println("1. Consult owner");
        System.out.println("2. Consult balance");
        System.out.println("3. Consult overdraft status");
        System.out.println("4. Exit");
        moveSelection();
        switch (selection){
            case 1:
                account.consultOwner();
                break;
            case 2:
                account.consultBalance();
                break;
            case 3:
                account.consultOverdraftUse();
                if (!account.isOverdraftActive()){
                    account.consultOverdraftValue();
                }
                break;
            case 4:
                selection = 0;
                break;
        }
    }

    private void transactionsMenu(){
        System.out.println("=====Transactions Menu=====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Pay Bill");
        System.out.println("4. Activate Overdraft Protection");
        System.out.println("5. Exit");
        moveSelection();
        switch (selection){
            case 1:
                System.out.println("How much do you want to deposit?");
                double deposit = sc.nextDouble();
                account.deposit(deposit);
                break;
            case 2:
                System.out.println("How much do you want to withdraw?");
                double withdraw = sc.nextDouble();
                account.withdraw(withdraw);
                break;
            case 3:
                System.out.println("What is the bill value?");
                double billValue = sc.nextDouble();
                account.payBill(billValue);
                break;
            case 4:
                selection = 0;
                account.useOverdraft();
                break;
            case 5:
                selection = 0;
                break;
            }
        }
    }





