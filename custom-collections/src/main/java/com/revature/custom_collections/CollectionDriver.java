package com.revature.custom_collections;

import com.revature.custom_collections.collections.ArrayList;

public class CollectionDriver {

    public static void main(String[] args) {
        ArrayList<String> myArrayList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            myArrayList.add("test-value-" + i);
        }
        System.out.println(myArrayList);
        myArrayList.remove("test-value-10");
        System.out.println(myArrayList);
        myArrayList.remove("test-value-0");
        System.out.println(myArrayList);
        myArrayList.remove("test-value-5");
        System.out.println(myArrayList);
        System.out.println("myArrayList.contains(\"test-value-5\") :: " + myArrayList.contains("test-value-5"));
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(6));
        System.out.println(myArrayList.get(7));
        System.out.println(myArrayList.size());
        myArrayList.add(5, "test-add-at-index");
        System.out.println(myArrayList.get(5));
        System.out.println(myArrayList);
        myArrayList.add("test-value-2");
        myArrayList.add("test-value-3");
        System.out.println(myArrayList);
        System.out.println(myArrayList.indexOf("test-value-2"));
        System.out.println(myArrayList.lastIndexOf("test-value-2"));
        myArrayList.remove(9);
        System.out.println(myArrayList.get(9));
        System.out.println(myArrayList);
    }
}
