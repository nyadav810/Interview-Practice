package data.structures.list.linked;

import java.util.Arrays;

import data.structures.list.List;

public class SinglyLinkedList { //implements List {
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this(data, null);
        }
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
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

    public void add(int index, int value) {
        if (index == 0) {
            head = new Node(value, head);
        } else {
            Node current = nodeAt(index - 1);
            current.next = new Node(value, current.next);
        } 
    }
    
    public int get(int index) {
        Node current = nodeAt(index);
        return current.data;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }
    
    private Node nodeAt(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    private Node search(Node n, int element) {
        if (n == null) {
            return null;
        }
        
        if (element == n.data) {
            return n;
        } else {
            return search(n.next, element);
        }
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
