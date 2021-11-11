package com.revature.Banking_App;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClassRegistration {

    public ClassRegistration(){
        System.out.println("Thank you for choosing class registration."
                            +"\nPlease pick a class you would like to join!");
        System.out.println("Categories:" +
                "\n1)Mathematics"+
                "\n2)English"+
                "\n3)Introduction to Programming");
        String[] strArr = new String[]{"Mathematics", "English", "Introduction to Programming"};

        for(String s : strArr){
            if (s.equals("Mathematics")){
                System.out.println("You are now registered for the upcoming mathematics course in room 101");
            }else if(s.equals("English")){
                System.out.println("You are now registered for the upcoming English course in room 105");
            }else if(s.equals("Introduction to Programming")){
                System.out.println("You are now registered for the upcoming Programming course in room 100");
            }else{
                System.out.println("Sorry we do not offer the course next semester!");
            }
        }



    }
}
