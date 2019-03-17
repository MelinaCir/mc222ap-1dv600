package mc222ap_TheHangmanGame;

import java.util.Scanner;

/**
 * Class HangmanGame creates a representation of a hangman game.
 *
 * @author Melina Cirverius
 * @version 1.0
 */
public class HangmanGame {

    private Player theGamer;
    private GuessHandler guessHandler;
    private Hangman hangman;

    //Game menu
    private final String quitGame = "QUIT";
    private final String backToMenu = "MENU";
    private final String yes = "Y";
    private final String no = "N";

    boolean playing = false;
    private Scanner scanner;


    public HangmanGame(final GuessHandler guessHandler)
    {
        this.guessHandler = guessHandler;
    }

    void startMenu()
    {
        System.out.println("\nWelcome to Hangman v1.0");
        final GameMenu menu = new GameMenu();

        final Scanner scanner = new Scanner(System.in);
        final String choice = scanner.next();

        if (choice.equals(menu.getStartOption()))
        {
            guessHandler.createUnderscores();
            askQuestion();
        } else if (choice.equals(menu.getQuitOption()))
        {
            endGame();
        } else
        {
            System.out.println("\nInvalid menu choice.");
            startMenu();
        }
        scanner.close();
    }

    // TODO Complete options for username and difficulty-level
    private void setUpGame()
    {
        System.out.println("(Type 'Quit' to quit, 'Menu' to return to menu)");

        System.out.print("\nType in a user name: ");

        final Scanner scanner1 = new Scanner(System.in);
        final String username = scanner1.next();

        if (username.toUpperCase().equals(quitGame))
        {
            endGame();
        } else if (username.toUpperCase().equals(backToMenu))
        {
            startMenu();
        } else
        {
            theGamer = new Player(username);
            System.out.println("Hello " + theGamer.getUsername());
        }

        // TODO DifficultyMenu diffMenu = new DifficultyMenu();

        guessHandler.createUnderscores();
        scanner1.close();
    }

    private void askQuestion()
    {
        playing = true;
        System.out.println("Word to guess:");
//        String prettyUnderscore = prettyPrintedList(guessList);
        String prettyGuess = guessHandler.getPrettyGuess();
        System.out.println(prettyGuess);
        System.out.println("\nNumber of guesses left: " + guessHandler.getGuesses());
        System.out.print("Guess letter: ");

        boolean success = guessHandler.evaluateGuess(scanUserInput(), playing);
        while (!success)
        {
            success = guessHandler.evaluateGuess(scanUserInput(), playing);
        }
        System.out.println("Guessed letters: " + guessHandler.getPrettyGuessedLetter());
        result();
        scanner.close();

    }


    private String scanUserInput()
    {
        scanner = new Scanner(System.in);
        final String input = scanner.next().toUpperCase();

        if (input.equals(quitGame))
        {
            endGame();
        } else if (input.equals(backToMenu))
        {
            guessHandler.reset();
            startMenu();
        }
        return input;
    }

    /**
     *
     */
    private void result()
    {
        int guesses = guessHandler.getGuesses();
        int wrongGuesses = guessHandler.getWrongGuesses();

        if (guesses >= 0)
        {
            if (guessHandler.getCorrectLetters() == guessHandler.getLetterList().size())
            {
                roundWon();
            } else
            {
                if (guesses > 0)
                {
                    askQuestion();
                } else
                {
                    gameOver();
                }
            }
        }
    }

    /**
     *
     */
    private void newGame()
    {
        System.out.println("Start new game? (Y/N)");

        final Scanner scanner2 = new Scanner(System.in);
        final String answer = scanner2.next().toUpperCase();

        if (answer.equals(yes))
        {
            guessHandler.createUnderscores();
            askQuestion();
        } else if (answer.equals(no))
        {
            System.out.println("Thanks for playing Hangman! Goodbye.");
            playing = false;
        } else
        {
            System.out.println("Invalid option, please pick Y or N");
            newGame();
        }
        scanner2.close();
    }

    // TODO Implement drawing of hangman

    /**
     * Draws next part of the hangman if the guess was incorrect.
     */
    String drawHangman()
    {
//        if (wrongLetter){
//            return "__________";
//        }

        return "";
    }

    /**
     * Displays result of round if player has guessed the whole word correctly.
     * Also gives the option to start new round, or end game.
     */
    private void roundWon()
    {
        System.out.println(guessHandler.getPrettyLetterList());
        System.out.println("Correct! You Won!\nYou used " + (10 - guessHandler.getGuesses()) + " guesses.");

        guessHandler.reset();
        newGame();
    }

    /**
     * Displays game over if the player has failed to guess the word, as well as the correct word.
     * Gives the option to start a new game.
     */
    private void gameOver()
    {
        System.out.println("No more guesses! Game over");
        System.out.println("Correct word was: " + guessHandler.getPrettyLetterList());
        playing = false;
        resetGame();
        newGame();
    }

    private void resetGame()
    {
        guessHandler.reset();
    }

    private void endGame()
    {
        System.out.println("Are you sure you want to quit? (Y/N)");

        final Scanner scanner3 = new Scanner(System.in);
        final String answer = scanner3.next().toUpperCase();

        if (answer.equals(no))
        {
            if (playing)
            {
                askQuestion();
            } else
            {
                startMenu();
            }
        } else if (answer.equals(yes))
        {
            playing = false;
            resetGame();
            System.out.println("Thank you for playing Hangman! Goodbye.");
        } else
        {
            System.out.println("Invalid option, please pick Y or N");
            endGame();
        }
        scanner3.close();
    }

    public Scanner getScanner()
    {
        return scanner;
    }

}
