import java.util.*;
import java.lang.*;
import java.math.BigDecimal;
// import DessertShoppe;

public class Checkout {
  Vector <DessertItem> dessertItemList;
  DessertShoppe shop = new DessertShoppe("Xi'Wa", 0.1, 25, 10);;

  public Checkout() {
    this.dessertItemList = new Vector<DessertItem>();
  }

  public int numberOfItems() {
    return this.dessertItemList.size();
  }

  public void enterItem(DessertItem item) {
      this.dessertItemList.addElement(item);
  }

  public void clear() {
    this.dessertItemList.setSize(0);
  }

  public int totalCost() {
    int totalCost = 0;
    for (DessertItem item: this.dessertItemList) {
      // DessertItem item = item;
      totalCost += item.getCost();
    }
    return totalCost;
  }

  public int totalTax() {
    int totalCost = totalCost();
    int totalTax = (int) Math.round(totalCost * this.shop.taxRate);
    return totalTax;
  }

  private String wrapText(String s) {
    StringBuilder sb = new StringBuilder(s);
    int i = 0;
    while (i + 20 < sb.length() && (i = sb.lastIndexOf(" ", i + this.shop.nameMaxSize)) != -1) {
        sb.replace(i, i + 1, "\n");
    }
    return sb.toString();
  }

  public String toString() {

    String receipt = String.format("            " + this.shop.name + " Dessert Shoppe\n" +
      "            -----------------------\n");
    for (DessertItem item: this.dessertItemList) {
      if (item instanceof IceCream) {
        if (item instanceof Sundae) {
          Sundae sundae = (Sundae) item;
          receipt += String.format("%-" + this.shop.nameMaxSize + "s%" + this.shop.receiptWidth + "s%n",
            wrapText(sundae.name + " Sundae with " + sundae.iceCream),
            this.shop.cents2dollarsAndCentsmethod(sundae.getCost()));
        } else {
        IceCream iceCream = (IceCream) item;
        receipt += String.format("%-" + this.shop.nameMaxSize + "s%" + this.shop.receiptWidth + "s%n",
          wrapText(iceCream.name), this.shop.cents2dollarsAndCentsmethod(iceCream.getCost()));
        }
      } else if(item instanceof Cookie) {
        Cookie cookie = (Cookie) item;
        receipt += String.format(cookie.number + " @ " + cookie.pricePerDozen + " /dz.\n");
        receipt += String.format("%-" + this.shop.nameMaxSize + "s%" + this.shop.receiptWidth + "s%n",
          wrapText(cookie.name), this.shop.cents2dollarsAndCentsmethod(cookie.getCost()));
      } else if(item instanceof Candy) {
        Candy candy = (Candy) item;
        receipt += String.format(candy.weight + " @ " + candy.pricePerPound + " /lb.\n");
        receipt += String.format("%-" + this.shop.nameMaxSize + "s%" + this.shop.receiptWidth + "s%n",
          wrapText(candy.name), this.shop.cents2dollarsAndCentsmethod(candy.getCost()));
      }
    }
    receipt += "\n";
    receipt += String.format("%-" + this.shop.nameMaxSize + "s%" + this.shop.receiptWidth + "s%n",
      "Tax", this.shop.cents2dollarsAndCentsmethod(totalTax()));
    receipt += String.format("%-" + this.shop.nameMaxSize + "s%" + this.shop.receiptWidth + "s%n",
      "Total Cost", this.shop.cents2dollarsAndCentsmethod(totalCost() + totalTax()));
    return receipt;
  }
}
