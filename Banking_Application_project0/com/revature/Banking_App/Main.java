package com.revature.Banking_App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Easier App. Place, where your college life gets easier. " +
                            "We are her to help you. Whenever, Wherever.");
        String choice1 = "1) Register for classes or check registration status";
        String choice2 = "2) Get loans or pay outstanding balance";


        System.out.println("Please Choose one of the options:\n" + choice1 + "\n" + choice2);

        Scanner scan = new Scanner(System.in);
        boolean decision = scan.hasNext();
        if (scan.hasNext("1")) {
            System.out.println("You picked " + choice1);
            ClassRegistration registration = new ClassRegistration();
        }else if (scan.hasNext("2")) {
            System.out.println("You picked " + choice2);
            Bank bank = new Bank();
        }

    }

}
