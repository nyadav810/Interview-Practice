package data.structures.linked.list;

import java.util.Arrays;

public class SinglyLinkedList implements List {
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        clear();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public void add(int n) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(n);
        }
        size++;
    }

    public void remove(int n) {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node current = head;

        sb.append(current.data);
        current = current.next;

        while (current != null) {
            sb.append(" -> " + current.data);
            current = current.next;
        }

        return sb.toString();
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            arr[index++] = current.data;
            current = current.next;
        }

        return arr;
    }

    public void print() {
        System.out.println(toString());
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int max = 100;
        int min = 1;

        for (int i = 0; i < 10; i++) {
            int randomInt = (int)(Math.random() * ((max - min) + 1)) + min;
            linkedList.add(randomInt);
        }

        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}
