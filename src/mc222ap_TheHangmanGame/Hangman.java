package mc222ap_TheHangmanGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Hangman creates a representation of a hangman game.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class Hangman {

    private String selectedWord;
    private ArrayList<String> letterList = new ArrayList<>();
    private final ArrayList<String> guessList = new ArrayList<>();
    private final ArrayList<String> guessedLetters = new ArrayList<>();
    private Player theGamer;
    // The number of guesses the player gets
    private int guesses = 10;
    private int correctLetters = 0;
    //Game menu
    private final String quitGame = "QUIT";
    private final String backToMenu = "MENU";
    private final String yes = "Y";
    private final String no = "N";

    boolean inTesting = false;
    boolean playing = false;
    boolean wrongLetter = true;
    private Scanner scanner;


    public Hangman(String word) {
        this.selectedWord = word;
    }

    void startMenu() {
        System.out.println("\nWelcome to Hangman v1.0");
        final GameMenu menu = new GameMenu();

        final Scanner scanner = new Scanner(System.in);
        final String choice = scanner.next();

        if (choice.equals(menu.getStartOption())) {
            letterList = createUnderscores();
            askQuestion();
        } else if (choice.equals(menu.getQuitOption())) {
            endGame();
        } else {
            System.out.println("\nInvalid menu choice.");
            startMenu();
        }
        scanner.close();
    }

    // TODO Complete options for username and difficulty-level
    private void setUpGame() {
        System.out.println("(Type 'Quit' to quit, 'Menu' to return to menu)");

        System.out.print("\nType in a user name: ");

        final Scanner scanner1 = new Scanner(System.in);
        final String username = scanner1.next();

        if (username.toUpperCase().equals(quitGame)) {
            endGame();
        } else if (username.toUpperCase().equals(backToMenu)) {
            startMenu();
        } else {
            theGamer = new Player(username);
            System.out.println("Hello " + theGamer.getUsername());
        }

        // TODO DifficultyMenu diffMenu = new DifficultyMenu();

        createUnderscores();
        scanner1.close();
    }

    /**
     * Takes each letter in the word to guess and adds it to a list.
     * Also adds an underscore per letter to the underscore list.
     *
     * @return ArrayList with each letter.
     */
    ArrayList<String> createUnderscores() {
        for (int i = 0; i < selectedWord.length(); i++) {
            letterList.add(String.valueOf(selectedWord.charAt(i)));
            guessList.add("_ ");
        }
        return letterList;
    }

    private void askQuestion() {
        playing = true;
        System.out.println("Word to guess:");
        String prettyUnderscore = prettyPrintedList(guessList);
        System.out.println(prettyUnderscore);
        System.out.println("\nNumber of guesses left: " + guesses);
        System.out.print("Guess letter: ");

        evaluateGuess(scanUserInput());
    }


    private String scanUserInput() {
        scanner = new Scanner(System.in);
        final String input = scanner.next().toUpperCase();

        if (input.equals(quitGame)) {
            endGame();
        } else if (input.equals(backToMenu)) {
            resetGame();
            startMenu();
        }
        return input;
    }

    // TODO implement check if the player types more than one letter.

    /**
     * Checks if the letter guessed by the player is present in the current word.
     * Also checks if the letter has already been guessed.
     */
    void evaluateGuess(String guess) {
        if (playing) {

            if (!guessedLetters.contains(guess)) {
                guessedLetters.add(guess);
            } else {
                System.out.println("You've already guessed " + guess + ". Guess again!");
                evaluateGuess(scanUserInput());
            }

            for (int i = 0; i < letterList.size(); i++) {
                if (letterList.get(i).equals(guess)) {
                    guessList.set(i, guess);
                    wrongLetter = false;
                    correctLetters++;
                }
            }

            if (wrongLetter) {
                System.out.println("Incorrect letter.");
            }
            if (!inTesting) {
                System.out.println("Guessed letters: " + prettyPrintedList(guessedLetters));
                guesses--;
                result();
                scanner.close();
            }
        }
    }

    /**
     *
     */
    private void result() {

        if (guesses >= 0) {
            if (correctLetters == letterList.size()) {
                roundWon();
            } else {
                if (guesses > 0) {
                    askQuestion();
                } else {
                    gameOver();
                }
            }
        }
    }

    /**
     *
     */
    private void newGame() {
        System.out.println("Start new game? (Y/N)");

        final Scanner scanner2 = new Scanner(System.in);
        final String answer = scanner2.next().toUpperCase();

        if (answer.equals(yes)) {
            letterList = createUnderscores();
            askQuestion();
        } else if (answer.equals(no)) {
            System.out.println("Thanks for playing Hangman! Goodbye.");
            playing = false;
        } else {
            System.out.println("Invalid option, please pick Y or N");
            newGame();
        }
        scanner2.close();
    }

    String prettyPrintedList(final ArrayList<String> list) {
        return list.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    // TODO Implement drawing of hangman

    /**
     * Draws next part of the hangman if the guess was incorrect.
     */
    String drawHangman() {
//        if (wrongLetter){
//            return "__________";
//        }
        return "";
    }

    /**
     * Displays result of round if player has guessed the whole word correctly.
     * Also gives the option to start new round, or end game.
     */
    private void roundWon() {
        System.out.println(prettyPrintedList(letterList));
        System.out.println("Correct! You Won!\nYou used " + (10 - guesses) + " guesses.");

        resetGame();
        newGame();
    }

    /**
     * Displays game over if the player has failed to guess the word, as well as the correct word.
     * Gives the option to start a new game.
     */
    private void gameOver() {
        System.out.println("No more guesses! Game over");
        System.out.println("Correct word was: " + prettyPrintedList(letterList));
        playing = false;
        resetGame();
        newGame();
    }

    private void resetGame() {
        letterList.clear();
        guessList.clear();
        guesses = 10;
        correctLetters = 0;
        guessedLetters.clear();
    }

    private void endGame() {
        System.out.println("Are you sure you want to quit? (Y/N)");

        final Scanner scanner3 = new Scanner(System.in);
        final String answer = scanner3.next().toUpperCase();

        if (answer.equals(no)) {
            if (playing) {
                askQuestion();
            } else {
                startMenu();
            }
        } else if (answer.equals(yes)) {
            playing = false;
            resetGame();
            System.out.println("Thank you for playing Hangman! Goodbye.");
        }
        scanner3.close();
    }

    public String getSelectedWord() {
        return selectedWord;
    }

    public ArrayList<String> getLetterList() {
        return letterList;
    }

    public ArrayList<String> getGuessList() {
        return guessList;
    }

    public ArrayList<String> getGuessedLetters() {
        return guessedLetters;
    }

    public Player getTheGamer() {
        return theGamer;
    }

    public int getGuesses() {
        return guesses;
    }

    public int getCorrectLetters() {
        return correctLetters;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
