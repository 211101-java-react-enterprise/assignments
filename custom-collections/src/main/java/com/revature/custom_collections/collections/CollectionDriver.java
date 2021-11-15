package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList<String> arr1 = new ArrayList<String>();

        System.out.println(arr1.isEmpty());

        arr1.add("5");
        System.out.println(arr1.isEmpty());

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

        arr1.add(0, "abc");
        System.out.println(arr1.get(0));

        System.out.println(arr1.get(2));

        System.out.println(arr1.set(3, "DEF"));
        System.out.println(arr1.get(3));

        arr1.add("abc");
        System.out.println(arr1.indexOf("abc"));
        System.out.println(arr1.lastIndexOf("abc"));

        for (int i = 0; i < 30; i++) {
            arr1.add("filler");
        }

        System.out.println(arr1.size());




    }
}
