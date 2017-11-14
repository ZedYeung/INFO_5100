class IntToRoman { // score 2
  public static String intToRoman(int num) {
      if (num < 1 || num > 3999) {
        System.out.println("Only number between 1 and 3999!");
      }
      String [] thousand = {"", "M", "MM", "MMM"};
      String [] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
      String [] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
      String [] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
      return thousand[num / 1000] + hundred[(num / 100) % 10] + ten[(num / 10) % 10] + one[num % 10];
  }

  public static void main(String[] args) {
      System.out.println(intToRoman(3999));
  }
}
