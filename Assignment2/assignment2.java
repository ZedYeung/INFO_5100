/**
 * Each Question carries 2 points.
 * Deadline 22 sept, Friday, 11:59PM.
 * Extra credit points will be added if total points are less than 10.
 * Try every question and keep practising from other online sites.
 * Contact us if any assistance is needed.
 */

/**
   1. Write a java function to calculate the salary of an employee based on the following rules.
   i. function takes input of number of hours an employee worked and returns the salary.
   ii.  The first 36 hours worked are paid at a rate of 15.0, then the next 5 hours are paid at a rate of 15 * 1.5. Hours after that up to a max of 48 are paid at a rate of 15 * 2.

   Here is the prototype you can work with
 */
 import java.util.*;
 import java.math.BigDecimal;

class Assignment2 {
        public static void main(String[] args) {
                for (double j=7; j < 60; j += 10)
                        employeeSalary(j);
                addDigits(1234);
                printPerfectNumbers(200);
                printIsoscelesTriangle(7);
        }


        public static double employeeSalary( double hours){
                double salary = 0;
                if (hours <= 48 && hours > 41 ) {
                        salary = (hours - 41) * 30 + 5 * 22.5 + 36 * 15;
                } else if (hours > 36 && hours <=41) {
                        salary = (hours - 36) * 22.5 + 36 * 15;
                } else if (hours <= 36 && hours >= 0) {
                        salary = hours * 15;
                } else {
                        System.out.println("Impossible! No salary for you!");
                        salary = 0;
                }
                System.out.println(salary);
                return salary;
        }

// employeeSalary(7);

/**
   2. Write a java function that adds all the digits of an integer until it is single digit.
   i. function takes an integer as input and returns its sum of digits.
   ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.

   Here is the prototype you can work with
 */
        public static int addDigits( int input){
                int i = 0;
                while (input > 0) {
                        i += (input % 10);
                        input /= 10;
                }
                System.out.println(i);
                return i;
        }

/**
   3. Write a java function to print all perfect number between 1 and n.
   i. Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
   ii. For example: 6 is the first perfect number, Proper divisors of 6 are 1, 2, 3. Sum of its proper divisors = 1 + 2 + 3 = 6.

   Here is the prototype you can work with
 */
        public static void printPerfectNumbers( int n){
                for (int j =1; j < n; j++) {
                        int perfectNumber = 0;
                        for (int i =1; i < j; i++) {
                                if (j % i == 0) {
                                        perfectNumber += i;
                                }
                        }
                        if (perfectNumber == j) {
                                System.out.println(j);
                        }
                }
        }

/**
   4. Write a java class called pizza with (Add detail as needed) :
   i. Create atleast 3 attributes :pizza type , unit price and loyalty points. More attributes are welcome to have.
   ii. Create constructors . Extra-credit of 0.5 point if you write more than 1 right constructor to this class
 */
 public class Pizza {
        String type;
        double unitPrice;
        double loyaltyPoints;
        Date productionDate;
        Date expirationDate;
        List<String> ingredients;

        public Pizza(String type, double unitPrice, double loyaltyPoints) {
            this.type = type;
            this.unitPrice = unitPrice;
            this.loyaltyPoints = loyaltyPoints;
        }

        public Pizza(String type, double unitPrice, double loyaltyPoints,
                Date productionDate, Date expirationDate) {
            this.type = type;
            this.unitPrice = unitPrice;
            this.loyaltyPoints = loyaltyPoints;
            this.productionDate = productionDate;
            this.expirationDate = expirationDate;
        }

        public static void main(String[] args) {
                Pizza pizza = new Pizza("Greek", 5.5, 6);

                System.out.println("Unit price:" + pizza.unitPrice);
        }

}

/**
   5. Write a java class called customer (Add detail as needed) :
   i. Create Attributes: customer name and which pizzas customer has ordered.
   ii. Think about what kind of data structure can be used to record the pizza name and number of each kind of pizza.( Give me your thought, Extra credit of 1 point)
   iii. In main method , sum up how much money the customer spent.
 */
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

// EXTRA CREDIT
/**
   6. Write a Java program that generates an isosceles right angled triangle made of asterisks.
   i. function should take input of one equal side as integer. Other than the edges the inner part of the triangle should be empty.
   ii. For example input is 6. the function should print—

 *
 **
 * *
 *  *
 *   *
 ******

   Here is the prototype you can work with
 */

        public static void printIsoscelesTriangle( int n){
                for (int i=1; i<=n; i++) {
                        if (i > 1) {
                                System.out.print('*');
                        }
                        for (int j=1; j < i - 1; j++) {
                                if (i < n) {
                                        System.out.print(' ');
                                } else {
                                        System.out.print('*');
                                }

                        }
                        System.out.println("*");
                }
        }

}
