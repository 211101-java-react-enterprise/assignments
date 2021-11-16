package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("Hello_World");
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Hello_World"));
    }
}
