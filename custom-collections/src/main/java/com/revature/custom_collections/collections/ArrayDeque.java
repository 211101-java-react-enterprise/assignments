package com.revature.custom_collections.collections;

/**
 * Resizable-array implementation of the Deque interface. Array deques have no
 * capacity restrictions; they grow as necessary to support usage. Null elements
 * are prohibited.
 *
 * @param <T> the type of elements maintained by this list
 */
public class ArrayDeque<T> implements Deque<T> {

    private Object[] elements;

    /**
     * Constructs an empty array deque with an initial capacity sufficient to
     * hold 16 elements.
     */
    public ArrayDeque() {
        elements = new Object[16];
    }

    /**
     * Constructs an empty array deque with an initial capacity sufficient to
     * hold the specified number of elements.
     *
     * @param initialCapacity lower bound on initial capacity of the deque
     */
    public ArrayDeque(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param element the element to add
     * @return true
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(T element) {
        return false;
    }


    /**
     * Returns true if this deque contains the specified element. More formally,
     * returns true if and only if this deque contains at least one element e such
     * that o.equals(e).
     *
     * @param element object to be checked for containment in this deque
     * @return true if this deque contains the specified element
     */
    @Override
    public boolean contains(T element) {
        return false;
    }

    /**
     * Returns true if this deque contains no elements.
     *
     * @return true if this deque contains no elements
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Removes the first occurrence of the specified element in this deque (when
     * traversing the deque from head to tail). If the deque does not contain the
     * element, it is unchanged. More formally, removes the first element e such
     * that o.equals(e) (if such an element exists). Returns true if this deque
     * contained the specified element (or equivalently, if this deque changed
     * as a result of the call).
     *
     * @param element element to be removed from this deque, if present
     * @return true if the deque contained the specified element
     */
    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param element the element to add
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void addFirst(T element) {

    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param element the element to add
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void addLast(T element) {

    }

    /**
     * Retrieves and removes the first element of this deque, or returns null
     * if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public T pollFirst() {
        return null;
    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if
     * this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public T pollLast() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns null
     * if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public T peekFirst() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns null
     * if this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public T peekLast() {
        return null;
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in other words,
     * the first element of this deque), or returns null if this deque is empty.
     *
     * This method is equivalent to pollFirst().
     *
     * @return the head of the queue represented by this deque, or null if this deque is empty
     */
    @Override
    public T poll() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque, or
     * returns null if this deque is empty.
     *
     * This method is equivalent to peekFirst().
     *
     * @return the head of the queue represented by this deque, or null if this deque is empty
     */
    @Override
    public T peek() {
        return null;
    }

}
