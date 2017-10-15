import java.util.*;

public class MatrixSpiralOrder {
  public static List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> matrixSpiralOrder = new ArrayList<Integer>();
      int m = matrix.length;
      int n = matrix[0].length;

      int i = 0;
      int j = 0;
      int k = 0;

      while (i < m && j < n) {
          for (k = 0; k < n; k++) {
              matrixSpiralOrder.add(matrix[i][k]);
          }
          i++;

          for (k = i; k < m; k++) {
              matrixSpiralOrder.add(matrix[k][n-1]);
          }
          n--;

          if (i < m) {
              for (k = n-1; k >= 0; k--) {
                  matrixSpiralOrder.add(matrix[m-1][k]);
              }
              m--;
          }

          if (j < n) {
              for (k = m-1; k > i; k--) {
                  matrixSpiralOrder.add(matrix[k][j]);
              }
              j++;
          }
      }
      return matrixSpiralOrder;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},
                      {4,5,6},
                      {7,8,9}};
    System.out.println(spiralOrder(matrix));
  }
}
