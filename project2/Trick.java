public class Trick extends GroupOfCards {
  int winner;
  Card winningCard;
  boolean hearts = false;
  boolean queen = false;

  public Trick(int players) {
    super(players * 2  - 1);
  }

  public int getWinner() {
    return this.winner;
  }

  public Card getWinningCard() {
    return this.winningCard;
  }

  public boolean getHearts() {
    return this.hearts;
  }

  public boolean getQueen() {
    return this.queen;
  }

  public void update(int playerNum, Card card) {
    if (isWinner(card)) {
      this.winner = playerNum;
      this.winningCard = card;
    }

    if (card.getSuit() == 2) {
      this.hearts = true;
    }

    if (card.getSuit() == 3 && card.getNum() == 12) {
      this.queen = true;
    }
  }

  public boolean isWinner(Card card) {
    if (winningCard != null && card.getSuit()) {
      return false;
    } else if (card.getNum() < winningCard.getNum()) {
      return false;
    } else {
      return false;
    }
  }
}
