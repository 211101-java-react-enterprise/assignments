package com.revature.custom_collections.collections;

import java.sql.SQLOutput;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.
        LinkedList<String> example = new LinkedList<String>();
        example.add("one");
        example.add("two");
        example.add("three");
        example.add("four");
        example.add("four");
        example.add("five");

        System.out.println(example);

        System.out.println("Is one there? " + example.contains("one"));
        System.out.println("Are we empty?" + example.isEmpty());

        example.remove("two");
        System.out.println("Let's remove 2: " + example);

        System.out.println("How big are we now? " + example.size());
        System.out.println("What's in position 1 now?" + example.get(1));

        example.add(1,"two");
        System.out.println("Let's get 2 back in there...  " + example);

        example.set(2, "3");
        System.out.println("Actually, let's replace three... " + example);

        example.remove(2);
        System.out.println("Actually, that's dumb, get rid of it... " + example);

        System.out.println("Wait... where was four again?" + example.indexOf("four"));

        System.out.println("It was somewhere else too wasn't it? " + example.lastIndexOf("five"));

        System.out.println("Don't arrays start at zero?");
        example.addFirst("zer0");
        System.out.println(example);

        example.addLast("six");
        System.out.println("And let's add another number at the end... " + example);

        System.out.println("Let's get rid of the first value actually... I think it was" + example.pollFirst());
        System.out.println("Yeah, there we go... " + example);

        System.out.println("Lets get rid of " + example.pollLast() +" while we're at it.");
        System.out.println(example);

        System.out.println("And we've got " + example.peekFirst() + " in the front as well as " + example.peekLast() + " in the back");





    }
}
