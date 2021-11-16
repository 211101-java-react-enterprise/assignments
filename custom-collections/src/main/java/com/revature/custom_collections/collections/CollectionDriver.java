package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        //___________________HashMap Test_____________________
        HashMap<String , String> hashMap = new HashMap<>();

        System.out.println("isEmpty: true="+hashMap.isEmpty());
        System.out.println( hashMap.put("a","1"));
        System.out.println( hashMap.put("b","2"));
        System.out.println( hashMap.put("c","3"));
        System.out.println( hashMap.put("d","4"));
        System.out.println("size: 4=" +hashMap.size());

        System.out.println( hashMap.get("b"));
        System.out.println( hashMap.remove("b"));

        System.out.println( "contains a: true=" +hashMap.containsKey("a"));
        System.out.println( "contains b: false="+hashMap.containsKey("b"));
        System.out.println( "contains y: false="+hashMap.containsKey("y"));
        System.out.println( "contains z: false="+hashMap.containsKey("z"));

        System.out.println( "contains value 2: false="+hashMap.containsValue("2"));
        System.out.println("contains value 3: true="+hashMap.containsValue("3"));
        System.out.println( "contains value 7: false= "+hashMap.containsValue("7"));
        System.out.println( "contains value 9 false="+hashMap.containsValue("9"));


        System.out.println( hashMap.put("b","2"));

        System.out.println( hashMap.put(null,"4"));
        System.out.println( hashMap.put(null,null));

        System.out.println( hashMap.get("a"));
        System.out.println( hashMap.get(null));

        System.out.println("end");

        //_________________Has Set Test____________________________
        Set<String> set=new HashSet<>();
        set.add("Hello_World");
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Hello_World"));
    }
}
