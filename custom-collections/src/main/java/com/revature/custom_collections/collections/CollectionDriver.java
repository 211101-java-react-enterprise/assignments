package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add("5");
        arr1.add("10");
        arr1.add("15");
        arr1.add("20");
        System.out.println(arr1.get(2));

        arr1.remove("10");
        System.out.println(arr1.get(2));

        System.out.println(arr1.size());

        arr1.add("25");
        System.out.println(arr1.size());

        arr1.remove(2);
        System.out.println(arr1.size());
        System.out.println(arr1.get(2));

        System.out.println(arr1.contains("10"));
        System.out.println(arr1.contains("25"));



    }
}
