class Cookie extends DessertItem {
  int number;
  double pricePerDozen;

  public Cookie(String name, int number, int pricePerDozen) {
    this.name = name;
    this.number = number;
    this.pricePerDozen = pricePerDozen;
  }

  public int getCost() {
    return (int) Math.round(number * pricePerDozen / 12);
  }
}
