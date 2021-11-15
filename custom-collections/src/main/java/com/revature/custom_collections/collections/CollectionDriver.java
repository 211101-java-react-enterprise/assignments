package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList arr = new ArrayList();

        System.out.println("Is the array empty: " + arr.isEmpty());

        System.out.println("\nFirst element of the array: " + arr.get(0));

        arr.add("1");

        System.out.println("\nIs the array empty: " + arr.isEmpty());

        System.out.println("\nFirst element of the array: " + arr.get(0));

        for(int i = 2; i <= 10; i++){
            arr.add(String.valueOf(i));
        }
        arr.displayArray();

        arr.add("11");

        arr.displayArray();

        System.out.println("Does the ArrayList contain 5: " + arr.contains("5"));

        System.out.println("Does the ArrayList contain 20: " + arr.contains("20"));

        arr.remove("3");

        arr.displayArray();

        arr.add(2, "3");

        arr.displayArray();


    }
}
