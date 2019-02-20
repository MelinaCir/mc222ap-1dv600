package mc222ap_TheHangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {

    private ArrayList<String> wordList = new ArrayList<>();
    private Scanner wordScanner;
    private String wordToGuess;

    public Words(){

        getWord();
    }

    private void getWord() {
        try {
            wordScanner = new Scanner(new File("/Users/melinacirverius/java_kurser/mc222ap-1dv600/wordfile.txt"));

        } catch (
                FileNotFoundException e) {
            System.out.println("File could not be read!");
        }

        while (wordScanner.hasNext()) {
            String word = wordScanner.nextLine();

            wordList.add(word);
        }
        wordScanner.close();

        wordToGuess = wordList.get((int) (Math.random() * wordList.size()));

//        for (int i = 0; i < selectedWord.length(); i++) {
//            letterList.add(String.valueOf(selectedWord.charAt(i)));
//            underscores.add("_ ");
//        }
    }

//        private String getUnderscores(final ArrayList<String> list) {
//            return list.toString()
//                    .replace(",", "")
//                    .replace("[", "")
//                    .replace("]", "");
//        }


    public String getWordToGuess() {
        return wordToGuess;
    }
}
