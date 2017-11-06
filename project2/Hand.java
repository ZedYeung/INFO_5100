public class Hand extends GroupOfCards {
  final int NUM;
  private int shortest = 0;

  public Hand(int playerNum, int numberOfCards) {
    super(numberOfCards);
    this.NUM = playerNum;
  }

  public void sort() {
    for (int unsorted=this.getCurrentSize() - 1; unsorted>=1; unsorted--) {
      int max_idx = unsorted;
      for (int j=unsorted-1; j >= 0; j--)
          if (this.getCard(j).getSuit() * 13 + this.getCard(j).getNum() > this.getCard(max_idx).getSuit() * 13 + this.getCard(max_idx).getNum()) {
            max_idx = j;
          }

          Card card = this.removeCard(max_idx);
          this.addCard(card);
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

  public int getShortest() {
    return this.shortest;
  }

  public Card playACard(Game game, Trick trick) {
    int index = 0;
    if ((trick.getCurrentSize() == 0) && (findCount(shortest) != 0)
				&& (index = this.findHighest(shortest)) >= 0);
    else if ((trick.getCurrentSize() == 0) && (this.findCount(shortest) == 0)
				&& (index = this.findLowest(game)) >= 0);
    else if ((trick.getCurrentSize() == game.PLAYERS - 1) && !trick.getQueen()
    && !trick.getHearts() && (index = findHighest(trick.getWinningCard().getSuit())) >= 0);
    else if ((trick.getCurrentSize() == game.PLAYERS - 1)
      && !trick.getHearts() && !trick.getQueen()
      && (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0);
    else if ((index = findHighestBelow(trick.getWinningCard())) >= 0);
    else if ((index = findMiddleHigh(game, trick.getWinningCard().getSuit())) >= 0);
    else if ((index = find(12, 3)) >= 0); // queen of Spades
    else if ((index = find(14, 3)) >= 0); // Ace of Spades
    else if ((index = find(13, 3)) >= 0); // King of Spades
    else if ((index = findHighest(2)) >= 0); // heart
    else
    {
      index = findHighest();
    }

    Card card = this.removeCard(index);

    trick.update(this.NUM, card);
    game.updateHeartsAndQueen(card);

    return card;
  }

  public int findLowest(int suit) {
    for (int i=0; i<this.getCurrentSize(); i++) {
      if (this.getCard(i).getSuit()==suit) {
        return i;
      }
    }
    return -1;
  }

  private int findCount(int suit) {
    int count = 0;
    for (int i=0; i<this.getCurrentSize()-1; i++) {
      if (this.getCard(i).getSuit()==suit) {
        count +=1;
      }
    }
    return count;
  }

  private int find(int num, int suit) {
    for (int i=0; i<this.getCurrentSize(); i++) {
      if (this.getCard(i).getSuit()==suit && this.getCard(i).getNum()==num) {
        return i;
      }
    }
    return -1;
  }

  private int findHighest(int suit) {
    if (suit==3)  {
      return this.getCurrentSize() -1;
    } else {
      for (int i=0; i<this.getCurrentSize()-1; i++) {
        if (this.getCard(i+1).getSuit()==suit+1 && this.getCard(i).getSuit()==suit) {
          return i;
        }
      }
      return -1;
    }
  }

  private int findLowest(Game game) {
    int lowest = 15;
    int index = -1;
    if (findCount(2)==this.getCurrentSize() && game.getHearts()==false) {
      return -1;
    }

    if (game.getHearts() == true) {
      return 0;
    } else {
      for (int i = 0; i < getCurrentSize(); i++) {
				if (this.getCard(i).getNum() < lowest && this.getCard(i).getSuit() != 2) {
					lowest = getCard(i).getNum();
					index = i;
        }
      }
      return index;
    }
  }

  private int findLastHigh(int suit) {
    if (suit != 3) {
      return findHighest(suit);
    } else {
      if (find(12, 3) >= 0 && findCount(3) >1) {
        return this.getCurrentSize()-2;
      }
    }
    return -1;
  }

  private int findHighestBelow(Card winningCard) {
    for (int i=0; i<this.getCurrentSize(); i++) {
      if (this.getCard(i).getSuit()==winningCard.getSuit()) {
        if (this.getCard(i).getNum()<=winningCard.getNum()) {
          if (i != this.getCurrentSize()-1) {
            if (this.getCard(i+1).getSuit() != this.getCard(i).getSuit()) {
              return -1;
            }
          }
          return i;
        }
      }
    }
    return -1;
  }

  private int findMiddleHigh(Game game, int suit) {
    if (suit==3 && !game.getQueenOfSpades()) {
      for (int i=0; i<this.getCurrentSize()-1; i++) {
        if (this.getCard(i).getSuit()==3) {
          if (this.getCard(i).getNum()<=10) {
            return i;
          }
        }
      }
    }
    return findHighest(suit);
  }

  private int findHighest() {
    return this.getCurrentSize()-1;
  }
}
