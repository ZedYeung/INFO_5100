public class Deck extends GroupOfCards {
  int TOTAL_CARDS = 52;

  public Deck() {
    super(52);
    for (int i=0; i<=3; i++) {
      for (int j=2; j<=14; j++) {
        this.addCard(new Card(j, i));
      }
    }
  }

  public void shuffle() {
    for (int unshuffled = this.getCurrentSize() - 1; unshuffled>1; unshuffled--) {
      int index = (int)(Math.random() * unshuffled);
      Card card = this.removeCard(index);
      this.addCard(card);
    }
  }

  public Card dealCard() {
    return this.removeCard(0);
  }
}
