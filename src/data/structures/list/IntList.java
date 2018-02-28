package data.structures.list;

public interface IntList {
    void add(int index, int element);

    boolean add(int e);

    void clear();

    boolean contains(int e);

    int get(int index);

    int indexOf(int e);

    boolean isEmpty();

    int removeAt(int index);

    boolean remove(int e);

    int set(int index, int element);

    int size();

    int[] toArray();
}
