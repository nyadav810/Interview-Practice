

public class BinaryHeap {
   private static final int DEFAULT_CAPACITY = 10;

   private int size;
   private int[] array;
   
   public BinaryHeap() {
      this(DEFAULT_CAPACITY);
   }
   
   public BinaryHeap(int capacity) {
      this.array = new int[capacity];
   }
   
   public int size() {
      return this.size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public void insert(int x) {
      if (size == array.length - 1) {
         enlargeArray(array.length * 2 + 1);
      }
      
      int hole = ++size;
      
      for (
   }
   
   public int findMin() {
      if (isEmpty()) {
         throw new IndexOutOfBoundsException();
      }
      return array[0];
   }
   
   public int deleteMin() {
      return array[0];
   }
   
   private void percolateDown(int hole) {
   
   }
   
   private void buildHeap() {
      
   }
   
   private void enlargeArray(int newSize) {
      
   }
}