class Sundae extends IceCream {
  int toppingCost;
  String iceCream;

  public Sundae(String iceCream, int cost, String sundae, int toppingCost) {
    super(iceCream, cost);
    this.iceCream = super.name;
    this.name = sundae;
    this.toppingCost = toppingCost;
  }

  public int getCost() {
    return super.cost + this.toppingCost;
  }
}
