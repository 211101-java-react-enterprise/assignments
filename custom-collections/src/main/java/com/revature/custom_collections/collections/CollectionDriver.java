package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.

        HashMap<Integer,String> map = new HashMap<Integer, String>();
        System.out.println("is empty: " + map.isEmpty());

        System.out.println("+-----------------------------+");
        System.out.println(map.put(2,"first two"));
        System.out.println("Is empty: " + map.isEmpty());
        System.out.println(map.put(2,"second two"));
        System.out.println(map.put(2,"third two"));
//        System.out.println("size of two puts is " + map.size());
        System.out.println(map.put(4,"four"));
        System.out.println("Does contain key: " + map.containsKey(5));
        map.put(5,"five");
        System.out.println("Does contain key: " + map.containsKey(5));
        map.put(6,"six");
        map.put(7,"123");
        System.out.println("Does contain value: " + map.containsValue("1234"));
        map.put(8,"1234");
        System.out.println("Does contain value: " + map.containsValue("1234"));
        map.put(9,"12345");
        map.put(10,"123456");
        map.put(11,"1234567");
        map.put(12,"12345678");
        map.put(13,"123");
        map.put(null,null);
        map.put(14,"1234");
        map.put(15,"12345");
        map.put(16,"123456");
        map.put(17,"1234567");
        map.put(18,"12345678");
        map.put(19,"1234");
        map.put(1000,"123");
        System.out.println("Before removal: " + map.size());
        System.out.println(map.remove(8));
        System.out.println("After removal: " + map.size());
        System.out.println(map.get(1000));




    }
}
