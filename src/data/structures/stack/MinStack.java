package data.structures.stack;

// provides a 'min' operation,
// which returns the minimum element
// in the stack in constant time.
public class MinStack<E> extends Stack<E> {
   private Stack<E> minStack;
   
   public MinStack() {
      super();
   }
   
   @Override
   public void push(E x) {
      if (x.compareTo(minStack.peek()) < 0) {
         minStack.push(x);
      }
      super.pop();
   }
   
   @Override
   public E pop() {
      
   }
   
   public E min() {
      return minStack.pop();
   }
}