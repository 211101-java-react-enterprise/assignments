package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap<>();

/*
        System.out.println("size is: " + map.size());
        System.out.println(map.put(1,"first value"));
        System.out.println("Is the map empty? " + map.isEmpty());
        System.out.println();
        System.out.println(map.put(2,"second value"));
        System.out.println(map.put(2,"new second value"));
        System.out.println();

        map.put(null,null);
        map.put(null,"123");

        System.out.println("size is: " + map.size());
        System.out.println("Removed: " + map.remove(2));
        System.out.println("Size after removal is: " + map.size());
        System.out.println();
        System.out.println("Does map contain key 1: " + map.containsKey(1));
        System.out.println("Does map contain key 100: " + map.containsKey(100));
        System.out.println("Does map contain value \"first value\": " + map.containsValue("first value"));
        System.out.println("Does map contain value \"nonexistent value\": " + map.containsValue("nonexistent"));
        System.out.println();
        System.out.println("Key 1 maps: " + map.get(1));
        System.out.println("value of removed: " + map.remove(1));
        System.out.println("value of removed: " + map.remove(3));
        System.out.println("Is the map empty? " + map.isEmpty());
//*/



        map.put(9,"12345");
        map.put(10,"123456");
        map.put(11,"1234567");
        map.put(12,"12345678");
        map.put(13,"123");
        map.put(null,null);
        map.put(14,"1234");
        map.put(15,"12345");
        map.put(25, null);
        map.put(333,null);
        map.put(16,"123456");
        map.put(777,null);
        map.put(17,"1234567");
        map.put(18,"12345678");
        map.put(19,"1234");
        map.put(1000,"123");
        map.put(25, null);
        map.put(123123,"111111");
        map.put(1234,"12345");
        System.out.println(map.size());



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
        map.remove(30);
        map.remove(31);
        map.put(25, null);
        map.put(333,null);
        map.remove(28);
        map.put(16,"123456");
        map.put(777,null);
        map.put(17,"1234567");
        map.put(18,"12345678");
        System.out.println(map.remove(777));
        System.out.println(map.remove(333));
        map.put(19,"1234");
        map.put(1000,"123");
        map.remove(25);

        map.put(26, null);


        System.out.println(map.remove(32)); //does not exist
        System.out.println("Before removal: " + map.size());
        System.out.println(map.remove(8));
        System.out.println("After removal: " + map.size());
        System.out.println(map.get(1000));


// */



    }
}
