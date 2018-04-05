package data.structures.matrix;

import java.util.Queue;
import java.util.LinkedList;

public class MatrixProblems {
   
   // O(n^2) runtime. Simple one by one search of sorted matrix.
   public static void searchSortedMatrix(int[][] arr, int n) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            if (arr[i][j] > n) {
               break;
            } else if (arr[i][j] == n) {
               System.out.printf("Found at (%d, %d)\n", i, j);
               return;
            }
         }
      }
      System.out.println("Element not found.");
   }
   
   public static void testSearchSortedMatrix() {
      int[][] arr = { {10, 20, 30, 40},
                         {15, 25, 35, 45},
                         {27, 29, 37, 48},
                         {32, 33, 39, 50}};
                       
         searchSortedMatrix(arr, 29);
   }
   
   public static void printSpiralMatrix(int[][] a) {
      
   }
   
   public static void testPrintSpiralMatrix() {
      int[][] a = { { 1, 2, 3, 4 },
                    { 5, 6, 7, 8 },
                    { 9, 10, 11, 12 },
                    { 13, 14, 15, 16 } };
      
      printSpiralMatrix(a);
      
      int[][] b = { { 1, 2, 3, 4, 5, 6 },
                    { 7, 8, 9, 10, 11, 12 },
                    { 13, 14, 15, 16, 17, 18 } };
      
      printSpiralMatrix(b);
   }
   
   public class Point {
      public int x;
      public int y;
      public int value;
      public boolean visited;
      
      public Point(int x, int y, int value) {
         this.x = x;
         this.y = y;
         this.value = value;
         this.visited = false;
      }
      
      public boolean equals(Object o) {
         if (o instanceof Point) {
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
         } else {
            return false;
         }
      }
   }
   
   public static int shortestPath(int[][] a, Point source, Point destination) {
      Queue<Point> queue = new LinkedList<Point>();
      queue.add(source);
      int stepCount = 0;
      while (!queue.isEmpty()) {
         Point current = queue.remove();
         current.visited = true;
         stepCount++;
         if (current.equals(destination)) {
            return stepCount;
         } else {
            for (Point neighbor : getNeighbors(current)) {
               if (!neighbor.visited && neighbor.value == 1) {
                  neighbor.visited = true;
                  queue.add(neighbor);
               }
            }
         }
      }
      return -1;
   }
   
   public static Point[] getNeighbors(Point p) {
      Point[] neighbors = new Point[8];
      
      
      
      return neighbors;
   }
   
   public static void main(String[] args) {
      
   }
}