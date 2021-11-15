package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList<String> Arr1 = new ArrayList<String>();
        Arr1.add("5");
        Arr1.add("10");
        Arr1.add("15");
        Arr1.add("20");
        System.out.println(Arr1.get(2));
        Arr1.remove("10");
        System.out.println(Arr1.get(2));
    }
}
