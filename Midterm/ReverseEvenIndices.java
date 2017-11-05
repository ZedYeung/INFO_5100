import java.util.*;

public class ReverseEvenIndices { // score 6
    public static int[] reverseEvenIndices(int[] nums) {
      int length = nums.length;
      int r = length % 2;
      int temp;
      for (int i=0; i<length/2; i+=2) {
    	temp = nums[i];
        nums[i] = nums[length - i - 2 + r];
        nums[length - i - 2 + r] = temp;
      }

      return nums;
    }

    public static void main(String[] args) {
    	int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(reverseEvenIndices(a)));
    }
}
