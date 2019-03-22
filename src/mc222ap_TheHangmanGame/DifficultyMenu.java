package mc222ap_TheHangmanGame;

import java.io.File;
import java.util.Scanner;

/**
 * Class DifficultyMenu creates a representation of a menu with difficulty choices.
 *
 * @author Melina Cirverius
 * @version 1.1
 */
public class DifficultyMenu {

    private String easyOption = "1";
    private String mediumOption = "2";
    private String hardOption = "3";
    private Word theWord = new Word();

    public DifficultyMenu()
    {
        displayMenu();
    }

    public void displayMenu()
    {
        System.out.println("Choose difficulty level:" + "\n1. Easy\n2. Medium\n3. Hard");
        getWord();
    }

    public String readOption()
    {
        final Scanner optionScanner = new Scanner(System.in);
        String answer = optionScanner.next();

        if (answer.equals(easyOption))
        {
            File easyFile = new File("src/files/easyWordFile.txt");
            return theWord.pickWord(easyFile);
        } else if (answer.equals(mediumOption))
        {
            File mediumFile = new File("src/files/medWordFile.txt");
            return theWord.pickWord(mediumFile);
        } else if (answer.equals(hardOption))
        {
            File hardFile = new File("src/files/hardWordFile.txt");
            return theWord.pickWord(hardFile);
        } else
        {
            System.out.println("\nInvalid menu choice. Please pick a valid number.");
            return readOption();
        }
    }

    private Word getWord()
    {
        return new Word();
    }
}
