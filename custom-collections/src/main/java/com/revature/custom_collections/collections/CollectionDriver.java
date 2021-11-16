package com.revature.custom_collections.collections;


public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(10);
        intList.add(11);
        intList.add(12);
        intList.add(13);
        intList.add(14);
        intList.printHead();
        System.out.println(intList.pollFirst());
        intList.printHead();
    }
}
