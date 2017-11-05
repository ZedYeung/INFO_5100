public class Deck extends GroupOfCards {
  int TOTAL_CARDS = 52;

  public Deck() {
    super(TOTAL_CARDS);
  }

  public void suffle() {
    for (int unshuffled = this.cards.getCurrentSize(); i>1; i--) {
      int index = (int)(Math.random() * unshuffled);
      Card card = this.cards.removeCard(index);
      this.cards.addCard(card);      
    }
  }

  public Card dealCard() {
    return this.cards.remove(0);
  }
}
