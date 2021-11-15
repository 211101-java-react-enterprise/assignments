package com.revature.custom_collections.collections;


// Test comment!

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

        // Creates a new, empty node
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            // If there is no head, set this node as the head
            tail = head = newNode;
        } else {
            // If there is a previous node, set the tail to the new node.
            tail = tail.nextNode = newNode;
        }

        // Increase the size to reflect this change
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

        // Create a copy of the head node to hold the parsed data
        Node<T> runner = head;
        while (runner != null) {
            // If the node has the data we're looking for, return true.
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
    } // Simple boolean statement. Checks if size is zero.

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

        // Initialize the previous node to null and set the current node to head
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
    } // Simple return method

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
        // Iterates through the list until you get to the requested.
        Node<T> currentNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return currentNode.data;
            }
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts
     * the element currently at that position (if any) and any subsequent elements
     * to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    @Override
    public void add(int index, T element) {
        // Initialize the previous node to null and set the current node to head
        Node<T> prevNode = null;
        Node<T> currentNode = head;

        // Create our new node
        Node<T> newNode = new Node<T>;
        newNode.data = element;

        // An exception for if the index is too large.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Provided index is out of bounds");
        }

        // Traverse through the list
        for (int i = 0; i < size; i++) {

            // Keep going until we reach our requested index.
            if (i == index) {

                // Edit node links
                if (currentNode == head) {
                    newNode.nextNode = head;
                    head = newNode;
                } else {
                    newNode.nextNode = currentNode;
                    prevNode.nextNode = newNode;
                }

                // Increment the size of the list
                size++;

            }

            // Move references forward to proceed through the linked list
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Provided index is out of bounds");
        }
        // Iterates through the list until you get to the requested position.
        Node<T> currentNode = head;
        // Holder for previous data
        Node<T> container = null;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                // When you rach the location, save the data and return it after replacing it.
                container.data = currentNode.data;
                currentNode.data = element;
                return container.data;
            }
            currentNode = currentNode.nextNode;
        }
        // Return null if something goes wrong.
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Provided index is out of bounds");
        }
        // Iterates through the list until you get to the requested position.
        Node<T> currentNode = head;
        // Holder for previous data
        Node<T> container = null;
        Node<T> prevNode = null;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                // When you reach the location, delete the data and bridge the gap
                container.data = currentNode.data;
                // Edit node links
                if (currentNode == head) {
                    head = currentNode.nextNode;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }

                // Decrement the size of the list
                size--;

                return container.data;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        // Return null if something goes wrong.
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
        // Create a copy of the head node to hold the parsed data
        Node<T> runner = head;
        int index = 0;
        while (runner != null) {
            // If the node has the data we're looking for, return true.
            if (runner.data.equals(element)) {
                return index;
            }
            runner = runner.nextNode;
            index = index + 1;
        }
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
        // Create a copy of the head node to hold the parsed data
        Node<T> runner = head;
        int index = 0;
        int foundIndex = -1;
        while (runner != null) {
            // If the node has the data we're looking for, return true.
            if (runner.data.equals(element)) {
                foundIndex = index;
            }
            runner = runner.nextNode;
            index = index + 1;
        }
        return foundIndex;
    }

    /**
     * Inserts the specified element at the front of this deque.
     *
     * @param element the element to add
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void addFirst(T element) {
        if (element == null) {
            // When the element is null, will throw an exception.
            throw new NullPointerException("Provided element is null!");
        }
        //Creates new node and assigns to head, and points to previos head.
        Node<T> newdata = null;
        newdata.data = element;
        newdata.nextNode = head;
        head = newdata;
        size++;

        
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param element the element to add
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void addLast(T element) {
        if (element == null) {
            // When the element is null, will throw an exception.
            throw new NullPointerException("Provided element is null!");
        }

        // Create a new node, point the tail to it, and assign it as the new tail.
        Node<T> newData = null;
        newData.data = element;
        tail.nextNode = newData;
        tail = newData;
        size++;
    }

    /**
     * Retrieves and removes the first element of this deque, or returns null
     * if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public T pollFirst() {
        //if empty returns null.
        if (head==null) return null;
        //keep track of previous head
        Node<T> tempNode= head;
        //if only one element, reduce size and set head and tail to null, then return tempnode
        if(head.nextNode==null){
            size--;
            head = null;
            tail= null;
            return tempNode.data;
        }
        //otherwise reduce size set head to next node, and return temp
        size--;
        head =head.nextNode;
        return tempNode.data;

    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if
     * this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public T pollLast() {
        // Return null in a null statement.
        if (tail == null) return null;
        // Save the previous tail's data
        Node<T> tempNode = tail;
        // If the linked list is size 1, set the head to null as well as the tail and decrement size.
        if (head.nextNode == null) {
            size--;
            head = null;
            tail= null;
            return tempNode.data;
        }
        // Otherwise, save the data and tack the new item onto the end.
        // Read through the linked list
        Node<T> runner = head;
        while (runner != null){
            // When the next node is the tail, the last node, we know it's time to get rid of it.
            if (runner.nextNode == tail) {
                // Set the runner's next node to null, since it's the new tail.
                runner.nextNode = null;
                // Set the tail to the new last value, that was previously right before the tail.
                tail = runner;
                // Decrement the size
                size--;
                // Return the previous tail's data
                return tempNode.data;
            }
            runner = runner.nextNode;
        }
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns null
     * if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public T peekFirst() {
        return head.data;
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns null
     * if this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public T peekLast() {
        return tail.data;
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
        return pollFirst();
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
        return peekFirst();
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
