import java.io.*;
import java.util.*;

public class ATM {
   double availableAmountInMachine;
   double transactionFee;
   HashMap<User, Tuple2<User, String>> userData;

   public ATM() {
     this.availableAmountInMachine = 0;
     this.transactionFee = 0;
     this.userData = new HashMap<User, Tuple2<User, String>>();
   }

   Scanner scanner = new Scanner(System.in);
   System.out.println("Are you a new user?");
   System.out.println("1. yes, I am a new user");
   System.out.println("2. no, I am a current user");

   int choice1 = scanner.next();

   public login(String bankAccoutNumber, String password) {

   }
   if (choice1 == 1) {
     createNewAccount();
   } else if (choice1 == 2) {
     System.out.println("Please input your bank account nubmer:");
     String bankAccoutNumber = scanner.nextline();
     if (this.userData.get(bankAccoutNumber) != null) {
       while (passwordNotTrue) {
       System.out.println("Please input your bank account password:");
       String password = scanner.nextLine();
       if (password.equals(this.userData.get(bankAccoutNumber)[1])) {
         System.out.println("Login successfully");
         System.out.println("1.availableBalance");
         System.out.println("2.withDrawal");
         System.out.println("3.deposit");
         System.out.println("4.recentTransactions");
         System.out.println("5.changePassword");
         System.out.println("6.exit");
         int choice2 = scanner.next();
         switch(choice2) {
           case 1:
             availableBalance();
             break;
           case 2:
             withDrawal();
             break;
           case 3:
             deposit();
             break;
           case 4:
             recentTransactions();
             break;
           case 5:
             changePassword();
             break();
           case 6:
             exit();
         }
         passwordNotTrue = False;
       } else {
         System.out.println("wrong password");
         System.out.println("1. input password again");
         System.out.println("2. forget password");
         int choice2 = scanner.next();
         if (choice2 == 2) {
           resetPassword();
         }
       }
     }
     }
   }

   public boolean newUser() {

   }
   userData.put()

   public CheckingAccount(int number)
   {
      this.number = number;
   }
  //方法：存钱
   public void deposit(double amount)
   {
      balance += amount;
   }
  //方法：取钱
   public void withdraw(double amount) throws
                              InsufficientFundsException
   {
      if(amount <= balance)
      {
         balance -= amount;
      }
      else
      {
         double needs = amount - balance;
         throw new InsufficientFundsException(needs);
      }
   }
  //方法：返回余额
   public double getBalance()
   {
      return balance;
   }
  //方法：返回卡号
   public int getNumber()
   {
      return number;
   }
}
