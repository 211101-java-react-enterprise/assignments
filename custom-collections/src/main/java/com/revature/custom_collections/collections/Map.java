package com.revature.custom_collections.collections;

public interface Map<K,V> {

    V get(K key);
    V put(K key, V value);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    boolean isEmpty();
    int size();

    interface Entry<K,V> {
        K getKey();
        V getValue();
        V setValue(V value);
        boolean equals(Object var1);
        int hashCode();
    }

}
