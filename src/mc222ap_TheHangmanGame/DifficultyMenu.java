package mc222ap_TheHangmanGame;

import java.io.File;
import java.util.Scanner;

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

    private Word getWord()
    {

        return new Word();
    }

    String readOption()
    {
        Scanner optionScanner = new Scanner(System.in);
        String answer = optionScanner.next();

        if (answer.equals(easyOption))
        {
            File easyFile = new File("documentation/easyWordFile.txt");

            return theWord.pickWord(easyFile);
        } else if (answer.equals(mediumOption))
        {
            File mediumFile = new File("documentation/medWordFile.txt");
            return theWord.pickWord(mediumFile);
        } else if (answer.equals(hardOption))
        {
            File hardFile = new File("documentation/hardWordFile.txt");
            return theWord.pickWord(hardFile);
        }
        optionScanner.close();
        return "";
    }
}
