public class GroupOfCards {
  Card[] cards;
  int currentSize=0;

  public GroupOfCards(int number) {
    this.cards = new Card[number];
  }

  public int getCurrentSize() {
    return this.currentSize;
  }

  public Card getCard(int i) {
    return this.cards[i]；
  }

  public void addCard(Card card) {
    this.cards.add(card);
    this.currentSize += 1;
  }

  public Card removeCard(int index) {
    this.currentSize -= 1;

    return this.cards.remove(index);
  }

  public void display() {
    for (Card card: this.cards) {
      card.display();
    }
  }
}
