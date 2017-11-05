public class Game {
  final int PLAYERS;
  private Deck deck;
  private Hand[] players;
  private Trick[] tricks;
  private int numberOfTricks = 0;
  private boolean hearts = false;
  private boolean queenOfSpades = false;

  public Game(int numberOfPlayers) {
    this.PLAYERS = numberOfPlayers;
    this.players = new Hand[] (numberOfPlayers);
    for (int i=0; i< numberOfPlayers; i++) {
      this.players[0] = new Hand(52/this.PLAYERS, this.PLAYERS);
    }
    this.tricks = new Trick[] (this.PLAYERS);
  }

  public int getNumberOfTricks() {
    return this.tricks.length;
  }

  public boolean getHearts() {
    return this.hearts;
  }

  public boolean getQueenOfSpades() {
    return this.queenOfSpades;
  }

  public void playAGame() {
    int cardsLeft = 52% this.PLAYERS;
  }

  public void updateHeartsAndQueen(Card card) {

  }

  private int computePoints(int playerNum) {

  }

}
