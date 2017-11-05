public class Card {
    int suit;
    int num;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return this.num;
    }

    public int getSuit() {
        return this.suit;
    }

    public void display() {
        switch ( this.suit ) {
           case 3:   return "Spades";
           case 2:   return "Hearts";
           case 1: return "Diamonds";
           case 0:    return "Clubs";
       }

        switch ( this.value ) {
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           case 14:  return "Ace";
        }
    }
}
