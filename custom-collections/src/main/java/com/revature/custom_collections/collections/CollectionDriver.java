package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        ArrayList myList = new ArrayList<String>();
        myList.add("Lakers");
        myList.add("Orange");
        myList.add("Banana");
        myList.add("Yellow");
        myList.add("Blue");
        myList.add("Orange");
        myList.add("Hair");
        myList.add("Wow");
        myList.remove("Blue");
        // System.out.println(myList.get(0));
        // myList.indexOf("Banana");
        int index = myList.indexOf("Orange");
        System.out.println(myList.get(index));
        myList.remove(index);
        System.out.println(myList.get(index));
        //System.out.println(myList.remove("Blue"));
        System.out.println(myList.remove(20));
    }
}
