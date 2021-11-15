package com.revature.custom_collections.collections;

/**
 * Singly-linked list implementation of the List and Deque interfaces. Permits
 * all elements (including null).
 *
 * @param <T> the type of elements maintained by this list
 */
public class LinkedList<T> implements List<T>, Deque<T> {

    private int size;
    private Node<T> head; // implicitly null
    private Node<T> tail = null; // you can explicitly declare them as null, but it's not required.

    /**
     * Appends the specified element to the end of this list.
     *
     * @param data element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T data) {

        // Not required, as some data structures do allow for null values.
        if (data == null) {
            return false;
        }

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail = tail.nextNode = newNode;
        }

        size++;

        return true;

    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param data element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(T data) {

        Node<T> runner = head;
        while (runner != null) {
            if (runner.data.equals(data)) {
                return true;
            }
            runner = runner.nextNode;
        }

        // No node with matching data was found
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally, removes the
     * element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
     * (if such an element exists). Returns true if this list contained the specified element.
     *
     * @param data element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(T data) {

        Node<T> prevNode = null;
        Node<T> currentNode = head;

        // If the list is empty, there is no data to remove.
        // Return false to indicate that remove operation was not performed successfully since the data was not present.
        if (size == 0) {
            return false;
        }

        // Traverse through the list
        for (int i = 0; i < size; i++) {

            // If matching data is found
            if (currentNode.data == data) {

                // Edit node links
                if (currentNode == head) {
                    head = currentNode.nextNode;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }

                // Decrement the size of the list
                size--;

                // Return true to indicate that remove operation was performed successfully.
                return true;
            }

            // Move references forward to proceed through the
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        // Return false to indicate that remove operation was not performed successfully since the data was not present.
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Provided index is out of bounds");
        }

        Node<T> currentNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return currentNode.data;
            }
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        return null;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public T remove(int index) {
        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the lowest
     * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is
     * no such index.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *         or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T element) {
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the highest
     * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is
     * no such index.
     *
     * @param element element to search for
     * @return the index of the last occurrence of the specified element in this list,
 *             or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        return -1;
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

    @Override
    public String toString() {

        if (head == null) {
            return "[ ]";
        }

        StringBuilder strBldr = new StringBuilder();
        strBldr.append("[ ");

        Node<T> runner = head;
        for (int i = 0; i < this.size; i++) {
            if (i == size - 1) {
                strBldr.append(runner.data.toString()).append(" ");
            } else {
                strBldr.append(runner.data.toString()).append(", ");
            }
            runner = runner.nextNode;
        }

        strBldr.append("]");

        return strBldr.toString();
    }

    // Nested Inner Class
    // The outer class (LinkedList) can see all of the members of this class
    private static class Node<T> {
        T data;
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }

}
