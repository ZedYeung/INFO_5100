public class ReverseHello extends Thread{ // score 2
  private int n;

  public ReverseHello(int n) {
    this.n = n;
  }

  @Override
  public void run() {
    n++;

    if (n<51) {
      ReverseHello ts = new ReverseHello(n);
      ts.start();

      try{
          ts.join();
          System.out.println("Hello from " + n + "!");
      } catch (Exception e){
          System.out.println(e);
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ReverseHello ts = new ReverseHello(0);
    ts.start();
  }
}
