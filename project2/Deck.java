public class Deck extends GroupOfCards {
  int TOTAL_CARDS = 52;

  public Deck() {
    super(TOTAL_CARDS);
    for (int i=0; i<=3; i++) {
      for (int j=0; j<=14; j++) {
        this.cards.addCard(new Card(i, j));
      }
    }
  }

  public void suffle() {
    for (int unshuffled = this.cards.getCurrentSize(); i>1; i--) {
      int index = (int)(Math.random() * unshuffled);
      Card card = this.cards.removeCard(index);
      this.cards.addCard(card);      
    }
  }

  public Card dealCard() {
    return this.cards.removeCard(0);
  }
}
