public class ArrangeCoins {
    public static int arrangeCoins(int n) {
      int i = 0;
      int sum = 0;
      while (sum < n) {
    	  i++;
          sum += i;
      }
      return i - 1;
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
