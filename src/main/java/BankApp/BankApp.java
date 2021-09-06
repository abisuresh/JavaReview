package BankApp;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount("Test", "1234");
        bankAccount.showMenu();
    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String custName, String custId){
        customerName = custName;
        customerId = custId;
    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("The following amount has been deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("The following amount was withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transactioni occurred.");
        }
    }

    void showMenu() {
        char option = '\0';
        char lowerCaseOption = '\0';
        Scanner scanner = new Scanner(System.in);

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your customer id is: " + customerId);
        System.out.println("A. Check Account Balance. ");
        System.out.println("B. Deposit ");
        System.out.println("C. Withdraw ");
        System.out.println("D. See Previous Transaction. ");
        System.out.println("E. Exit menu ");


        do {
            System.out.println("Select an option by entering a character from A - E.");
            option = inputScanner.next().charAt(0);
            lowerCaseOption = Character.toLowerCase(option);
            switch (lowerCaseOption) {
                case 'a':
                    // account balance
                    System.out.println("Your balance is: " + balance);
                    break;
                case 'b':
                    // deposit amount
                    System.out.println("Please input an amount to deposit. ");
                    int amount = inputScanner.nextInt();
                    deposit(amount);
                    System.out.println('\n');
                    break;
                case 'c':
                    // withdraw amount
                    System.out.println("Please input an amount to withdraw. ");
                    int withdrawAmount = inputScanner.nextInt();
                    withdraw(withdrawAmount);
                    break;
                case 'd':
                    // see prior transaction if it exists
                    getPreviousTransaction();
                    break;
                case 'e':
                    System.out.println("You have chosen to exit. ");
                    break;
                default:
                    System.out.println("Invalid selection. Please enter a character from A- E. ");
                    break;
            }

        }while(lowerCaseOption != 'e');

        System.out.println("Thank you. Please visit again. ");

    }
}

