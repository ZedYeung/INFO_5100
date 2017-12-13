import java.util.*;

public class MaxValue extends Thread { // score 2
  private int lo, hi;
  private int[] arr;
  private int maxValue = Integer.MIN_VALUE;

  public MaxValue(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }

  @Override
  public void run() {

    for (int i=lo; i<hi; i++) {
      if(arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }
  }

  public static int findMax(int[] arr) throws InterruptedException {
    int len = arr.length;
    int maxValue = Integer.MIN_VALUE;

    // Create and start 4 threads.
    MaxValue[] ts = new MaxValue[4];

    for (int i=0; i<4; i++) {
      ts[i] = new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
      ts[i].start();
    }

    // Wait for the threads to finish and find the max value from their results.
    for (int i=0; i<4; i++) {
      ts[i].join();
      if (ts[i].maxValue > maxValue) {
        maxValue = ts[i].maxValue;
      }
    }
    return maxValue;

  }

  public static void main(String[] args) throws InterruptedException {
        Random rd = new Random();
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1000);
        }
        int maxValue = findMax(arr);
        System.out.println("Max: " + maxValue);
    }
}
