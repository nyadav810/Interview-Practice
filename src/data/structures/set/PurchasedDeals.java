import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class PurchasedDeals {
   private Set<Deal> deals;
   
   public PurchasedDeals() {
      this.deals = new TreeSet<Deal>();
   }
   
   public void add(Deal deal) {
      this.deals.add(deal);
   }
   
   public List<Deal> display() {
      List<Deal> deals = new ArrayList<Deal>();
      for (Deal d : this.deals) {
         deals.add(d);
      }
      Collections.sort(deals);
      return deals;
   }
   
   public static void main(String[] args) {
      PurchasedDeals d = new PurchasedDeals();
      Deal d1 = new Deal("1", new Date());
      Deal d2 = new Deal("2", new Date(2323223232L));
      Deal d3 = new Deal("3", new Date());
      Deal d4 = new Deal("4", new Date());
      d.add(d1);
      d.add(d2);
      d.add(d3);
      d.add(d4);
      
      List<Deal> deals = d.display();
      System.out.println(deals.toString());
   }
}