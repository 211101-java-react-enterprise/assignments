package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList arr = new ArrayList();

        System.out.println(arr.isEmpty());

        System.out.println(arr.get(0));

        arr.add("1");
        System.out.println(arr.get(0));



        arr.add("2");
        System.out.println(arr.get(1));

        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");
        arr.add("10");

        System.out.println(arr.get(9));

        arr.add("11");

        System.out.println(arr.get(10));

        arr.add("12");
        arr.add("4");

        System.out.println(arr.get(12));

        System.out.println(arr);

        arr.displayArray();

        System.out.println(arr.contains("7"));
        System.out.println(arr.contains("20"));

        System.out.println(arr.isEmpty());

        System.out.println(arr.remove("3"));

        arr.displayArray();

        System.out.println(arr.get(5));

        arr.add(6, "42");

        arr.displayArray();

        arr.set(0, "Fish");

        arr.displayArray();

        arr.set(0, 3.2);

        arr.displayArray();

        arr.remove(6);

        arr.displayArray();

        System.out.println(arr.indexOf("4"));

        System.out.println(arr.lastIndexOf("4"));
    }
}
