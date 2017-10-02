public class RemoveVowelsFromString {
  public static String removeVowelsFromString(String str) {
          return str.replaceAll("[AaEeIiOoUu]", "");
  }
  public static void main(String[] args) {
          String string = removeVowelsFromString("abcdefghIOUiou");
          System.out.println(string);
  }
}
