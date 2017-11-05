public class GroupOfCards {
  private Card[] cards;
  private int currentSize=0;

  public GroupOfCards(int number) {
    this.cards = new Card[number];
  }

  public int getCurrentSize() {
    return this.currentSize;
  }

  public Card getCard(int i) {
    return this.cards[i];
  }

  public void addCard(Card card) {
    this.cards[currentSize] = card;
    this.currentSize += 1;
  }

  public Card removeCard(int index) {
    Card card = this.cards[index];

    for (int i = index; i < this.getCurrentSize()-1; i++) {
				this.cards[i] = this.cards[i+1];
		}

		this.cards[this.getCurrentSize()-1] = null;
    this.currentSize -= 1;

    return card;
  }

  public void display() {
    for (Card card: this.cards) {
      card.display();
    }
  }
}
