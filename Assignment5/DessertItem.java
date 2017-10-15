abstract class DessertItem {
  String name;

  DessertItem() {

  }

  public DessertItem(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  abstract int getCost();
}
