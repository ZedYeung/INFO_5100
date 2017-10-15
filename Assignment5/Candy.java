class Candy extends DessertItem {
  double weight;
  int pricePerPound;

  public Candy(String name, double weight, int pricePerPound) {
    this.name = name;
    this.weight = weight;
    this.pricePerPound = pricePerPound;
  }

  public int getCost() {
    return (int) Math.round(weight * pricePerPound);
  }
}
