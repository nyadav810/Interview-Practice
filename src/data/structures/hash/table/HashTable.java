package data.structures.hash.table;

public class HashTable<K, V> {

    private Node[] elements;
    private int size;

    public HashTable() {
        this.elements = (Node[]) new HashTable.Node[10];
        this.size = 0;
    }

    public String get(K key) {
        int h = hash(key);

        //if ()
        return "";
    }

    public void put(K key, V value) {

    }

    public boolean containsKey(K key) {
        int h = hash(key);

        Node current = elements[h];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public K remove(K key) {
        return key;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % elements.length;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
