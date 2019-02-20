package mc222ap_TheHangmanGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Hangman creates a representation of a hangman game.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class Hangman {

    private ArrayList<String> wordList = new ArrayList<>();
    private ArrayList<String> letterList = new ArrayList<>();
    private ArrayList<String> underscores = new ArrayList<>();

    // The number of guesses the player gets
    private int guesses = 10;
    private Scanner wordScanner;
    private int correctLetters = 0;

    {
        try {
            wordScanner = new Scanner(new File("/Users/amandacirverius/Documents/Melinas/minaord.txt"));

        } catch (
                FileNotFoundException e) {
            System.out.println("File could not be read!");
        }

    }

    public Hangman() {
        startMenu();
    }

    /**
     * Returns the number of guesses left in current round.
     *
     * @return int of the number of guesses.
     */
    public int getGuesses() {
        return guesses;
    }

    /**
     * Sets up a new game with a random selected word and presents this to the player as underscores.
     *
     * @param words - the file to read a random word from.
     */
    public void startGame(File words) {

    }

    private void startMenu() {
        System.out.println("\nWelcome to Hangman v1.0");
        GameMenu menu = new GameMenu();
        System.out.print(menu.showMenu());

        Scanner scanner = new Scanner(System.in);

        String choice = scanner.next();

        if (choice.equals(menu.getStartOption())) {
            getWord();
        } else if (choice.equals(menu.getQuitOption())) {
            quitGame();
        } else {
            System.out.println("\nInvalid menu choice.");
            System.out.println(menu.showMenu());
        }
        scanner.close();
    }

    private void setUpGame() {
        System.out.println("Type 'Quit' to quit, 'Menu' to return to menu");

        System.out.print("\nType in a user name: ");

        Scanner nameScanner = new Scanner(System.in);

        String username = nameScanner.nextLine();

        Player theGamer = new Player(username);

        System.out.println("Chose difficulty level:" +
                "\n1. Easy\n2. Medium\n3. Hard");

        String difficulty = nameScanner.next();

        nameScanner.close();
    }

    private void getWord() {

//        while (wordScanner.hasNext()) {
//            String word = wordScanner.nextLine();
//
//            wordList.add(word);
//        }
//        wordScanner.close();

        Words word = new Words();

        String selectedWord = word.getWordToGuess;
        for (int i = 0; i < selectedWord.length(); i++) {
            letterList.add(String.valueOf(selectedWord.charAt(i)));
            underscores.add("_ ");
        }

        askQuestion();
    }

    private void quitGame() {

    }

    private void askQuestion() {
        System.out.println("Word to guess:");
        String prettyUnderscore = getUnderscores(underscores);
        System.out.println(prettyUnderscore);
        System.out.println("\nNumber of guesses left: " + guesses);
        System.out.print("Guess letter: ");

        evaluateGuess();
    }

    private String getUnderscores(final ArrayList<String> list) {
        return list.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    /**
     * Checks if the letter guessed by the player is present in the current word.
     *
     * @return boolean - true if letter is present in word.
     */
    private void evaluateGuess() {

        Scanner guessScan = new Scanner(System.in);
        boolean wrongLetter = true;

        String guess = guessScan.next().toUpperCase();

        for (int i = 0; i < letterList.size(); i++) {
            if (letterList.get(i).equals(guess)) {
                underscores.set(i, guess);
                wrongLetter = false;
                correctLetters++;
            }
        }
        if (wrongLetter) {
            System.out.println("Incorrect letter.");
        }

        guesses--;
        result();
        guessScan.close();

    }

    /**
     * Updates lettersList if guess was correct and displays the current state of the lettersList as well as current number of guesses.
     */
    private void result() {

        if (guesses > 0) {
            if (correctLetters == letterList.size()) {
                roundWon();
            } else {
                askQuestion();
            }
        } else {
            gameOver();
        }
    }

    /**
     * Draws next part of the hangman if the guess was incorrect.
     */
    private void drawHangman() {
    }

    /**
     * Displays game over if the player has failed to guess the lettersList. Gives the option to start a new game.
     */
    private void gameOver() {
        System.out.println("No more guesses! Game over");
        System.out.println("Correct word was: " + getUnderscores(letterList));

        newGame();
    }

    /**
     * Displays result of round if player has guessed the whole lettersList correctly.
     * Also gives the option to start new round, or end game.
     */
    private void roundWon() {
        System.out.println(getUnderscores(letterList));
        System.out.println("Correct! You Won! \n You used " + correctLetters + " guesses.");

        newGame();
    }

    /**
     *
     */
    private void newGame() {
        System.out.println("Start new game? (Y/N)");

        Scanner scanner = new Scanner(System.in);

        String answer = scanner.next().toUpperCase();

        if (answer.equals("Y")) {
            startMenu();
        } else if (answer.equals("N")) {
            System.out.println("Goodbye");
        } else {
            System.out.println("Invalid option, please pick Y or N");
            roundWon();
        }

        scanner.close();
    }

    /**
     * Checks how many underscoreList are left to guess in current lettersList, if none calls round won.
     */
    private void lettersLeft() {

    }
}
