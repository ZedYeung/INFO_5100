import java.util.*;
import java.io.*;


public class LyricAnalyzer {
   private HashMap<String, ArrayList<Integer>> map;

   public LyricAnalyzer() {
     this.map = new HashMap<String, ArrayList<Integer>>();
   }

   public void read(File file) throws IOException {
     FileReader reader = new FileReader(file);
     BufferReader br = new BufferReader(reader);
     StringBuilder sb = new StringBuilder();

     String line;

     while (true) {
       line = br.readLine();
       if (line == null) {
         break;
       }
       String[] lyrics = line.toLowerCase().split(" ");
       for (int i=0; i < lyrics.length(); i++) {
         if (i == lyrics.length() - 1) {
           add(lyrics[i], -(i+1));
         } else {
           add(lyrics[i], (i+1));
         }
       }
     }
     br.close();
     reader.close();
   }

   private void add(String lyricWord, int wordPosition) {
     if (!map.containKey(lyricWord)) {
       ArrayList<Integer> wordPos = new ArrayList();
       wordPos.add(wordPosition);
       map.put(lyricWord, wordPosition);
     } else {
       map.get(lyricWord).add(wordPosition);
     }
   }

   public void displayWords() {
     System.out.println("Word          Word Position(s)");
     System.out.println("==============================");

     String[] words = new String[map.size()];
     map.keySet().toArray(words);
     Arrays.sort(words);

     for (String w: words) {
 			System.out.print(w);
 			int spaceLength = 14 - word.length();
 			for (int i = 0; i < spaceLength; i++)
 				System.out.print(" ");
 			System.out.println(map.get(w).toString());
 		}
   }

   public void writeLyrics(File file) throws IOException {
     FileWriter writer = new FileWriter(file);
     String[] words = new Sting[map.size()];k
     for (String s: map.keySet()) {
       for (Integer i: map.get(s)) {
         if (i > 0) {

         }
       }
     }

   }

   public int count() {
     return map.size();
   }

   public String mostFrequentWord() {
     int count = 0;
     String str = "";
      for (String s : map.keySet()) {
          if (map.get(s).size() > count) {
              count = map.get(s).size();
              str = s;
          }
      }
      return str;
   }
}
