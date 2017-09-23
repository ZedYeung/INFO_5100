import java. util.*;
import java.math.BigDecimal;

 public class Customer {
         String name;
         Map<Pizza, Integer> pizzas;

         public Customer(String name, Map<Pizza, Integer> pizzas) {
             this.name = name;
             this.pizzas = pizzas;
         }

         private static double check(Customer customer){
                 Map<Pizza, Integer> pizzas = customer.pizzas;
                 double total =0.0;

                 for (Pizza pizza : pizzas.keySet()) {
                          double unitPrice = pizza.unitPrice;
                          int amount = pizzas.get(pizza);
                          total += unitPrice * amount;
                 }

                 double tax = total * 0.1;
                 total += tax;
                 BigDecimal bg = new BigDecimal(total);
                 total = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                 return total;
        }

         public static void main(String[] args) {
                 Pizza greek = new Pizza("Greek", 5.5, 6);
                 Pizza neapolitan = new Pizza("Neapolitan", 4.9, 5);

                 Map<Pizza, Integer> pizzas = new HashMap<Pizza, Integer>();
                 pizzas.put(greek, 1);
                 pizzas.put(neapolitan, 2);

                 Customer zed = new Customer("Zed", pizzas);

                 double total = check(zed);
                 System.out.println("Total: " + total);

         }
 }
