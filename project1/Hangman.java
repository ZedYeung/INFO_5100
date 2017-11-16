/* Good Work
 * Score 20
 */
import java.util.*;

public class Hangman {
  private ArrayList<String> words;
  private ArrayList<Character> correctList;
  private String word;
  private int incorrectGuesses;
  private Random randomGenerator = new Random();
  private Scanner scan = new Scanner(System.in);
  private ArrayList<String> hangmanPicture;

  public Hangman(ArrayList<String> words) {
    this.words = words;
    this.word = chooseWord(words);
    this.incorrectGuesses = 0;
    this.correctList = new ArrayList<Character>();
    for (int i = 0; i < this.word.length(); i++)
      this.correctList.add('-');
    this.hangmanPicture = new ArrayList<String>();
    this.hangmanPicture.add(" ----------\n");
    this.hangmanPicture.add("|         |\n");
    for (int j = 0; j < 7; j++) {
      this.hangmanPicture.add("|\n");
    }
    this.hangmanPicture.add(" ---------------\n");
  }

  public String chooseWord(ArrayList<String> words) {
    int index = this.randomGenerator.nextInt(words.size());
    String word = words.get(index);
    return word;
  }

  public void handleGuess(char guess) {
    if (this.word.indexOf(guess) >= 0) {
      System.out.println("Good job!");
      int idx = this.word.indexOf(guess);
      while (idx >= 0) {
        this.correctList.set(idx, guess);
        idx = this.word.indexOf(guess, idx+1);
      }

    } else {
      System.out.println("Bad luck.");
      this.incorrectGuesses += 1;
      switch(this.incorrectGuesses) {
        case 1:
          this.hangmanPicture.set(2, "|         O\n");
          break;
        case 2:
          this.hangmanPicture.set(3, "|         |\n");
          break;
        case 3:
          this.hangmanPicture.set(4, "|      --- \n");
          break;
        case 4:
          this.hangmanPicture.set(4, "|      --- ---\n");
          break;
        case 5:
          this.hangmanPicture.set(5, "|        /\n");
          this.hangmanPicture.set(6, "|       /\n");
          break;
        case 6:
          this.hangmanPicture.set(5, "|        /  \\\n");
          this.hangmanPicture.set(6, "|       /    \\\n");
          break;
        case 7:
          this.hangmanPicture.set(7, "|     --\n");
          break;
        case 8:
          this.hangmanPicture.set(7, "|     --      --\n");
          break;
      }
      printHangman();
    }
  }

  public <T> String listToString(ArrayList<T> correctList) {
    StringBuilder sb = new StringBuilder();
    for (T c: correctList) {
        sb.append(c);
    }
    return sb.toString();
  }

  public boolean gameWon() {
    return listToString(this.correctList).equals(this.word);
  }

  public void gameOver() {
    System.exit(0);
  }

  public void printHangman() {
    System.out.println(listToString(this.hangmanPicture));
  }

  public void displayWord(ArrayList<Character> correctList) {
      System.out.print(listToString(this.correctList));
  }

  public void playGame() {
    System.out.println("Welcome to Hangman Game!");
    while (this.incorrectGuesses < 8 && !gameWon()) {
      //Print Hangman picture
      printHangman();
			//Print the correct guesses in the secret word
      System.out.println("Here is your word:");
      displayWord(this.correctList);

			//Prompt and read the next guess
			System.out.print("\nEnter a lower-case letter as your guess: ");
			String guess = scan.nextLine();

			//Process the next guess
			handleGuess(guess.charAt(0));

      // Clear console
      System.out.print("\033[H\033[2J");
      System.out.flush();
		}

		// System.out.println("The secret word was: " + this.word);
		if (gameWon()) {
			System.out.println("Congratulations, you win!");
		} else {
			System.out.println("Oh, the poor guy was hanged.");
			printHangman();
		}

    gameOver();
  }

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<String> (Arrays.asList("computer", "science", "helicopter", "java",
      "truck", "opportunity", "candy", "token", "spiral", "cookie", "apple",
      "cake", "sundae", "pocket", "checkout", "arm", "carret", "character",
      "laptop", "amazon", "microsoft", "serendipity", "anticipate", "juvenile"));

    Hangman hangman = new Hangman(words);
    hangman.playGame();
  }
}
