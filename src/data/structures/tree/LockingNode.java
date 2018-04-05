

public class LockingNode {
   int data;
   boolean locked;
   LockingNode left;
   LockingNode right;
   LockingNode parent;
   
   public LockingNode(int data, LockingNode parent) {
      this.data = data;
      this.locked = false;
      this.left = null;
      this.right = null;
      this.parent = parent;
   }
   
   public boolean isLocked() {
      return this.locked;
   }
   
   public boolean lock() {
      if (isLocked()) {
         return false;           // already locked
      }
      
      // look at ancestors & descendants the same way as unlock()
      if (descendantsUnlocked() && ancestorsUnlocked()) {
         this.locked = true;
         return true;
      }
      
      return false;
   }
   
   public boolean unlock() {
      if (!isLocked()) {
         return false;     // already unlocked
      }
      
      if (descendantsUnlocked() && ancestorsUnlocked()) {
         this.locked = false;
         return true;
      }
      return false;
   }
   
   private boolean ancestorsUnlocked() {
      LockingNode current = this.parent;
      while (current != null) {
         if (current.isLocked()) {
            return false;
         }
         current = current.parent;
      }
      return true;
   }
   
   private boolean descendantsUnlocked() {
      return descendantsUnlocked(this.left) && descendantsUnlocked(this.right);
   }
   
   private boolean descendantsUnlocked(LockingNode node) {
      if (node == null) {
         return true;
      }
      
      if (node.isLocked()) {
         return false;
      }
      
      return descendantsUnlocked(node.left) && descendantsUnlocked(node.right);
   }
}
