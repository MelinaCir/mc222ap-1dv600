package mc222ap_TheHangmanGame;

import java.util.Scanner;

public class DifficultyMenu {

    private String easyOption = "1";
    private String mediumOption = "2";
    private String hardOption = "3";
    private Word theWord;

    public DifficultyMenu() {

        displayMenu();
    }

    public void displayMenu() {
        System.out.println("Chose difficulty level:" + "\n1. Easy\n2. Medium\n3. Hard");
        getWord();
    }

    public Word getTheWord() {
        return theWord;
    }

    public String getEasyOption() {
        return easyOption;
    }

    public String getMediumOption() {
        return mediumOption;
    }

    public String getHardOption() {
        return hardOption;
    }

    private Word getWord() {
        Scanner optionScanner = new Scanner(System.in);
        theWord = new Word();

        optionScanner.close();

        return theWord;
    }
}
