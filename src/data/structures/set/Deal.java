import java.util.Date;

public class Deal implements Comparable<Deal> {
   private String uid;
   private Date date;
   
   public Deal(String uid, Date date) {
      this.uid = uid;
      this.date = date;
   }
   
   public int compareTo(Deal other) {
      if (date.compareTo(other.date) == 0) {
         return uid.compareTo(other.uid);
      } else {
         return date.compareTo(other.date);
      }
   }
   
   public String toString() {
      return "Deal #" + this.uid + ", added at " + this.date.toString();
   }
}