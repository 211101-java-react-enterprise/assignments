package com.revature.custom_collections.collections;

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

    private int size = 0;
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
    @Override
    public V get(K key) {
        K thisKey;
        V thisValue = null;

        for(int i = 0; i < size; i++) {
            thisKey = entries[i].getKey();
            if(thisKey == null) {
                if(key == null) {
                    thisValue = entries[i].getValue();
                }
                continue;
            }
            if(thisKey.equals(key)) {
                thisValue = entries[i].getValue();
            }
        }
        return thisValue;
    }

    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V put(K key, V value) {
        //If exists, return old value, just put it in... return null
        V thisValue = null;
        K thisKey;
        Node<K,V> newEntry;
        if(size == 0) {
            newEntry = new Node<>(hash(key), key, value, null);
            entries[0] = newEntry;
        }
        for(int i = 0; i < size; i++) {
            thisKey = entries[i].getKey();
            //System.out.printf("thisKey: %s, givenKey: %s\n", thisKey, key);
            if(thisKey == null) {
                if (i == size - 1) {
                newEntry = new Node<>(hash(key), key, value, null);
                entries[i + 1] = newEntry;
                }
                if (key == null) {

                    V oldValue = entries[i].getValue();
                    newEntry = new Node<>(hash(key), key, value, null);
                    entries[i + 1] = newEntry;
                    size++;
                    return oldValue;
                }
                else {
                    continue;
                }
            }
            if(thisKey.equals(key)) {
                thisValue = entries[i].setValue(value);
                return thisValue;
            } else if(i == size - 1) {
                newEntry = new Node<>(hash(key), key, value, null);
                try {
                    entries[i + 1] = newEntry;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Entry<K, V>[] newEntries = new Entry[size*2];
                    System.arraycopy(entries, 0, newEntries, 0, size);
                    newEntries[i+1] = newEntry;
                    entries = newEntries;
                }
            }
        }
        size++;
        return thisValue;
    }


    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V remove(K key) {
        V thisValue = null;
        for(int i = 0; i < size; i++) {
            K thisKey = entries[i].getKey();
            if(thisKey == null) {
                if(key == null) {
                    thisValue = entries[i].getValue();
                    entries[i] = null;
                    size--;
                }
                continue;
            }
            if(thisKey.equals(key)) {
                thisValue = entries[i].getValue();
                entries[i] = null;
                size--;
            }
            if (thisValue != null) {
                entries[i] = entries[i+1];
            }

        }

        return thisValue;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key.
     */
    @Override
    public boolean containsKey(K key) {
        if(size == 0) {
            return false;
        }
        for(int i = 0; i < size; i++) {
            if(entries[i].getKey().equals(key) && entries[i] != null) {
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
    public boolean containsValue(V value) {
        for(int i = 0; i < size; i++) {
            if(entries[i].getValue() == value) {
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
        return size == 0;
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
