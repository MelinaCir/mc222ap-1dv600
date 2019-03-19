package mc222ap_TheHangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {

    private ArrayList<String> wordList = new ArrayList<>();
    private Scanner wordScanner;
    private String wordToGuess;
    private File file;

    public Word()
    {
    }

    public Word(String difficulty)
    {

    }

    public String getWordToGuess()
    {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess)
    {
        this.wordToGuess = wordToGuess;
    }

    public String pickWord(File fileToScan)
    {
        try
        {
            wordScanner = new Scanner(fileToScan);
        } catch (
                FileNotFoundException e)
        {
            System.out.println("File could not be read!");
        }

        while (wordScanner.hasNext())
        {
            String word = wordScanner.nextLine();

            wordList.add(word);
        }
        wordScanner.close();

        return wordList.get((int) (Math.random() * wordList.size()));
    }
}
