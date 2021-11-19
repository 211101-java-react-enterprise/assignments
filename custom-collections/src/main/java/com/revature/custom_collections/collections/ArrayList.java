package com.revature.custom_collections.collections;

<<<<<<< HEAD
import java.util.Arrays;

=======
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
/**
 * Resizable-array implementation of the List interface. Permits all element values,
 * including null. Each ArrayList instance has a capacity. The capacity is the size
 * of the array used to store the elements in the list. It is always at least as large
 * as the list size. As elements are added to an ArrayList, its capacity grows
 * automatically.
 *
 * @param <T> the type of elements maintained by this list
 */
public class ArrayList<T> implements List<T> {

<<<<<<< HEAD
    private T[] array = (T[]) new Object[10];
    private int size = 0;

=======
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T element) {
<<<<<<< HEAD
        array[size] = element;
        size++;

        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        return true;
=======
        return false;
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param element element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    @Override
    public boolean contains(T element) {
<<<<<<< HEAD
        for (int i = 0; i <= size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
=======
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
<<<<<<< HEAD
        if (size == 0) {
            return true;
        }
=======
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
        return false;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged. More formally, removes the
     * element with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i)))
     * (if such an element exists). Returns true if this list contained the specified element.
     *
     * @param element element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(T element) {
<<<<<<< HEAD
        for (int i = 0; i <= size; i++) {
            if (array[i] == element) {
                array[i] = null;
                size--;
                return true;
            }
        }
=======
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
<<<<<<< HEAD
        return size;
=======
        return 0;
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
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
<<<<<<< HEAD
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
=======
        return null;
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts
     * the element currently at that position (if any) and any subsequent elements
     * to the right (adds one to their indices).
     *
<<<<<<< HEAD
     * @param index   index at which the specified element is to be inserted
=======
     * @param index index at which the specified element is to be inserted
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    @Override
    public void add(int index, T element) {
<<<<<<< HEAD
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        T last = array[array.length - 1];
        for (int i = array.length - 2; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
=======

>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
<<<<<<< HEAD
     * @param index   index of the element to replace
=======
     * @param index index of the element to replace
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
<<<<<<< HEAD
        T removedElement = array[index];
        array[index] = element;
        return removedElement;
=======
        return null;
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
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
<<<<<<< HEAD
        T removedElement = null;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size - 1) {
            removedElement = array[index];
        } else {
            removedElement = array[index];
            // shift elements left if needed
//        for (int i = index; i < array.length - 1; i++) {
//            removedElement = array[i];
//            array[i] = array[i + 1];
//        }
        }

        size--;
        return removedElement;
=======
        return null;
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the lowest
     * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is
     * no such index.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in this list,
<<<<<<< HEAD
     * or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
=======
     *         or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T element) {
        return 0;
>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element. More formally, returns the highest
     * index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is
     * no such index.
     *
     * @param element element to search for
     * @return the index of the last occurrence of the specified element in this list,
<<<<<<< HEAD
     * or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--)
                if (array[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (element.equals(array[i]))
                    return i;
        }
        return -1;
    }

    public String toStringTrim() {
        T[] trimmedAway = (T[]) new Object[size];
        for(int i = 0; i < trimmedAway.length; i++) {
            trimmedAway[i] = array[i];
        }
        return "ArrayList = " + Arrays.toString(trimmedAway) +
                "\nsize = " + size();
    }

    @Override
    public String toString() {
        return "ArrayList = " + Arrays.toString(array) +
                "\nsize = " + size();
    }
=======
     *         or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        return 0;
    }

>>>>>>> e52f18a04c7decb1699f63e9d024493cedb14212
}
