package main.java.com.universe.ArrList.Interface;

import java.util.Collection;

public interface List<T> {
    void add(T value);

    void add(T value, int index);

    Object get(int i);

    void set(int index, T value);

    T remove(int index);

    void clear();

    int size();

    void addFirst(T value);

    void addLast(T value);

    void check();

    boolean addAll(Collection<? extends T> c);
    boolean isEmpty();
}
