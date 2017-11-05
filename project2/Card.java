public class Card {
    private int suit;
    private int num;

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
        String suits = new String();
        String cards = new String();

        switch (this.suit) {
           case 3:
             suits = "Spades";
             break;
           case 2:
             suits = "Hearts";
             break;
           case 1:
             suits = "Diamonds";
             break;
           case 0:
             suits = "Clubs";
             break;
       }

        switch (this.num) {
           case 11:
             cards =  "Jack";
             break;
           case 12:
             cards =  "Queen";
             break;
           case 13:
             cards =  "King";
             break;
           case 14:
             cards =  "Ace";
             break;
           default:
             cards = Integer.toString(this.num);
        }

        System.out.println(cards + " of " + suits);
    }
}
