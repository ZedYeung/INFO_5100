import java.util.*;

class MinMoves {
    public static int minMoves(int[] nums){ // score 7
      	int min = nums[0];
      	int sum = 0;
      	int result = 0;
          for (int i=0; i<nums.length; i++) {
          	sum += nums[i];
              if (nums[i] < min) {
          	    min = nums[i];
              }

          }
          result = sum - min * nums.length;
          return result;
      }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(minMoves(a));
    }
}
