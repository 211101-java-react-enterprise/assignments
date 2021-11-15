package com.revature.custom_collections.collections;

import java.util.Map;
import java.util.Objects;

/**
 * Hash table based implementation of the Map interface. This implementation
 * permits null values and the null key. This class makes no guarantees as to
 * the order of the map; in particular, it does not guarantee that the order
 * will remain constant over time.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashMap<K, V> implements Map<K, V> {

    private int size;
    private final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] entries = new Entry[DEFAULT_CAPACITY];

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
//    @Override
//    public V get(K key) {
//        return null;
//    }

    @Override
    public V get(K key) {
        tmp_head = head;
        Node<K, V> prev = null;
        for (int i = 0; i < size; i++) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            } else {
                prev = head.next;
                head = prev;
            }
        }
        return null;
    }



    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
//    @Override
//    public V put(K key, V value) {
//        return null;
//    }

    Node<K, V> head = null;
    Node<K, V> tmp_head = null;

    @Override
    public V put(K key, V value) {
        if (head == null) {
            size = 1;
            head = new Node<K, V>(hash(null), key, value, null);
            return value;
        } else {
            size++;
            Node<K, V> prev = head;
            head = new Node<K, V>(hash(prev), key, value, prev);
            return value;
        }
    }


    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
//    @Override
//    public V remove(K key) {
//        return null;
//    }

    @Override
    public V remove(K key) {

        tmp_head = head;
        Node<K, V> prev = null;
        for (int i = 0; i < size; i++) {
            if (head.getKey().equals(key)) {
                size--;
                if (prev != null) {
                    prev.next = head.next;
                    V v = head.getValue();
                    head = prev;
                    return v;
                } else {
                    return head.getValue();
                }
            } else {
                prev = head;
                head = head.next;
            }
        }
        return null;
    }


    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(Object key) {
        for (Entry<K, V> node : entries){
            if(node.getKey()==key) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return true if this map maps one or more keys to the specified value
     */
    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> node : entries){
            if(node.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Basic hash bin node structure. No need to change implementation for exercise.
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     */
    static class Node<K,V> implements Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Entry<?,?> e = (Entry<?,?>)o;
                return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
            }
            return false;
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
