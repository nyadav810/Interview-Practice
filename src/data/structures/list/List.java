package data.structures.list;

public interface List<E> {

    void add(int index, E element);

    boolean add(E e);

    void clear();

    boolean contains(Object o);

    int get(int index);

    int indexOf(Object o);

    boolean isEmpty();

    E remove(int index);

    boolean remove(Object o);

    E set(int index, E element);

    int size();

    Object[] toArray();
}
