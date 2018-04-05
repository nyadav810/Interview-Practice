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
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, int element) {

    }

    public boolean add(int element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int[] newElementArray = new int[elements.length*2];
            for (int i = 0; i < elements.length; i++) {
                newElementArray[i] = elements[i];
            }
            elements = newElementArray;
        }
    }
    
    // [1,2,3,4,5,6,7,8,9,10]
}
