package main.java.com.universe.ArrList;

import main.java.com.universe.ArrList.Interface.List;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ArrList<T> implements List<T> {
    private static int Capacity = 3;
    private Object[] Array;
    private int Size;

    public ArrList() {
        this.Array = new Object[Capacity];
        Size=0;
    }

    public ArrList(int size) {
        Capacity = size;
        this.Array = new Object[Capacity];
        Size = 0;

    }

    @Override
    public void check() {
        if (Size == Array.length) {
            int newCapacity = (int) (Size * 1.5) + 1;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(Array, 0, newArray, 0, Size);
            Array = newArray;
        }
    }

    @Override
    public void add(T element) {
        check();
        Array[Size++] = element;
    }


    public void add(T element, int index) {
        check();
        System.arraycopy(Array, index, Array, index + 1, Size - index);
        Array[index] = element;
        Size++;
    }


    @Override
    public T remove(int index) {
        Objects.checkIndex(index, Size);
        T removedElement = (T) Array[index];
        System.arraycopy(Array, index + 1, Array, index, Size - index - 1);
        Array[--Size] = null;
        return removedElement;
    }

    @Override
    public void clear() {
        Array=new Object[Capacity];
        Size=0;
    }

    @Override
    public void set(int index, T value) {
        check();
        System.arraycopy(Array, index, Array, index + 1, Size - index);
        Array[index] = value;
        Size++;
    }

    @Override
    public void deleteDuplicates() {
        Array= Arrays.stream(Array).distinct().toArray();
        Size = (int) Arrays.stream(Array).filter((value)->value!=null).count();
    }

    @Override
    public int size() {
        return Size;
    }

    @Override
    public Object get(int i) {
        return Array[i];
    }

    @Override
    public void addFirst(T value) {
        set(0, value);
    }

    @Override
    public void addLast(T value) {
        set(Size, value);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        if (a.length == 0)
            return false;
        Object[] elementData;
        final int s;
        if (a.length > (elementData = this.Array).length - (s = Size))
            elementData = addSpace();
        System.arraycopy(a, 0, elementData, s, a.length);
        Size = s + a.length;
        return true;
    }

    private Object[] addSpace() {
        int newCapacity = Array.length + (Array.length / 2);
        return Array = Arrays.copyOf(Array, newCapacity);
    }

    @Override
    public String toString() {
        return "ArrList{" +
                "Array=" + Arrays.toString(Array) +
                ", Size=" + Size +
                '}';
    }

    public boolean isEmpty(){
        return Size==0;
    }

}
