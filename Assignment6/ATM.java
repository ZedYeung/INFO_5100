import java.io.*;
import java.util.*;

public class ATM {
double availableAmountInMachine;
double transactionFee;
HashMap<String, ArrayList<Object>> userData;

public ATM() {
		  this.availableAmountInMachine = 0;
		  this.transactionFee = 0;
		  this.userData = new HashMap<String, ArrayList<Object>>();
}


Scanner scanner = new Scanner(System.in);
System.out.println("Are you a new user?");
System.out.println("1. yes, I am a new user");
System.out.println("2. no, I am a current user");

int choice1 = scanner.next();

if (choice1 == 1) {
		  createNewAccount();
} else if (choice1 == 2) {
		  System.out.println("Please input your bank account nubmer:");
		  String bankAccoutNumber = scanner.nextline();
		  if (this.userData.get(bankAccoutNumber) != null) {
					 User user = this.userData.get(bankAccoutNumber);
					 while (passwordNotTrue) {
								System.out.println("Please input your bank account password:");
								String password = scanner.nextLine();
								if (password.equals(user.get(0))) {
											boolean exit = False;
											while (!exit) {
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
														 availableBalance(user, amount);
														 break;
											  case 2:
														 withDrawal(user, amount);
														 break;
											  case 3:
														 deposit(user, amount);
														 break;
											  case 4:
														 recentTransactions(user);
														 break;
											  case 5:
														 changePassword(user);
														 break;
											  case 6:
														 System.exit(0);
											  }
												this.userData.put(bankAccoutNumber, user)
											}
								} else {
										  System.out.println("wrong password");
										  System.out.println("1. input password again");
										  System.out.println("2. forget password");
										  int choice3 = scanner.next();
										  if (choice3 == 2) {
												User userInfo = user.get(1);
												System.out.println("Please input your name:");
											 	String name = scanner.next();
												System.out.println("Please input your age:");
												int age = scanner.next();
												System.out.println("Please input your phoneNumber");
												String phoneNumber = scanner.next();
												if (name == userInfo.name && age == userInfo.age && phoneNumber == userInfo.phoneNumber) {
													System.out.println("Please input your new password");
													String newPassword = scanner.next();
													changePassword(user, newPassword);
												} else {
													System.exit(0);
												}
										  }
								}
					 }
		  }
}

public double availableBalance(ArrayList user) {
		  return user.get(2);
}

public void deposit(ArrayList user, double amount) {
		  user.set(2) =  user.get(2) + amount;
			this.availableAmountInMachine += amount;
			user.get(3).add(String.format("deposit - %s", amount));
}

public void withdraw(ArrayList user, double amount) {
		  if(amount > this.availableAmountInMachine) {
						Systme.out.printf("Sorry, the ATM only have: %s\n", this.availableAmountInMachine);

		  } else if (amount > user.get(2)){
					 System.out.println("Your account only have: %s\n", user.get(2))
		  } else {
				   user.set(2) = user.get(2) - amount;
					 this.availableAmountInMachine -= amount;
					 user.get(3).add(String.format("withDrawal - %s", amount));
			}
}

public String recentTransactions(ArrayList user) {
	LinkedList transactions = user.get(3);
	List<String> recentTransactions = transactions.subList(0, 10);
	for (String s: recentTransactions) {
		System.out.println(s);
	}
}

public void changePassword(ArrayList user, String password) {
	usr.set(1) = password;
}

}
