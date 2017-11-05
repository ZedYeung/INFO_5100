public class Hand extends GroupOfCards {
  final int NUM;
  private int shortest = 0;

  public Hand(int playerNum, int numberOfCards) {
    super(numberOfCards);
    this.NUM = playerNum;
  }

  public void sort() {
    for (int unsorted=this.cards.getCurrentSize() - 1; unsorted>1; unsorted--) {
      int max_idx = unsorted;
      for (int j=unsorted-1; j >= 0; j--)
          if (this.cards[j].getSuit() * 13 + this.cards[j].getNum() > this.cards[max_idx].getSuit() * 13 + this.cards[max_idx].getNum())
              max_idx = j;

          int temp = this.cards[max_idx];
          this.cards[max_idx] = this.cards[unsorted];
          this.cards[unsorted] = temp;
    }
  }

  public void setShortest() {
    if (findCount(1) <= findCount(0)) {
      this.shortest = 1;
    }

    if (findCount(3) <= findCount(1) && findCount(3) <= findCount(0)) {
      if (find(12,3)<0 && find(13,3)<0 && find(14,3)<0) {
        this.shortest = 3;
      }
    }
  }

  public void getShortest() {
    return this.shortest;
  }

  public Card playACard(Game game, Trick trick) {
    int index;
    if (trick.getCurrentSize() == 0) {
      index = findHighest(this.getShortest());
    } else if (trick.getCurrentSize() == game.PLAYERS - 1) {
      if (find(12,3)<0 && !trick.getHearts())
        index = findHighest();
    } else if ((trick.getCurrentSize() == game.PLAYERS - 1)
      && !trick.getHearts() && !trick.getQueen()
      && (index = findLastHigh(suit)) >= 0);
      else if ((index = findHighestBelow(winningCard)) >= 0);
      else if ((index = findMiddleHigh(game, suit)) >= 0);
      else if ((index = find(12, 3)) >= 0); // queen of Spades
      else if ((index = find(14, 3)) >= 0); // Ace of Spades
      else if ((index = find(13, 3)) >= 0); // King of Spades
      else if ((index = findHighest(2)) >= 0); // heart
      else
      {
        index = findHighest();
      }

      trick.update(this.NUM, this.cards[index]);
      game.updateHeartsAndQueen(this.cards[index]);

      return this.cards.removeCard(index);
  }

  public int findLowest(int suit) {
    for (int i=0; i<this.cards.getCurrentSize(); i++) {
      if (this.cards.getCard(i).getSuit()==suit) {
        return this.cards.getCard(i);
      }
      return -1;
    }
  }

  private int findCount(int suit) {
    int count = 0;
    for (int i=0; i<this.cards.length-1; i++) {
      if (this.cards[i].getSuit()==suit) {
        count +=1;
      }
    return count;
  }

  private int find(int num, int suit) {
    for (int i=0; i<this.cards.getCurrentSize(); i++) {
      if (this.cards[i].getSuit()==suit && this.cards[i].getNum()==num) {
        return i;
      }
      return -1;
  }

  private int findHighest(int suit) {
    if (suit==3)  {
      return this.cards[this.cards.length -1];
    } else {
      for (int i=0; i<this.cards.length-1; i++) {
        if (this.cards[i+1].getSuit()==suit+1 && this.cards[i].getSuit()==suit) {
          return this.cards[i];
        }
        return -1;
    }
  }

  private int findLowest(Game game) {
    sort(this.cards);
    if (suit==0)  {
      return this.cards[0];
    } else {
      for (int i=0; i<this.cards.length-1; i++) {
        if (this.cards[i-1].getSuit()==suit-1 && this.cards[i].getSuit()==suit) {
          return this.cards[i];
        }
        return -1;
    }
  }

  private int findLastHigh(int suit) {
    if (suit != 3) {
      return findHighest(suit);
    } else {
      if (find(12, 3)) >= 0 && findCount(3) >1) {
        return this.cards[this.cards.length-2];
      }
    }
  }

  private int findHighestBelow(Card winningCard) {
    for (int i=0; i<this.cards.length-1; i++) {
      if (this.cards[i].getSuit()==winningCard.getSuit()) {
        if (this.cards[i].getNum()<=winningCard.getNum() && this.cards[i+1].getSuit() != this.cards[i].getSuit()) {
          return i
        }
      }
      return -1;
  }

  private int findMiddleHigh(Game game, int suit) {
    if (findHighestBelow() == -1) {
      if (suit==3 && !game.queenOfSpades()) {
        for (int i=0; i<this.cards.length-1; i++) {
          if (this.cards[i].getSuit()==3) {
            if ((this.cards[i].getNum()<=10) {
              return i
            }
          }
        }
      } else {
        return findHighest(suit);
      }
    }
  }

  private int findHighest() {
    return this.cards[this.cards.length-1];
  }
}
