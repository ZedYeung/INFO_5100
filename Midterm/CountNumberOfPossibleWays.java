import java.util.Arrays;

public class CountNumberOfPossibleWays { // score 10
  public static int countNumberOfPossibleWays(int m, int n, int x) {
    int max = n * m;
    int result;
    if (x < 1 || x > max) {
      result = 0;
    } else {
      int count[][] = new int[n+1][x+1];
      for (int j=1; j<=m && j<= x; j++) {
        count[1][j] = 1;
      }

      for (int i=2; i<=n; i++) {
        for (int j=1; j<=x; j++) {
          for (int k=1; k<=m && k<j; k++) {
            count[i][j] += count[i-1][j-k];
          }
        }
      }
      result = count[n][x];

    }
    return result;
  }

  public static void main(String[] args) {
      System.out.println(countNumberOfPossibleWays(6, 2, 10));
  }
}
