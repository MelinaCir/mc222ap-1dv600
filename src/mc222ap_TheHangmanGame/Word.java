package mc222ap_TheHangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Word creates an instance representing a word.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class Word {

    private ArrayList<String> wordList = new ArrayList<>();
    private Scanner wordScanner;

    public Word()
    {
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
