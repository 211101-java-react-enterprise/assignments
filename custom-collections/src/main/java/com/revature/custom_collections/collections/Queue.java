package com.revature.custom_collections.collections;

public interface Queue<T> extends Collection<T> {
    T poll();
    T peek();
}

