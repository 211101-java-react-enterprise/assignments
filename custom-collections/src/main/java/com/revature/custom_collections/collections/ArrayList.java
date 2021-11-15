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

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return true
     */
    protected T[] elements;
    private int size; // number of current items in list

    public ArrayList() {
        elements =(T[]) new Object[10];
        size = 0;
    }

    public boolean add(T element) {
        if(size >= elements.length){
            makeRoom();
        }
        elements[size] = element;
        size++;
        return true;
    }

    private void makeRoom() {
       T[] tempArray= elements;
       elements =(T[])new Object[elements.length + 10];
       for(int i=0;i<=tempArray.length;i++){
           elements[i]=tempArray[i];
       }

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
        for(T elementData : elements){
            if(elementData != null && elementData.equals(element)){
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

        for(int i=0;i<elements.length;i++){
            if(elements[i].equals(element)){
                size--;
                for(int j=i;j<elements.length-1;j++){
                    elements[j]=elements[j+1];
                }
                elements[elements.length-1]=null;
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
        return elements[index];
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
    public void add(int index, T element) throws IndexOutOfBoundsException{
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (size + 1 > elements.length) {
            makeRoom();
        }

        T temp=element;
        T temp2;
        for(int i=index;i<elements.length;i++){
            temp2 = elements[i];
            elements[i]=temp;
            temp=temp2;
        }
        size++;
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
        T temp = elements[index];
        elements[index]=element;
        return temp;
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
    public T remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        T temp = elements[index];
        for(int i=index;i<elements.length-1;i++){
            elements[i]=elements[i+1];
        }
        elements[elements.length-1]=null;
        size--;
        return temp;
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
        int index = 0;
        for (T elementData : elements) {
            if (elementData.equals(element)) {
                return index;
            }
            index++;
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
        for(int i = elements.length - 1; i >= 0; i--){
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

}
