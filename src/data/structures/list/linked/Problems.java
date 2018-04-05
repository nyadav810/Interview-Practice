package data.structures.list.linked;

import java.util.Map;
import java.util.HashMap;

public class Problems {
   
   static class Node {
      public int data;
      public Node next;
      
      public Node(int data) {
         this.data = data;
         this.next = null;
      }
      
      public void add(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
      }
   }
   
   public static int sumCount(Node head, int sum) {
      if (head == null || head.next == null) {
         return 0;
      }
      
      // we can loop through the linked list once,
      // and maintain a map of each int to sum - int
      
      Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
      
      Node current = head;
      
      while (current != null) {
         numberMap.put(current.data, sum - current.data);
         current = current.next;
      }
      
      // loop through all the keys, and if the map contains that key, increment count.
      
      int count = 0;
      
      for (int key : numberMap.keySet()) {
         if (numberMap.containsKey(numberMap.get(key))) {
            count++;
         }
      }
      
      return count;
   }
   
   public static Node findIntersectingNode(Node a, Node b) {
       Node currentA = a;
       Node currentB = b;
       
       while (currentA != currentB) {
           if (currentA == null) {
               currentA = b;
           }
           
           if (currentB == null) {
               currentB = a;
           }
           
           currentA = currentA.next;
           currentB = currentB.next;
           
           if (currentA.data == currentB.data) {
               return currentA;
           }
       
           if (currentA.data == a.data && currentB.data == b.data) {
               return null; // no intersecting node found
           }
       }
   }
   
   public static void main(String[] args) {
      Node head = new Node(0);
      head.add(2);
      head.add(5);
      head.add(7);
      head.add(4);
      head.add(6);
      head.add(10);
      head.add(20);
      head.add(-10);
      System.out.println(sumCount(head, 10));
   }
}