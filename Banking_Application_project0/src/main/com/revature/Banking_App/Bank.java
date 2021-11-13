package main.com.revature.Banking_App;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Bank {

    public Bank() {
        System.out.println("Welcome to The Bank of World");
        boolean isOn = true;
        while(isOn){

            System.out.println("What would you like to do? \n" +
                                "1) Deposit\n" +
                                "2) Withdraw\n" +
                                "3) Check balance\n"+
                                "4) Exit");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             try {
                //Scanner scan = new Scanner(System.in);
                String choice = consoleReader.readLine();

                switch (choice) {
                    case "1":
                        deposit(consoleReader);
                        break;
                    case "2":
                        withdraw(consoleReader);
                        break;
                    case "3":
                        check_balance(consoleReader);
                        break;
                    case "4":
                        System.out.println("Thank you for the visit. We appreciate your business!");
                        isOn = false;
                        break;
                    default:
                        System.out.println("Wrong selection. Please pick a number from the Menu");
                }

            } catch (Exception ioe) {
                ioe.printStackTrace();
        }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static double amount = 0;
    public static void deposit(BufferedReader consoleReader) {
        System.out.println("How much money would you like to deposit?");
        double depo = scanner.nextInt();
        amount+=depo;
        System.out.println("Your amount is: "+amount);
    }

    public static void withdraw(BufferedReader consoleReader) {
        System.out.println("How much money would you like to withdraw from your account?");
        double withdrawal =scanner.nextInt();
        if(amount >= withdrawal){
            amount-=withdrawal;
            System.out.println("Your total amount is: "+amount);
        }else if(amount<withdrawal){
            System.out.println("Insufficient funds");
        }

    }

    public static void check_balance(BufferedReader consoleReader) {
        System.out.println("Your balance on the account is: " +amount);
    }

}
