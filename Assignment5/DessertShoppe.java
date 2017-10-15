import java.lang.*;
import java.math.BigDecimal;

public class DessertShoppe {
  String name;
  double taxRate;
  int nameMaxSize;
  int receiptWidth;

  public DessertShoppe(String name, double taxRate, int nameMaxSize, int receiptWidth) {
    this.name = name;
    this.taxRate = taxRate;
    this.nameMaxSize = nameMaxSize;
    this.receiptWidth = receiptWidth;
  }

  public double cents2dollarsAndCentsmethod(int cents) {
    BigDecimal b = new BigDecimal(cents / 100.0);
    double dollar = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    return dollar;
  }
}
