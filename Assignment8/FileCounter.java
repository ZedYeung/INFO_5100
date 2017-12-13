import java.io.IOException;
import java.util.*;

public class FileCounter{ // score 3

   private int characterCount, wordCount, lineCount;

   public FileCounter(){
     this.characterCount = 0;
     this.wordCount = 0;
     this.lineCount = 0;
   }

   public int getCharacterCount() {
      return characterCount;
   }

   public int getLineCount() {
      return lineCount;
   }

   public int getWordCount() {
      return wordCount;
   }

   /**
      Processes an input source and adds its character, word, and line
      counts to the respective variables.
      @param in the scanner to process
   */
   public void read(Scanner in) throws IOException {
     StringBuilder sb = new StringBuilder();
     while (in.hasNextLine()) {
       sb.append(in.nextLine());
       sb.append(" ");
       lineCount += 1;
     }

     String s = sb.toString().trim();
     if (s.length() > 0) {
       for(int i = 0; i < s.length(); i++){
         if (s.charAt(i) != ' ') {
           characterCount += 1;
         } else {
           wordCount += 1;
         }
       }
     }
   }
}
