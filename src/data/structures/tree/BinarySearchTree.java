package data.structures.tree;

public class BinarySearchTree<E extends Comparable<? super E>> {
   private static class BinaryNode<E> {
      E element;
      BinaryNode<E> left;
      BinaryNode<E> right;
      
      BinaryNode(E element) {
         this(element, null, null);
      }
      
      BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
         this.element = element;
         this.left = left;
         this.right = right;
      }
   }
   
   private BinaryNode<E> root;
   
   public BinarySearchTree() {
      makeEmpty();
   }
   
   public void makeEmpty() {
      root = null;
   }
   
   public boolean isEmpty() {
      return root == null;
   }
   
   public boolean contains(E x) {
      return contains(root, x);
   }
   
   public E findMin() {
      if (isEmpty()) {
         //throw new UnderflowException();
      }
      
      return findMin(root).element;
   }
   
   public E findMax() {
      if (isEmpty()) {
         //throw new UnderflowException();
      }
      return findMax(root).element;
   }
   
   public void insert(E element) {
      root = insert(root, element);
   }
   
   public void remove(E element) {
      root = remove(root, element);
   }
   
   public boolean isValid() {
      return isValid(root, root.element);
   }
   
   /*
    * Returns true if the tree contains the passed element.
    * Else return false. Uses compareTo to traverse BST.
    */
   private boolean contains(BinaryNode<E> root, E x) {
      if (root == null) {
         return false;
      }
      
      int compareResult = x.compareTo(root.element);
      
      if (compareResult < 0) {
         return contains(root.left, x);
      } else if (compareResult > 0) {
         return contains(root.right, x);
      } else {
         return true;
      }
   }
   
   /*
    * Find smallest (leftmost) element in BST.
    */
   private BinaryNode<E> findMin(BinaryNode<E> root) {
      if (root == null) {
         return null;
      } else if (root.left == null) {
         return root;
      }
      return findMin(root.left);
   }
   
   /*
    * Find largest (rightmost) element in BST.
    */
   private BinaryNode<E> findMax(BinaryNode<E> root) {
      if (root != null) {
         while (root.right != null) {
            root = root.right;
         }
      }
      
      return root;
   }
   
   private BinaryNode<E> insert(BinaryNode<E> root, E element) {
      if (root == null) {
         new BinaryNode<E>(element, null, null);
      }
      
      int compareResult = element.compareTo(root.element);
      
      if (compareResult < 0) {
         root.left = insert(root.left, element);
      } else if (compareResult > 0) {
         root.right = insert(root.right, element);
      } else {
         // duplicate
      }
      
      return root;
   }
   
   private BinaryNode<E> remove(BinaryNode<E> root, E element) {
      if (root == null) {
         return root;
      }
      
      int compareResult = element.compareTo(root.element);
      
      // traverse tree recursively to find element
      if (compareResult < 0) {
         root.left = remove(root.left, element);
      } else if (compareResult > 0) {
         root.right = remove(root.right, element);
      } else if (root.left != null && root.right != null) {
         // we found our element, but it has 2 children.
         
         // find the min of the element's right subtree
         root.element = findMin(root.right).element;
         
         // remove the min element from right subtree
         root.right = remove(root.right, root.element);
      } else {
         // prefer to take left child, otherwise take right child
         root = (root.left != null) ? root.left : root.right;
      }
      
      return root;
   }
   
   /*
    * Returns true if this is a valid BST, else return false.
    * BST condition: left child value < parent value < right child value
    */
   private boolean isValid(BinaryNode<E> root, E min, E max) {
      if (root == null) {
         return true;
      }
      
      if (root.element.compareTo(min) <= 0 || root.element.compareTo(max) >= 0) {
         return false;
      }
      
      return isValid(root.left, min, root.element) && isValid(root.right, root.element, max);
   }
}