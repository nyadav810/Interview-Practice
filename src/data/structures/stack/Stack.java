package data.structures.stack;

public class Stack<E> {
   class Node {
      E data;
      Node next;
      
      Node(E x) {
         data = x;
         next = null;
      }
   }

   private int size;
   private Node top;
   
   public Stack() {
      size = 0;
      top = null;
   }
   
   public void push(E x) {
      if (top == null) {
         top = new Node(x);
      } else {
         Node newTop = new Node(x);
         newTop.next = top;
         top = newTop;
      }
      size++;
   }
   
   public E peek() {
      return top.data;
   }
   
   public E pop() {
      if (top != null) {      
         E removedTop = top.data;
         top = top.next;
         size--;
         return removedTop;
      }
      return null;
   }
   
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
}