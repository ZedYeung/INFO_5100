import java.lang.*;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keep = true;
        do {
              System.out.println("1. +-*/");
              System.out.println("2. power operation");
              System.out.println("3. Fahrenheit-Celsius");
              System.out.println("4. Feet-Inches");
              System.out.println("5. solve quadratic equation");
              System.out.println("6. exit");
              System.out.println("Please enter Your Choice : ");
              String choice = scanner.next();

              switch(choice)
              {
                case "1":
                  System.out.print("Enter two numbers: ");

                  double n1 = scanner.nextDouble();
                  double n2 = scanner.nextDouble();

                  System.out.print("Enter an operator (+, -, *, /): ");
                  String operator = scanner.next();

                  switch (operator)  {
                    case "+":
                        System.out.println(n1 + n2);
                        break;

                    case "-":
                        System.out.println(n1 - n2);
                        break;

                    case "/":
                        System.out.println(n1 / n2);
                        break;

                    case "*":
                        System.out.println(n1 * n2);
                        break;

                    default:
                        System.out.println("Not supported operation");
                    break;
                  }

                case "2":
                  System.out.println("Enter base: ");
                  double base = scanner.nextDouble();

                  System.out.println("Enter exponent: ");
                  double exponent = scanner.nextDouble();

                  System.out.println(Math.pow(base, exponent));
                  break;

                case "3":
                  System.out.println("1. Fahrenheit to Celsius");
                  System.out.println("2. Celsius to Fahrenheit");
                  System.out.println("Please enter Your Choice : ");

                  String fc = scanner.next();

                  switch (fc) {
                    case "1":
                      System.out.println("Please enter Fahrenheit: ");
                      double fahrenheit = scanner.nextDouble();
                      System.out.println((fahrenheit - 32) / 1.8);
                      break;

                    case "2":
                      System.out.println("Please enter Celsius: ");
                      double celsius = scanner.nextDouble();
                      System.out.println(celsius * 1.8 + 32);
                      break;
                  }
                  break;

                case "4":
                  System.out.println("1. Feet to Inch");
                  System.out.println("2. Inch to Feet");
                  System.out.println("Please enter Your Choice : ");

                  String fi = scanner.next();

                  switch (fi) {
                    case "1":
                      System.out.println("Please enter Feet: ");
                      double feet = scanner.nextDouble();
                      System.out.println(feet * 12);
                      break;

                    case "2":
                      System.out.println("Please enter Inch: ");
                      double inch = scanner.nextDouble();
                      System.out.println(inch / 12);
                      break;
                  }
                  break;

                case "5":
                  System.out.println("For Ax2 + Bx + C: Please input A B C:");
                  double a = scanner.nextDouble();
                  double b = scanner.nextDouble();
                  double c = scanner.nextDouble();

                  double d = b * b - 4 * a * c;
                  if(d > 0) {
                      System.out.println("Roots are real and unequal");
                      double root1 = (-b + Math.sqrt(d)) / (a * 2);
                      double root2 = (-b - Math.sqrt(d)) / (a * 2);
                      System.out.println("First root:" + root1);
                      System.out.println("Second root:" + root2);
                  } else if(d == 0) {
                      System.out.println("Roots are real and equal");
                      double root1 = (-b + Math.sqrt(d)) / (a * 2);
                      System.out.println("Root:"+root1);
                  } else {
                      System.out.println("Roots are imaginary");
                  }
                  break;

                case "6":
                    keep = false;
              }
          } while (keep);

    }
}
