import java.util.*;

public class CheckIfTwoStringsAreAnagrams { // score 2
  public static boolean checkIfTwoStringsAreAnagrams(String s1, String s2) {
       char[] str1 = s1.toCharArray();
       char[] str2 = s2.toCharArray();
       Arrays.sort(str1);
       Arrays.sort(str2);
       return Arrays.equals(str1, str2);
  }

  public static void main(String[] args) {
          System.out.println(checkIfTwoStringsAreAnagrams("aeiou", "ouiea"));
  }
}
