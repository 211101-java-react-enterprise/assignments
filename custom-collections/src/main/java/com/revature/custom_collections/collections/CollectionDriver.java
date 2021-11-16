package com.revature.custom_collections.collections;

public class CollectionDriver {

    public static void main(String[] args) {
        // TODO: Provide a demonstration of your implemented data structures here.

        LinkedList<String> testList = new LinkedList<String>();
        testList.add("VZ");

        testList.add(0, "value 0");
        testList.add(1, "value 1");
        testList.add(2, "value 2");
        testList.add(3, "value 3");

        testList.set(0, "VC0" );
        testList.set(1, "VC1" );
        testList.set(2, "VC2" );
        testList.set(3, "VC3" );

        testList.remove( 3);
        testList.remove(1);
        testList.remove(0);
        testList.remove(0);

        testList.add(0, "VC0" );
        testList.add(1, "VC1" );
        testList.add(2, "VC2" );
        testList.add(3, "VC3" );
        testList.set(0, "V0" );
        testList.set(1, "V1" );
        testList.set(2, "V2" );
        testList.set(3, "V3" );

        int locationOfV2 = testList.indexOf("V2");
        int locationOfV0 = testList.indexOf("V0");
        int locationOfV3 = testList.indexOf("V3");
        int locationOfV1 = testList.indexOf("V1");


        testList.add(1, "T1");
        testList.add(2, "T2");
        testList.add(2, "T3");
        testList.add(0, "V0" );
        testList.add(1, "V1" );
        testList.add(2, "V2" );
        testList.add(3, "V3" );
        testList.add(3, "T4");
        testList.add(1, "T5");
        testList.add(1, "T1");
        testList.add(2, "T2");
        testList.add(0, "V0" );
        testList.add(1, "V1" );
        testList.add(2, "V2" );
        testList.add(3, "V3" );
        testList.add(2, "T3");
        testList.add(3, "T4");
        testList.add(1, "T5");

        int locationLastV2 = testList.lastIndexOf("V2");
        int locationLastV3 = testList.lastIndexOf("V3");
        int locationLastV0 = testList.lastIndexOf("V0");
        int locationLastV1 = testList.lastIndexOf("V1");
        int locationLast = testList.lastIndexOf("T5");
        int locationLast1 = testList.lastIndexOf("T1");
    }
}
