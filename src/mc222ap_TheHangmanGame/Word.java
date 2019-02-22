package mc222ap_TheHangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {

    private ArrayList<String> wordList = new ArrayList<>();
    private Scanner wordScanner;
    private String wordToGuess;

    public Word() {

        pickWord();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    private void pickWord() {
        try {
            wordScanner = new Scanner(new File("/Users/melinacirverius/java_kurser/mc222ap-1dv600/documentation/wordfile.txt"));
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
    }
}
