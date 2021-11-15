package com.revature.custom_collections.collections;

public interface Deque<T> extends Queue<T> {
    void addFirst(T element);
    void addLast(T element);
    T pollFirst();
    T pollLast();
    T peekFirst();
    T peekLast();
}
