package data.structures.list.linked;

public class DoublyLinkedList {
   class Node {
      int data;
      Node next;
      Node prev;
      
      Node(int data) {
         this.data = data;
         this.next = null;
         this.prev = null;
      }
   }
   
   public Node rotateLinkedList(Node head, int N) {
      if (head == null || N < 1) {
         throw new IllegalArgumentException();
      }
      
      Node last = head;
      int length = 0;
      while (last.next != null) {
         last = last.next;
         length++;
      }
      
      Node nth = head;
      if (N > length) {
         N = N % length;
      }
      for (int i = 0; i < N; i++) {
         nth = nth.next;
      }
      Node nPlus1 = nth.next;
      
      Node temp = head;
      last.next = temp;
      temp.prev = head;
      nth.next = null;
      nPlus1.prev = null;
      head = nPlus1;
      return head;
   }
}