package com.revature.custom_collections.collections;


public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(11);
        intList.add(12);
        intList.add(13);
        intList.add(14);
        intList.add(15);
        intList.add(16);
        System.out.println(intList.get(0));
        System.out.println(intList.get(6));
        intList.add(17);
        intList.add(18);
        intList.add(19);
        System.out.println(intList);
        intList.add(20);
        System.out.println(intList);
        System.out.println(intList.get(9));
        System.out.println(intList.get(10));
    }
}
