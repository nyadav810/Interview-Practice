package data.structures.list.array;

import data.structures.list.IntList;

public class ArrayIntList {//implements IntList {

    private int[] elements;
    private int size;

    public ArrayIntList() {
        this(10);       // default capacity
    }

    public ArrayIntList(int capacity) {
        elements = new int[capacity];
    }

    public void add(int index, int element) {

    }

    public boolean add(int element) {
        return true;
    }

    private void ensureCapacity() {

    }
}
