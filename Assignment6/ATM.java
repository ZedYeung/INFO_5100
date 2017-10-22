import java.io.*;
import java.util.*;

public class ATM {
double availableAmountInMachine;
double transactionFee;
HashMap<String, UserData> userData;
Scanner scanner = new Scanner(System.in);

private int count = 10000000;

public ATM() {
		  this.availableAmountInMachine = 0;
		  this.transactionFee = 0;
		  this.userData = new HashMap<String, UserData>();
}

public void createNewAccount() {
			String bankAccoutNumber = Integer.toString(this.count);
			this.count += 1;
			System.out.printf("Your bank accouont number is %s\n", bankAccoutNumber);

			System.out.println("Please input your new password");
			String newPassword = this.scanner.next();

			System.out.println("Please input your full name:");
			String name = this.scanner.next();

			System.out.println("Please input your age:");
			int age = this.scanner.nextInt();

			System.out.println("Please input your address:");
			String address = this.scanner.next();

			System.out.println("Please input your phoneNumber:");
			String phoneNumber = this.scanner.next();

			User user = new User(name, age, address, phoneNumber, bankAccoutNumber);

			UserData userData = new UserData(newPassword, user);

			this.userData.put(bankAccoutNumber, userData);

			System.out.println("Input 1 to go back login interface");
			String enter = this.scanner.next();
			main(null);
}

public void availableBalance(UserData userData) {
		  System.out.printf("Your available balance is %s\n", Double.toString(userData.availableBalance));
}

public UserData deposit(UserData userData, double amount) {
		  userData.availableBalance += amount;
			this.availableAmountInMachine += amount;
			userData.hisrotyTransactions.add(String.format("deposit - %s", amount));
			return userData;
}

public UserData withdraw(UserData userData, double amount) {
		  if(amount > this.availableAmountInMachine) {
						System.out.printf("Sorry, the ATM only have: %s\n", this.availableAmountInMachine);

		  } else if (amount > userData.availableBalance){
					 System.out.printf("Your account only have: %s\n", Double.toString(userData.availableBalance));
		  } else {
					 userData.availableBalance -= amount;
					 this.availableAmountInMachine -= amount;
					 userData.hisrotyTransactions.add(String.format("withDrawal - %s", amount));
			}
			return userData;
}

public void recentTransactions(UserData userData) {
	LinkedList<String> hisrotyTransactions = userData.hisrotyTransactions;
	List<String> recentTransactions = new LinkedList<String>();
	if (hisrotyTransactions.size() > 10) {
		recentTransactions = hisrotyTransactions.subList(0, 10);
	} else {
		recentTransactions = hisrotyTransactions;
	}
	for (String s: recentTransactions) {
		System.out.println(s);
	}
}

public UserData changePassword(UserData userData) {
	System.out.println("Please input your new password");
	String newPassword = this.scanner.next();
	userData.password = newPassword;
	return userData;
}

public void main(String[] args) {
	System.out.print("\033[H\033[2J");
  System.out.flush();

	System.out.println("Are you a new user?");
	System.out.println("1. yes, I am a new user");
	System.out.println("2. no, I am a current user");

	boolean passwordNotTrue = true;
	int choice1 = this.scanner.nextInt();

	if (choice1 == 1) {
			  createNewAccount();
	} else if (choice1 == 2) {
			  System.out.println("Please input your bank account nubmer:");
			  String bankAccoutNumber = this.scanner.next();
			  if (this.userData.get(bankAccoutNumber) != null) {
						 UserData userData = this.userData.get(bankAccoutNumber);
						 while (passwordNotTrue) {
									System.out.println("Please input your bank account password:");
									String password = this.scanner.next();
									if (password.equals(userData.password)) {
												System.out.println("Login successfully");
												boolean exit = false;
												while (!exit) {
												  System.out.println("1.availableBalance");
												  System.out.println("2.withDrawal");
												  System.out.println("3.deposit");
												  System.out.println("4.recentTransactions");
												  System.out.println("5.changePassword");
												  System.out.println("6.exit");
												  int choice2 = this.scanner.nextInt();
												  switch(choice2) {
												  case 1:
															 availableBalance(userData);
															 break;
												  case 2:
															 System.out.println("WithDrawal amount:");
															 double withdrawAmount = this.scanner.nextDouble();
															 userData = withdraw(userData, withdrawAmount);
															 break;
												  case 3:
															 System.out.println("Deposit amount:");
															 double depositAmount = this.scanner.nextDouble();
															 userData = deposit(userData, depositAmount);
															 break;
												  case 4:
															 recentTransactions(userData);
															 break;
												  case 5:
															 userData = changePassword(userData);
															 break;
												  case 6:
															 System.exit(0);
												  }
													this.userData.put(bankAccoutNumber, userData);
												}
									} else {
											  System.out.println("wrong password");
											  System.out.println("1. input password again");
											  System.out.println("2. forget password");
											  int choice3 = this.scanner.nextInt();
											  if (choice3 == 2) {
													User user = userData.user;

													System.out.println("Please input your name:");
												 	String name = this.scanner.next();

													System.out.println("Please input your age:");
													int age = this.scanner.nextInt();

													System.out.println("Please input your phoneNumber");
													String phoneNumber = this.scanner.next();

													if (name == user.name && age == user.age && phoneNumber == user.phoneNumber) {
														userData = changePassword(userData);
														this.userData.put(bankAccoutNumber, userData);
													} else {
														System.exit(0);
													}
											  }
									}
						 }
			  } else {
					System.out.println("Account number not exist!");
				}
	}
}

}
