package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.

        HashMap<Integer,String> map = new HashMap<Integer, String>();
        System.out.println("is empty " + map.isEmpty());

        System.out.println("+-----------------------------+");
        System.out.println(map.put(2,"two"));
        System.out.println(map.put(2,"one"));
        System.out.println(map.put(2,"three"));
//        System.out.println("size of two puts is " + map.size());
        System.out.println(map.put(4,"four"));
        System.out.println(map.put(5,"five"));
        System.out.println(map.put(6,"six"));
        System.out.println(map.put(4,"100"));
        map.put(7,"123");
        map.put(8,"1234");
        map.put(9,"12345");
        map.put(10,"123456");
        map.put(11,"1234567");
        map.put(12,"12345678");
        map.put(13,"123");
        map.put(14,"1234");
        map.put(15,"12345");
        map.put(16,"123456");
        map.put(17,"1234567");
        map.put(18,"12345678");
        map.put(19,"1234");
        map.put(20,"123");
        System.out.println(map.size());



    }
}
