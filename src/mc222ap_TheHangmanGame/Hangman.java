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

    private final ArrayList<String> letterList = new ArrayList<>();
    private final ArrayList<String> underscores = new ArrayList<>();
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

    private boolean playing = false;

    public Hangman() {

        startMenu();
    }

    private void startMenu() {
        System.out.println("\nWelcome to Hangman v1.0");
        final GameMenu menu = new GameMenu();

        final Scanner scanner = new Scanner(System.in);
        final String choice = scanner.next();

        if (choice.equals(menu.getStartOption())) {
            createUnderscores();
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

        final Scanner scanner = new Scanner(System.in);
        final String username = scanner.next();

        if (username.toUpperCase().equals(quitGame)) {
            endGame();
        } else if (username.toUpperCase().equals(backToMenu)) {
            startMenu();
        } else {
            System.out.println("Test");
            theGamer = new Player(username);
            System.out.println("Hello " + theGamer.getUsername());
        }

        // TODO DifficultyMenu diffMenu = new DifficultyMenu();

        createUnderscores();
        scanner.close();
    }

    private void createUnderscores() {
        final Word word = new Word();

        final String selectedWord = word.getWordToGuess();
        for (int i = 0; i < selectedWord.length(); i++) {
            letterList.add(String.valueOf(selectedWord.charAt(i)));
            underscores.add("_ ");
        }

        askQuestion();
    }

    private void askQuestion() {
        playing = true;
        System.out.println("Word to guess:");
        String prettyUnderscore = prettyPrintedList(underscores);
        System.out.println(prettyUnderscore);
        System.out.println("\nNumber of guesses left: " + guesses);
        System.out.print("Guess letter: ");

        evaluateGuess();
    }

    /**
     * Checks if the letter guessed by the player is present in the current word.
     */
    private void evaluateGuess() {
        boolean wrongLetter = true;

        final Scanner scanner = new Scanner(System.in);
        final String guess = scanner.next().toUpperCase();

        if (guess.equals(quitGame)) {
            endGame();
            return;
        } else if (guess.equals(backToMenu)) {
            resetGame();
            startMenu();
            return;
        }

        if (!guessedLetters.contains(guess)) {
            guessedLetters.add(guess);
        } else {
            System.out.println("You've already guessed " + guess + ". Guess again!");
            evaluateGuess();
        }

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
        System.out.println("Guessed letters: " + prettyPrintedList(guessedLetters));
        guesses--;
        result();
        scanner.close();
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

        final Scanner scanner = new Scanner(System.in);
        final String answer = scanner.next().toUpperCase();

        if (answer.equals(yes)) {
            createUnderscores();
        } else if (answer.equals(no)) {
            System.out.println("Thanks for playing Hangman! Goodbye.");
            playing = false;
        } else {
            System.out.println("Invalid option, please pick Y or N");
            newGame();
        }
        scanner.close();
    }

    private String prettyPrintedList(final ArrayList<String> list) {
        return list.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    // TODO Implement drawing of hangman

    /**
     * Draws next part of the hangman if the guess was incorrect.
     */
    private void drawHangman() {
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

        resetGame();
        newGame();
    }

    private void resetGame() {
        letterList.clear();
        underscores.clear();
        guesses = 10;
        correctLetters = 0;
        guessedLetters.clear();
    }

    private void endGame() {
        System.out.println("Are you sure you want to quit? (Y/N)");

        final Scanner scanner = new Scanner(System.in);
        final String answer = scanner.next().toUpperCase();

        if (answer.equals(no)) {
            if (playing) {
                askQuestion();
            } else {
                startMenu();
            }
        } else if (answer.equals(yes)) {
            playing = false;
            resetGame();
            System.out.println("Thanks for playing Hangman! Goodbye.");
        }
        scanner.close();
    }
}
