import java.util.*;

class UserData {
  String password;
  User user;
  double availableBalance;
  LinkedList<String> hisrotyTransactions;

  public UserData(String password, User user) {
    this.password = password;
    this.user = user;
    this.availableBalance = 0;
    this.hisrotyTransactions = new LinkedList<String>();
  }
}
