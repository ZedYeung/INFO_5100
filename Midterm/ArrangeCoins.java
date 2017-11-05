public class ArrangeCoins {
    public static int arrangeCoins(int n) { // score 5, for input 1; expected output is 1; your output is 0
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
