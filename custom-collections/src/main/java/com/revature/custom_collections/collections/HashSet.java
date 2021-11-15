package com.revature.custom_collections.collections;

/**
 * This class implements the Set interface, backed by a hash table (actually
 * a HashMap instance). It makes no guarantees as to the iteration order of
 * the set; in particular, it does not guarantee that the order will remain
 * constant over time. This class permits the null element.
 *
 * @param <T> the type of elements maintained by this set
 */
public class HashSet<T> implements Set<T> {

    private final Map<T, Object> map;

    public HashSet() {
        this.map = new HashMap<>();
    }

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * More formally, adds the specified element e to this set if this set
     * contains no element e2 such that (e==null ? e2==null : e.equals(e2)).
     * If this set already contains the element, the call leaves the set
     * unchanged and returns false.
     *
     * @param data element to be added to this set
     * @return true if this set did not already contain the specified element
     */
    @Override
    public boolean add(T data) {
        return false;
    }

    /**
     * Returns true if this set contains the specified element. More formally,
     * returns true if and only if this set contains an element e such that
     * (o==null ? e==null : o.equals(e)).
     *
     * @param data element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(T data) {
        return false;
    }

    /**
     * Removes the specified element from this set if it is present. More formally,
     * removes an element e such that (o==null ? e==null : o.equals(e)), if this
     * set contains such an element. Returns true if this set contained the element.
     *
     * @param data object to be removed from this set, if present
     * @return true if the set contained the specified element
     */
    @Override
    public boolean remove(T data) {
        return false;
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return 0;
    }

}
