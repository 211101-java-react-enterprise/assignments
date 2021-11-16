package com.revature.custom_collections.collections;


import java.sql.SQLOutput;

public class CollectionDriver {

    public static void main(String[] args) {
        /*
         *  ArrayList<T> Demo
         *
         *  Arrays are fixed in length at creation and cannot be changed.
         *  Benefit of ArrayList is that it's length is flexible.
         *  Meaning you can change the length (or in this case "size") of the arrayList.
         *
         */

        //Instantiate arrayList to type String for this demo.
        ArrayList<String> arrayList = new ArrayList<>();

        /*
         * Overloaded Add
         *
         * Appends the specified element to the end of this list.
         * Adds the specified element at a specified index and shift remaining elements to the right one.
         */
        System.out.println("isEmpty demo");
        System.out.println("______________________________________________");
        System.out.println(arrayList.toStringTrim());
        System.out.println("is array list empty = " + arrayList.isEmpty());

        arrayList.add("A");
        System.out.println(arrayList.toStringTrim());
        System.out.println("is array list empty = " + arrayList.isEmpty());
        System.out.println("______________________________________________");

        System.out.println("add(T element) demo");
        System.out.println("______________________________________________");
        System.out.println(arrayList.toStringTrim());
        arrayList.add("B");
        System.out.println(arrayList.toStringTrim());
        System.out.println("______________________________________________");

        System.out.println("add(int index, T element) demo");
        System.out.println("______________________________________________");
        arrayList.add(0, "X");
        System.out.println(arrayList.toStringTrim());
        arrayList.add(0, "Y");
        System.out.println(arrayList.toStringTrim());

        try {
            arrayList.add(-1, "X");
            System.out.println(arrayList.toStringTrim());
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            arrayList.add(5, "X");
            System.out.println(arrayList.toStringTrim());
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("______________________________________________");

        System.out.println("contains(T element) demo");
        System.out.println("______________________________________________");
        System.out.println("contains A = " + arrayList.contains("A"));
        System.out.println("contains D = " + arrayList.contains("D"));
        System.out.println("______________________________________________");

        System.out.println("set(int index, T element) demo");
        System.out.println("______________________________________________");
        System.out.println(arrayList.toStringTrim());
        System.out.println("set index 0 to S, Element removed was = " + arrayList.set(0, "S"));
        System.out.println(arrayList.toStringTrim());
        System.out.println("______________________________________________");

        System.out.println("get(int index) demo");
        System.out.println("______________________________________________");
        System.out.println(arrayList.toStringTrim());
        System.out.println("index at 0 = " + arrayList.get(0));

        try{
            System.out.println("index at -1 = " + arrayList.get(-1));
            System.out.println(arrayList.toStringTrim());
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try{
            System.out.println("index at 5 = " + arrayList.get(5));
            System.out.println(arrayList.toStringTrim());
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("______________________________________________");

        System.out.println("remove(int index) demo");
        System.out.println("______________________________________________");
        System.out.println(arrayList.remove();
        System.out.println(arrayList.toString());
        System.out.println(arrayList.remove("W"));
        System.out.println(arrayList.toString());
        System.out.println("______________________________________________");


        System.out.println("remove(T element) demo");
        System.out.println("______________________________________________");
        System.out.println(arrayList.remove("S"));
        System.out.println(arrayList.toString());
        System.out.println(arrayList.remove("W"));
        System.out.println(arrayList.toString());
        System.out.println("______________________________________________");


    }
}
