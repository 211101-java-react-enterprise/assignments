package com.revature.custom_collections.collections;

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

    private int size;

    private T[] arr = (T[]) new Object[10];


    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    @Override
    public boolean add(T element) {
        int loc = -1;
        //looking for first null element
        for(int i = 0; i<arr.length;i++){
            if(arr[i] == null){
                loc = i;
                break;
            }
        }
        if(loc != -1){
            arr[loc] = element;
            size++;
        }else {
            T[] oldarr= arr;
            arr = (T[]) new Object[arr.length+1];
            System.arraycopy(oldarr, 0, arr, 0, oldarr.length);
            size++;
            arr[arr.length-1] = element;
        }
        return true;
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
        for(int i = 0; i<size;i++){
            if(arr[i].equals(element)){
                return true;
            }
        }
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
     * @param element element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(T element) {
        for(int i = 0; i<arr.length;i++){
            if(arr[i].equals(element)){
                arr[i] = null;
                return true;
            }
        }
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
        return arr[index];
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
        boolean nullPres = false;
        //looking for first null element
        for (T t : arr) {
            if (t == null) {
                nullPres = true;
                break;
            }
        }
        T[] oldarr = arr;
        if (nullPres) {
            arr = (T[]) new Object[arr.length];
            for (int i = 0; i < oldarr.length; i++) {
                if (i < index) {
                    arr[i] = oldarr[i];
                } else if (i == index) {
                    arr[i] = element;
                } else {
                    arr[i + 1] = oldarr[i];
                }
            }
        } else {
            arr = (T[]) new Object[arr.length + 1];
            for (int i = 0; i < oldarr.length; i++) {
                if (i < index) {
                    arr[i] = oldarr[i];
                } else if (i == index) {
                    arr[i] = element;
                } else {
                    arr[i + 1] = oldarr[i];
                }
            }
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
        T prev = arr[index];
        arr[index] = element;
        return prev;
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
        if((index < 0 || index >= arr.length)){
            throw new IndexOutOfBoundsException();
        }
        T data = null;
        for (int i = 0; i < arr.length; i++) {
            if (i >= index) {
                if (i == index){
                    data = arr[i];
                }
                arr[i] = arr[i+1];
            }
        }
        return data;
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
        for(int i = 0; i<arr.length;i++){
            if(arr[i].equals(element)){
                return i;
            }
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
     *         or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(T element) {
        int loc = -1;
        for(int i = 0; i<arr.length;i++){
            if(arr[i].equals(element)){
                loc = i;
            }
        }
        return loc;
    }

}
